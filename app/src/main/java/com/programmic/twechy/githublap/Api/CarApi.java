package com.programmic.twechy.githublap.Api;


import com.programmic.twechy.githublap.POJO_Models.Cars.CarCallBack;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CarApi {

    @GET("cars/display_all_cars.php")
    Observable<CarCallBack> displayAllCars();

    @FormUrlEncoded
    @POST("cars/get_user_cars.php")
    Observable<CarCallBack> getUserCars(@Field("user_id")int id);

}
