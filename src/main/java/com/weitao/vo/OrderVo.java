package com.weitao.vo;

import com.weitao.bean.Order;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/10/5
 * @Time: 13:41
 **/
public class OrderVo {
    private Order order;
    private String date;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
