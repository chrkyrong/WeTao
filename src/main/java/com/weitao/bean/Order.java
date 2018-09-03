package com.weitao.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer oId;

    private Integer sellerId;

    private Integer userId;

    private Byte oPost;

    private BigDecimal oPrice;

    private Date oDate;

    private Byte oStatus;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}