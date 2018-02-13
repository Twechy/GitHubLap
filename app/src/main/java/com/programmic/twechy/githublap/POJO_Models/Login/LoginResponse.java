package com.programmic.twechy.githublap.POJO_Models.Login;

import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("id")
    private String mId;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("username")
    private String mUsername;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "mId='" + mId + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mUsername='" + mUsername + '\'' +
                '}';
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
