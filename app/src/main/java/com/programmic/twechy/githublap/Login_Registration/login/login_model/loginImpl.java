package com.programmic.twechy.githublap.Login_Registration.login.login_model;

import android.text.TextUtils;
import android.util.Log;

import com.programmic.twechy.githublap.Api.ApiClient;
import com.programmic.twechy.githublap.Api.UserApi;
import com.programmic.twechy.githublap.Login_Registration.login.login_presenter.LoginPresenter;
import com.programmic.twechy.githublap.Login_Registration.login.login_view.LoginView;
import com.programmic.twechy.githublap.POJO_Models.Login.LoginCallBack;
import com.programmic.twechy.githublap.POJO_Models.Login.LoginResponse;
import com.programmic.twechy.githublap.POJO_Models.Users.UserCallBack;
import com.programmic.twechy.githublap.POJO_Models.Users.UserResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class loginImpl implements LoginPresenter {

    public static List<UserResponse> userResponses = new ArrayList<>();
    private LoginView mLoginView;
    private UserApi userApi;
    private Single<LoginCallBack> call;
    private Observable<UserCallBack> userCall;
    private String id;
    String TAG = "TAG";

    public loginImpl(LoginView loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public void preformLogin(String userName, String password) {

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {

            mLoginView.loginValidation();
        } else {

            loginUser(userName, password);
        }
    }

    private void loginUser(String userName, String password) {

        userApi = ApiClient.getApiClient().create(UserApi.class);

        call = userApi.addLoginUserObserv(userName, password);

        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<LoginCallBack>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(LoginCallBack loginCallBack) {

                        if (loginCallBack.getSuccess() == 1) {

                            List<LoginResponse> response = loginCallBack.getResponse();
                            for (LoginResponse r : response) {
                                id = r.getId();
                                Log.d("Tag", "onSuccess: id: " + id);
                            }
                            userCall = userApi.fetchUser2(id);
                            userCall.subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<UserCallBack>() {
                                        @Override
                                        public void onSubscribe(Disposable d) {
                                            if (!d.isDisposed()) {
                                                //d.dispose();
                                            }
                                        }
                                        @Override
                                        public void onNext(UserCallBack userCallBackCallBack) {
                                            if (userCallBackCallBack.getSuccess() == 1) {
                                                List<UserResponse> userResponses = userCallBackCallBack.getDetails();
                                                Log.d(TAG, "onNext: " + userResponses.toString());
                                                UserResponse userResponse = new UserResponse();
                                                for (UserResponse r : userResponses) {
                                                    userResponse = new UserResponse(
                                                            r.getUserID(), r.getName(), r.getLastname(), r.getAge(),
                                                            r.getMobile(), r.getEmail(), r.getJob(), r.getPath(),
                                                            r.getDate()
                                                    );
                                                    Log.d(TAG, "userResponse: "+userResponse.toString());
                                                }
                                                loginImpl.userResponses.add(userResponse);
                                                Log.d(TAG, "onNext: data from list is: " + loginImpl.userResponses.toString());
                                                mLoginView.loginSuccess();

                                            } else {
                                                mLoginView.loginError();
                                            }


                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            e.getMessage();
                                        }

                                        @Override
                                        public void onComplete() {

                                        }
                                    });
                        } else {

                            mLoginView.loginError();
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }
                });
    }


}
