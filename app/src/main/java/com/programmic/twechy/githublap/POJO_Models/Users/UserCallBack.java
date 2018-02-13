
package com.programmic.twechy.githublap.POJO_Models.Users;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserCallBack {

    @SerializedName("response")
    private List<UserResponse> mUserResponses;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private Long mSuccess;

    public List<UserResponse> getDetails() {
        return mUserResponses;
    }

    public void setDetails(List<UserResponse> userResponses) {
        mUserResponses = userResponses;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Long getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Long success) {
        mSuccess = success;
    }

}
