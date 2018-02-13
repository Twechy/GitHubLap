
package com.programmic.twechy.githublap.POJO_Models.Cars;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarCallBack {

    @SerializedName("CarsResponse")
    private List<com.programmic.twechy.githublap.POJO_Models.Cars.CarsResponse> mCarsResponse;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private Long mSuccess;

    public List<com.programmic.twechy.githublap.POJO_Models.Cars.CarsResponse> getCarsResponse() {
        return mCarsResponse;
    }

    public void setCarsResponse(List<com.programmic.twechy.githublap.POJO_Models.Cars.CarsResponse> CarsResponse) {
        mCarsResponse = CarsResponse;
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
