package com.programmic.twechy.githublap.Local_Model.Login;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "login")
public class Local_LoginUser {

    @PrimaryKey(autoGenerate = true)
    public int mId;
    @ColumnInfo(name = "user_name")
    public String mUserName;
    @ColumnInfo(name = "password")
    public String mPassword;

    public Local_LoginUser() {
    }

    @Ignore
    public Local_LoginUser(String mUserName, String mPassword) {
        this.mUserName = mUserName;
        this.mPassword = mPassword;
    }

    @Ignore
    public Local_LoginUser(int mId, String mUserName, String mPassword) {
        this.mId = mId;
        this.mUserName = mUserName;
        this.mPassword = mPassword;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
