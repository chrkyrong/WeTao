package com.weitao.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer oId;

    private Byte oPost;

    private BigDecimal oPrice;

    private Date oDate;

    private Byte oStatus;

    private String oMessage;

    private Integer userId;

    private Integer sellerId;

    private Integer storeId;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Byte getoPost() {
        return oPost;
    }

    public void setoPost(Byte oPost) {
        this.oPost = oPost;
    }

    public BigDecimal getoPrice() {
        return oPrice;
    }

    public void setoPrice(BigDecimal oPrice) {
        this.oPrice = oPrice;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public Byte getoStatus() {
        return oStatus;
    }

    public void setoStatus(Byte oStatus) {
        this.oStatus = oStatus;
    }

    public String getoMessage() {
        return oMessage;
    }

    public void setoMessage(String oMessage) {
        this.oMessage = oMessage == null ? null : oMessage.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}