package com.programmic.twechy.githublap.UI_Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.programmic.twechy.githublap.Local_Model.User.Local_User;
import com.programmic.twechy.githublap.Local_Repository.UserDatabase;
import com.programmic.twechy.githublap.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class UserList extends AppCompatActivity {

    private static final String TAG = "UserList";
    UserDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        ButterKnife.bind(this);

        db = UserDatabase.getINSTANCE(getApplicationContext());

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {

        Single<List<Local_User>> all = db.userDao().getAll();

        all.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Local_User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Local_User> local_users) {

                        for (Local_User user : local_users) {
                            String s = user.toString();
                            Log.d(TAG, "onSuccess() called with: local_users = [" + s + "]");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }
                });

    }

    @OnClick(R.id.insert)
    public void onViewClicked2() {

        Date date = new Date();
        date.getDate();

        Local_User user1 = new Local_User(
                "ans", "jamal", 27, "0925878808", "ans@gmail.com", date
        );
        Local_User user2 = new Local_User(
                "haret", "jamal", 15, "0910893979", "haret@gmail.com", date
        );

        List<Local_User> local_users = new ArrayList<>();
        local_users.add(user1);
        local_users.add(user2);

        addUsers(local_users);
    }


    public void addUsers(final List<Local_User> local_users) {

        //works fine
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.userDao().insertAll(local_users);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "run: completed");
                    }
                });
    }
}
