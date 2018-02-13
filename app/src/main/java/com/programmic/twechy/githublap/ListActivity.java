package com.programmic.twechy.githublap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programmic.twechy.githublap.Api.ApiClient;
import com.programmic.twechy.githublap.Api.UserApi;
import com.programmic.twechy.githublap.POJO_Models.Users.UserCallBack;
import com.programmic.twechy.githublap.POJO_Models.Users.UserResponse;
import com.programmic.twechy.githublap.Utils.RecyclerAdapter;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        UserApi apiClient = ApiClient.getApiClient().create(UserApi.class);

        Single<UserCallBack> call = apiClient.readData();

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<UserCallBack, Throwable>() {
                    @Override
                    public void accept(UserCallBack users, Throwable throwable) throws Exception {

                        List<UserResponse> userResponses = users.getDetails();
/*
                    for (UserResponse info : userResponses) {

                        UserResponse userInfo = new UserResponse();
                        userInfo = UserResponse.findById(UserResponse.class, info.getId());
                        userInfo.setName(info.getName());
                        userInfo.setLastname(info.getLastname());
                        userInfo.setAge(info.getAge());
                        userInfo.setMobile(info.getMobile());
                        userInfo.setEmail(info.getEmail());
                        userInfo.setJob(info.getJob());
                        userInfo.setDate(info.getDate());
                        Log.d(TAG, "onCreate: userInfo Saved to db :"+userInfo.toString());
                        userInfo.save();
                    }*/


                        recyclerAdapter = new RecyclerAdapter(ListActivity.this.getApplicationContext(), userResponses);
                        recyclerView.setAdapter(recyclerAdapter);


                    }
                });


    }
}
