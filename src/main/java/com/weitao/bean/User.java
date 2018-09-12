package com.weitao.bean;

public class User {
    private Integer uId;

    private String uPassword;

    private String uUserName;

    private String uTel;

    private String uAddress1;

    private String uAddress2;

    private String uAddress3;

    private String uIcon;

    private String uSex;

    private Byte uStatus;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuUserName() {
        return uUserName;
    }

    public void setuUserName(String uUserName) {
        this.uUserName = uUserName == null ? null : uUserName.trim();
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel == null ? null : uTel.trim();
    }

    public String getuAddress1() {
        return uAddress1;
    }

    public void setuAddress1(String uAddress1) {
        this.uAddress1 = uAddress1 == null ? null : uAddress1.trim();
    }

    public String getuAddress2() {
        return uAddress2;
    }

    public void setuAddress2(String uAddress2) {
        this.uAddress2 = uAddress2 == null ? null : uAddress2.trim();
    }

    public String getuAddress3() {
        return uAddress3;
    }

    public void setuAddress3(String uAddress3) {
        this.uAddress3 = uAddress3 == null ? null : uAddress3.trim();
    }

    public String getuIcon() {
        return uIcon;
    }

    public void setuIcon(String uIcon) {
        this.uIcon = uIcon == null ? null : uIcon.trim();
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public Byte getuStatus() {
        return uStatus;
    }

    public void setuStatus(Byte uStatus) {
        this.uStatus = uStatus;
    }
}