package com.programmic.twechy.githublap.Local_Model.Car;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cars")
public class Local_Car {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "car_name")
    public String name;

    @ColumnInfo(name = "car_model")
    public String carModel;

    @ColumnInfo(name = "car_price")
    public String price;

    @ColumnInfo(name = "car_state")
    public String state;

    @ColumnInfo(name = "location_id")
    public String locationId;

    @ColumnInfo(name = "user_id")
    public String userId;

    @ColumnInfo(name = "car_info_id")
    public String carInfoId;

    public Local_Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(String carInfoId) {
        this.carInfoId = carInfoId;
    }
}
