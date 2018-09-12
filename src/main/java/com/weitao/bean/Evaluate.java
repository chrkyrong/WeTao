package com.weitao.bean;

public class Evaluate {
    private Integer eId;

    private Byte eLevel;

    private String ePhotos;

    private Integer orderId;

    private Integer storeId;

    private Integer userId;

    private Integer itemsId;

    private String eDescription;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Byte geteLevel() {
        return eLevel;
    }

    public void seteLevel(Byte eLevel) {
        this.eLevel = eLevel;
    }

    public String getePhotos() {
        return ePhotos;
    }

    public void setePhotos(String ePhotos) {
        this.ePhotos = ePhotos == null ? null : ePhotos.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription == null ? null : eDescription.trim();
    }
}