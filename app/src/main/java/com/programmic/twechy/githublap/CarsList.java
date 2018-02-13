package com.programmic.twechy.githublap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.programmic.twechy.githublap.Api.ApiClient;
import com.programmic.twechy.githublap.Api.CarApi;
import com.programmic.twechy.githublap.POJO_Models.Cars.CarCallBack;
import com.programmic.twechy.githublap.POJO_Models.Cars.CarsResponse;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CarsList extends AppCompatActivity {

    private static final String TAG = CarsList.class.getSimpleName();

    CarApi carApi;
    Observable<CarCallBack> carInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_list);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.getAllCars)
    public void onGetAllCarsClicked() {
        carApi = ApiClient.getApiClient().create(CarApi.class);
        carInfo = carApi.displayAllCars();

        carInfo
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CarCallBack>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (!d.isDisposed()) {
                            Log.d(TAG, "onSubscribe: not disposed");
                        }
                    }

                    @Override
                    public void onNext(CarCallBack carsCallBack) {

                        CarsResponse response1;

                        if (carsCallBack.getSuccess() == 1) {
                            List<CarsResponse> carsDetails = carsCallBack.getCarsResponse();
                            response1 = CarsResponse.toObject(carsDetails);
                            for (CarsResponse response : carsDetails) {

                                String s = response.toString();
                                Log.d(TAG, "onNext() called with: carsCallBack = [" + response1.toString() + "]");
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete() called");
                    }
                });
    }

    @OnClick(R.id.getUserCars)
    public void onGetUserCarsClicked() {

        carApi = ApiClient.getApiClient().create(CarApi.class);
        carInfo = carApi.getUserCars(13);

        carInfo
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CarCallBack>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CarCallBack carCallBack) {
                        if (carCallBack.getSuccess() == 1) {

                            List<CarsResponse> carsResponse = carCallBack.getCarsResponse();
                            CarsResponse response = CarsResponse.toObject(carsResponse);

                            Log.d(TAG, "onNext() called with: carCallBack = [" + response.toString() + "]");


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


    }
}

















