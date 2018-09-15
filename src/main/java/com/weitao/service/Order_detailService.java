package com.weitao.service;

import com.weitao.bean.Order_detail;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
public interface Order_detailService {
    List<Order_detail> getOrderDetail(int orderId);
}
