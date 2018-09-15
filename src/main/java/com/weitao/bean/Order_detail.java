package com.weitao.bean;

public class Order_detail {
    private Integer orDeId;

    private Integer orDeNumber;

    private Integer orderId;

    private Integer itemsId;

    private Items item;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Integer getOrDeId() {
        return orDeId;
    }

    public void setOrDeId(Integer orDeId) {
        this.orDeId = orDeId;
    }

    public Integer getOrDeNumber() {
        return orDeNumber;
    }

    public void setOrDeNumber(Integer orDeNumber) {
        this.orDeNumber = orDeNumber;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"orDeId\":")
                .append(orDeId);
        sb.append(",\"orDeNumber\":")
                .append(orDeNumber);
        sb.append(",\"orderId\":")
                .append(orderId);
        sb.append(",\"itemsId\":")
                .append(itemsId);
        sb.append(",\"item\":")
                .append(item);
        sb.append('}');
        return sb.toString();
    }
}