
package com.programmic.twechy.githublap.POJO_Models.NCallBack;

import com.google.gson.annotations.SerializedName;


public class NCallBack {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private Long mSuccess;

    @Override
    public String toString() {
        return "NCallBack{" +
                "mMessage='" + mMessage + '\'' +
                ", mSuccess=" + mSuccess +
                '}';
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
