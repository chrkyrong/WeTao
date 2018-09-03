package com.weitao.bean;

public class Items {
    private Integer iId;

    private String iName;

    private String iPhotos;

    private Integer iExsit;

    private Integer iSale;

    private Byte iStatus;

    private Integer storeId;

    private String iIntrodution;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public String getiPhotos() {
        return iPhotos;
    }

    public void setiPhotos(String iPhotos) {
        this.iPhotos = iPhotos == null ? null : iPhotos.trim();
    }

    public Integer getiExsit() {
        return iExsit;
    }

    public void setiExsit(Integer iExsit) {
        this.iExsit = iExsit;
    }

    public Integer getiSale() {
        return iSale;
    }

    public void setiSale(Integer iSale) {
        this.iSale = iSale;
    }

    public Byte getiStatus() {
        return iStatus;
    }

    public void setiStatus(Byte iStatus) {
        this.iStatus = iStatus;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getiIntrodution() {
        return iIntrodution;
    }

    public void setiIntrodution(String iIntrodution) {
        this.iIntrodution = iIntrodution == null ? null : iIntrodution.trim();
    }
}