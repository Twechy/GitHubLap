package com.programmic.twechy.githublap.POJO_Models.Cars;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsResponse {

    @SerializedName("car_info_id")
    private String mCarInfoId;
    @SerializedName("car_model")
    private String mCarModel;
    @SerializedName("id")
    private String mId;
    @SerializedName("location_id")
    private String mLocationId;
    @SerializedName("name")
    private String mName;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("state")
    private String mState;
    @SerializedName("user_id")
    private String mUserId;

    public CarsResponse(String mCarInfoId, String mCarModel, String mId, String mLocationId, String mName, String mPrice, String mState, String mUserId) {
        this.mCarInfoId = mCarInfoId;
        this.mCarModel = mCarModel;
        this.mId = mId;
        this.mLocationId = mLocationId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mState = mState;
        this.mUserId = mUserId;
    }

    public static CarsResponse toObject(List<CarsResponse> responses) {

        String id = "";
        String name = "";
        String carModel = "";
        String price = "";
        String state = "";
        String locationId = "";
        String userId = "";
        String carInfoId = "";
        for (CarsResponse response : responses) {
            id = response.getId();
            name = response.getName();
            carModel = response.getCarModel();
            price = response.getPrice();
            state = response.getState();
            locationId = response.getLocationId();
            userId = response.getUserId();
            carInfoId = response.getCarInfoId();
        }
        return new CarsResponse(
                id, name, carModel, price, state, locationId, userId, carInfoId
        );
    }

    @Override
    public String toString() {
        return "CarsResponse{" +
                ", mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mCarModel='" + mCarModel + '\'' +
                ", mState='" + mState + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mUserId='" + mUserId + '\'' +
                "mCarInfoId='" + mCarInfoId + '\'' +
                ", mLocationId='" + mLocationId + '\'' +
                '}';
    }

    public String getCarInfoId() {
        return mCarInfoId;
    }

    public void setCarInfoId(String carInfoId) {
        mCarInfoId = carInfoId;
    }

    public String getCarModel() {
        return mCarModel;
    }

    public void setCarModel(String carModel) {
        mCarModel = carModel;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLocationId() {
        return mLocationId;
    }

    public void setLocationId(String locationId) {
        mLocationId = locationId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

}
