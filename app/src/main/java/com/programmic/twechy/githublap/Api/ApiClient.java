package com.programmic.twechy.githublap.Api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.programmic.twechy.githublap.BuildConfig;
import com.programmic.twechy.githublap.Error.ErrorInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_API = "http://172.26.145.49:8080/twechy_app/";

    private static Retrofit.Builder retrofitBuilder = null;
    public static Retrofit retrofit = null;

    private static OkHttpClient.Builder okHttpBuilder;
    private static HttpLoggingInterceptor interceptor;

    public static Retrofit getApiClient() {

        addOkHttpInterceptor();

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        if (retrofitBuilder == null) {
            retrofitBuilder = new Retrofit.Builder().baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpBuilder.build());

            retrofit = retrofitBuilder.build();

        }
        return retrofit;
    }

    private static void addOkHttpInterceptor() {
        okHttpBuilder = new OkHttpClient.Builder()
                .addInterceptor
                        (new ErrorInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        interceptor = new HttpLoggingInterceptor();
    }

}
