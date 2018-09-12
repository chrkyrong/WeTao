package com.weitao.bean;

public class Seller {
    private Integer sId;

    private String sAccount;

    private String sPassword;

    private String sTel;

    private String sAddress;

    private String sIcon;

    private String sSex;

    private Byte sStutas;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsAccount() {
        return sAccount;
    }

    public void setsAccount(String sAccount) {
        this.sAccount = sAccount == null ? null : sAccount.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel == null ? null : sTel.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public String getsIcon() {
        return sIcon;
    }

    public void setsIcon(String sIcon) {
        this.sIcon = sIcon == null ? null : sIcon.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public Byte getsStutas() {
        return sStutas;
    }

    public void setsStutas(Byte sStutas) {
        this.sStutas = sStutas;
    }
}