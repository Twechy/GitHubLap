package com.programmic.twechy.githublap.Local_Model.User;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.programmic.twechy.githublap.Local_Model.Login.Local_LoginUser;

import java.util.Date;

@Entity(tableName = "users")
public class Local_User {

    @PrimaryKey(autoGenerate = true)
    public long mId;
    @ColumnInfo(name = "name")
    public String mName;
    @ColumnInfo(name = "last_name")
    public String mLastName;
    @ColumnInfo(name = "age")
    public int mAge;
    @ColumnInfo(name = "mobile")
    public String mMobile;
    @ColumnInfo(name = "email")
    public String mEmail;
    //@ColumnInfo(name = "date")
    @Ignore
    public Date date;

    @Ignore
    private Local_LoginUser loginUser;

    public Local_User() {
    }

    @Ignore
    public Local_User(String mName, String mLastName, int mAge, String mMobile, String mEmail, Date date) {
        this.mName = mName;
        this.mLastName = mLastName;
        this.mAge = mAge;
        this.mMobile = mMobile;
        this.mEmail = mEmail;
        this.date = date;
    }

    @Ignore
    public Local_User(long mId, String mName, String mLastName, int mAge, String mMobile, String mEmail, Date date, Local_LoginUser loginUser) {
        this.mId = mId;
        this.mName = mName;
        this.mLastName = mLastName;
        this.mAge = mAge;
        this.mMobile = mMobile;
        this.mEmail = mEmail;
        this.date = date;
        this.loginUser = loginUser;
    }

    @Override
    public String toString() {
        return "Local_User{" +
                "date=" + date +
                ", mAge=" + mAge +
                ", mEmail='" + mEmail + '\'' +
                ", mId=" + mId +
                ", mLastName='" + mLastName + '\'' +
                ", mMobile='" + mMobile + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Local_LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Local_LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
