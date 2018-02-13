package com.programmic.twechy.githublap.Error;

import com.programmic.twechy.githublap.Api.ApiClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static ApiError parseError(Response<?> response){

        Converter<ResponseBody, ApiError> converter =
                ApiClient
                        .retrofit
                        .responseBodyConverter(ApiError.class, new Annotation[0]);
        ApiError error = new ApiError();

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return error;
    }
}
