package com.weitao.bean;

public class Manager {
    private Integer mId;

    private String mPassword;

    private Byte mAuthority;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword == null ? null : mPassword.trim();
    }

    public Byte getmAuthority() {
        return mAuthority;
    }

    public void setmAuthority(Byte mAuthority) {
        this.mAuthority = mAuthority;
    }
}