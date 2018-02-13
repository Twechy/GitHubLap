
package com.programmic.twechy.githublap.POJO_Models.Login;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class LoginCallBack {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("response")
    private List<LoginResponse> mLoginResponse;
    @SerializedName("success")
    private Long mSuccess;

    @Override
    public String toString() {
        return "LoginCallBack{" +
                "mMessage='" + mMessage + '\'' +
                ", mLoginResponse=" + mLoginResponse +
                ", mSuccess=" + mSuccess +
                '}';
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<LoginResponse> getResponse() {
        return mLoginResponse;
    }

    public void setResponse(List<LoginResponse> loginResponse) {
        mLoginResponse = loginResponse;
    }

    public Long getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Long success) {
        mSuccess = success;
    }

}
