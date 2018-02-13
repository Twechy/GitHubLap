package com.programmic.twechy.githublap.Api;

import com.programmic.twechy.githublap.POJO_Models.Login.LoginCallBack;
import com.programmic.twechy.githublap.POJO_Models.NCallBack.NCallBack;
import com.programmic.twechy.githublap.POJO_Models.Users.UserCallBack;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

    // Add new UserCallBack
    @FormUrlEncoded
    @POST("users/insert_user_data.php")
    Single<NCallBack> insertData(
            @Field("name") String name,
            @Field("lastname") String lastName,
            @Field("age") String age,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("job") String job,
            @Field("date") String date,
            @Field("user_id") String userId);

    @FormUrlEncoded
    @POST("users/insert_user_data.php")
    Single<NCallBack> insertDataWithImage(
            @Field("name") String name,
            @Field("lastname") String lastName,
            @Field("age") String age,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("job") String job,
            @Field("date") String date,
            @Field("title") String title,
            @Field("image") String image,
            @Field("user_id") String userId);

    // Display new UserCallBack
    @GET("users/display_all_users.php")
    Single<UserCallBack> readData();

    // Delete user from database
    @FormUrlEncoded
    @POST("deleteData.php")
    void deleteData(
            @Field("id") String id,
            Callback<Response> callback);

    // Update UserCallBack Info
    @FormUrlEncoded
    @POST("updateData.php")
    void updateData(
            @Field("id") String id,
            @Field("name") String name,
            @Field("lastname") String lastName,
            @Field("age") String age,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("job") String job,
            Callback<Response> callback);

    // Get the user From Database
    @FormUrlEncoded
    @POST("users/fetch_user.php")
    Call<UserCallBack> fetchUser(
            @Field("id") String id);

    // Get the user From Database
    @FormUrlEncoded
    @POST("users/fetch_user.php")
    Observable<UserCallBack> fetchUserFromObser(
            @Field("id") String id);

    // Get the user From Database
    @FormUrlEncoded
    @POST("users/fetch_user.php")
    Observable<UserCallBack> fetchUser2(
            @Field("id") String id);

    @GET("text1")
    Call<String> getString();



    // add Nwe Login UserCallBack
    @FormUrlEncoded
    @POST("login/add_login_user.php")
    Single<LoginCallBack> addLoginUser(
            @Field("username") String userName,
            @Field("password") String password
    );




    //Login UserCallBack
    @FormUrlEncoded
    @POST("login/login_user.php")
    Call<LoginCallBack> loginUser2(
            @Field("username") String userName,
            @Field("password") String password);

    //Login UserCallBack
    @FormUrlEncoded
    @POST("login/login_user.php")
    Single<LoginCallBack> addLoginUserObserv(
            @Field("username") String userName,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("login/get_login_user.php")
    Call<LoginCallBack> getLoginUserInfo(
            @Field("username") String userName,
            @Field("password") String password
    );


}
