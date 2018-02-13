package com.programmic.twechy.githublap.Login_Registration.register.register_model;

import android.util.Log;

import com.programmic.twechy.githublap.Api.ApiClient;
import com.programmic.twechy.githublap.Api.UserApi;
import com.programmic.twechy.githublap.Login_Registration.register.register_presenter.RegisterPresenter;
import com.programmic.twechy.githublap.Login_Registration.register.register_view.RegisterView;
import com.programmic.twechy.githublap.POJO_Models.Login.LoginCallBack;
import com.programmic.twechy.githublap.POJO_Models.Login.LoginResponse;
import com.programmic.twechy.githublap.POJO_Models.NCallBack.NCallBack;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterImpl implements RegisterPresenter {

    private static final String TAG = RegisterImpl.class.getSimpleName();
    private RegisterView mRegisterView;

    public RegisterImpl(RegisterView registerView) {
        this.mRegisterView = registerView;
    }

    @Override
    public void registerUserData(String userName, String password, String name, String lastName,
                                 String age, String mobile, String email, String job, String date) {

        if (!userName.isEmpty() && !password.isEmpty()) {
            UserApi userApi = ApiClient.getApiClient().create(UserApi.class);
            Single<LoginCallBack> loginCallBackSingle = userApi.addLoginUser(userName, password);
/*
            loginCallBackSingle.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<LoginCallBack>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(LoginCallBack loginCallBack) {

                            List<LoginResponse> response = loginCallBack.getResponse();

                            String id = "";
                            for (LoginResponse loginResponse : response) {
                                id = loginResponse.getUserID();
                                String username = loginResponse.getUsername();
                                Log.d(TAG, String.format("onSuccess: %s: %s", username, id));
                            }

                            Single<NCallBack> callBackSingle;
                            if (id != null && id.equals("0")) {

                                callBackSingle = userApi
                                        .insertData(name, lastName, age, mobile, email, job, date, id);

                                callBackSingle.subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new SingleObserver<NCallBack>() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onSuccess(NCallBack nCallBack) {
                                                String message = nCallBack.getMessage();
                                                Log.d(TAG, "onSuccess: message: " + message);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                e.getMessage();
                                            }
                                        });
                            }
                        }
                        @Override
                        public void onError(Throwable e) {
                            e.getMessage();
                        }
                    });*/


        }

    }

    @Override
    public void registerUserDataWithImage(String userName, String password, String name, String lastName, String age, String mobile, String email, String job, String title, String image, String date) {

        saveUserData(userName, password, name, lastName,
                age, mobile, email, job, title, image, date);

    }

    private void saveUserData(String userName, String password, final String name, final String lastName,
                              final String age, final String mobile, final String email, final String job, final String title, final String image, final String date) {

        final UserApi userApi = ApiClient.getApiClient().create(UserApi.class);
        Single<LoginCallBack> loginCallBackSingle;

        if (!userName.isEmpty() && !password.isEmpty()) {
            loginCallBackSingle = userApi.addLoginUser(userName, password);

            loginCallBackSingle.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<LoginCallBack>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(LoginCallBack loginCallBack) {

                            List<LoginResponse> response = loginCallBack.getResponse();

                            String id = "";
                            for (LoginResponse loginResponse : response) {
                                id = loginResponse.getId();
                                String username = loginResponse.getUsername();
                                Log.d(TAG, String.format("onSuccess: %s: %s", username, id));
                                Log.d(TAG, "onSuccess: image: " + image);
                            }

                            Single<NCallBack> callBackSingle;
                            if (id != null && !id.equals("-1")) {

                                callBackSingle = userApi
                                        .insertDataWithImage(name, lastName, age, mobile, email, job, date, title, image, id);

                                callBackSingle.subscribeOn(Schedulers.newThread())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new BiConsumer<NCallBack, Throwable>() {
                                            @Override
                                            public void accept(NCallBack nCallBack, Throwable throwable) throws Exception {

                                        String message = nCallBack.getMessage();
                                        Log.d(TAG, "accept: response: " + message);

                                            }
                                        });
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.getMessage();
                        }
                    });


        }

    }


}

/*
if (!userName.isEmpty() && !password.isEmpty()) {
        UserApi user1 = ApiClient.getApiClient().create(UserApi.class);
        Call<LoginCallBack> loginCallBack = user1.addLoginUser(userName, password);
        loginCallBack.enqueue(new Callback<LoginCallBack>() {
@Override
public void onResponse(Call<LoginCallBack> call, Response<LoginCallBack> response) {

        LoginCallBack callBack = response.body();

        if (callBack != null) {

        List<LoginResponse> list = callBack.getResponse();
        String id = null;

        for (LoginResponse s : list) {
        id = s.getUserID();
        }
        UserApi user = ApiClient.getApiClient().create(UserApi.class);
        String date = "2/2/2018";
        Call<NCallBack> normalCallBack = user.insertDataWithImage(name, lastName, age, mobile, email, job, title, image, date, id);
        normalCallBack.enqueue(new Callback<NCallBack>() {
@Override
public void onResponse(Call<NCallBack> call, Response<NCallBack> response) {
        if (response.isSuccessful()) {
        NCallBack callBack = response.body();
        assert callBack != null;
        if (callBack.getMessage().equals("Successfully saved") && callBack.getSuccess() == 1) {
        mRegisterView.registerSuccess();
                            *//*startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                                    .putExtra("userName", finalUserName)
                                    .putExtra("password", finalPassword));*//*
        } else {
        mRegisterView.registerError();
        }
        }
        }

@Override
public void onFailure(Call<NCallBack> call, Throwable t) {

        }
        });
        }
        }

@Override
public void onFailure(Call<LoginCallBack> call, Throwable t) {
        t.printStackTrace();
        }
        });
        }*/
