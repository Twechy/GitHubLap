package com.programmic.twechy.githublap.Error;

/**
 * Created by jamal on 09-02-2018.
 */

public class ApiError {

    private int statusCode;
    private String endPoint;
    private String message= "Unknown error.";

    public int getStatusCode() {
        return statusCode;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getMessage() {
        return message;
    }
}
