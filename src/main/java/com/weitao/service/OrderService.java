package com.weitao.service;

import com.weitao.bean.Order;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
public interface OrderService {
    List<Order> getByUser1(int userId);//根据用户id查询待发货订单

    List<Order> getByUser2(int userId);//根据用户id查询已发货订单

    List<Order> getByUser3(int userId);//根据用户id查询已签收订单

}
