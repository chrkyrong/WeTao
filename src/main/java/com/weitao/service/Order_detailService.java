package com.weitao.service;

import com.weitao.bean.Order_detail;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
public interface Order_detailService {

    List<Order_detail> getOrderDetail(int orderId);//根据订单id查询订单详情关联查询商品信息
}
