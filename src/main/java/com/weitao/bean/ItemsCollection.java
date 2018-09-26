package com.weitao.bean;

import java.math.BigDecimal;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/19
 * @Time: 14:49
 **/
public class ItemsCollection {
    private Integer cId;
    private Integer itemsId;
    private String iPhotos;
    private String iName;
    private BigDecimal iPrice;

    public ItemsCollection() {
    }

    public ItemsCollection(Integer cId, Integer itemsId, String iPhotos,String iName, BigDecimal iPrice) {
        this.cId = cId;
        this.itemsId = itemsId;
        this.iPhotos = iPhotos;
        this.iName = iName;
        this.iPrice = iPrice;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public String getiPhotos() {
        return iPhotos;
    }

    public void setiPhotos(String iPhotos) {
        this.iPhotos = iPhotos;
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
}
