package com.weitao.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.weitao.utils.CustomDateSerializer;
import com.weitao.utils.DateConverter;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer oId;

    private Byte oPost;

    private BigDecimal oPrice;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date oDate;
    //    订单状态（如，待付款0（默认下单后已付款），待发货1，已发货2，已签收3，退款中4，退款完成5,已评价9等）
    private Byte oStatus;

    private String oMessage;

    private Integer userId;

    private Integer sellerId;

    private Integer storeId;

    private String oAddress;

    private String oExpress;

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getoExpress() {
        return oExpress;
    }

    public void setoExpress(String oExpress) {
        this.oExpress = oExpress;
    }

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"oId\":")
                .append(oId);
        sb.append(",\"oPost\":")
                .append(oPost);
        sb.append(",\"oPrice\":")
                .append(oPrice);
        sb.append(",\"oDate\":\"")
                .append(oDate).append('\"');
        sb.append(",\"oStatus\":")
                .append(oStatus);
        sb.append(",\"oMessage\":\"")
                .append(oMessage).append('\"');
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"sellerId\":")
                .append(sellerId);
        sb.append(",\"storeId\":")
                .append(storeId);
        sb.append(",\"oAddress\":\"")
                .append(oAddress).append('\"');
        sb.append(",\"oExpress\":\"")
                .append(oExpress).append('\"');
        sb.append('}');
        return sb.toString();
    }
}