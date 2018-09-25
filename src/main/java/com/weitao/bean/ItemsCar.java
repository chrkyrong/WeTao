package com.weitao.bean;

import java.math.BigDecimal;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/20
 * @Time: 20:56
 **/
public class ItemsCar {
    private Integer itemsId;
    private String iName;
    private BigDecimal iPrice;
    private String iPhotos;
    private Integer number;
    private BigDecimal totalPrice;

    public ItemsCar() {
    }

    public ItemsCar(Integer itemsId, String iName, BigDecimal iPrice, String iPhoto, Integer number, BigDecimal totalPrice) {
        this.itemsId = itemsId;
        this.iName = iName;
        this.iPrice = iPrice;
        this.iPhotos = iPhoto;
        this.number = number;
        this.totalPrice = totalPrice;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public BigDecimal getiPrice() {
        return iPrice;
    }

    public void setiPrice(BigDecimal iPrice) {
        this.iPrice = iPrice;
    }

    public String getiPhotos() {
        return iPhotos;
    }

    public void setiPhotos(String iPhotos) {
        this.iPhotos = iPhotos;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
