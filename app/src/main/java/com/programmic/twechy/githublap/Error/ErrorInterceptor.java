package com.programmic.twechy.githublap.Error;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ErrorInterceptor implements Interceptor {



    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Response response = chain.proceed((chain.request()));

        if (!response.isSuccessful()) {

            throw new GitHubException(
                    response.code(),
                    response.message());
        }

        return response;
    }
}
