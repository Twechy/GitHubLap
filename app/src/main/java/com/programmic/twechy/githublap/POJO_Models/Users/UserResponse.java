package com.programmic.twechy.githublap.POJO_Models.Users;

import com.google.gson.annotations.SerializedName;
import com.programmic.twechy.githublap.POJO_Models.Login.LoginResponse;

public class UserResponse {

    @SerializedName("age")
    private String mAge;
    @SerializedName("date")
    private String mDate;
    @SerializedName("id")
    private String mId;
    @SerializedName("job")
    private String mJob;
    @SerializedName("lastname")
    private String mLastname;
    @SerializedName("mobile")
    private String mMobile;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("name")
    private String mName;
    @SerializedName("path")
    private String mPath;
    @SerializedName("title")
    private String mTitle;

    private LoginResponse loginResponse;

    public UserResponse() {
    }

    public UserResponse(String id, String name, String lastname, String age, String job, String mobile, String email, String path, String date) {
        this.mId = id;
        this.mName = name;
        this.mLastname = lastname;
        this.mAge = age;
        this.mJob = job;
        this.mMobile = mobile;
        this.mEmail = email;
        this.mPath = path;
        this.mDate = date;
    }

    public UserResponse(String id, String name, String lastname
            , String age, String job, String mobile, String email, String date, LoginResponse loginResponse) {

        this.mAge = age;
        this.mDate = date;
        this.mId = id;
        this.mJob = job;
        this.mLastname = lastname;
        this.mMobile = mobile;
        this.mEmail = email;
        this.mName = name;
        this.loginResponse=loginResponse;

    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "mAge='" + mAge + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mId='" + mId + '\'' +
                ", mJob='" + mJob + '\'' +
                ", mLastname='" + mLastname + '\'' +
                ", mMobile='" + mMobile + '\'' +
                ", mName='" + mName + '\'' +
                ", mPath='" + mPath + '\'' +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        mAge = age;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getUserID() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        mLastname = lastname;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }
}
