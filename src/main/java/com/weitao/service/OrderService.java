package com.weitao.service;

import com.github.pagehelper.PageInfo;
import com.weitao.bean.Car;
import com.weitao.bean.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by lzr on 2018/9/15.
 */
public interface OrderService {
    List<Order> getByUser1(int userId);//根据用户id查询待发货订单

    List<Order> getByUser2(int userId);//根据用户id查询已发货订单

    List<Order> getByUser3(int userId);//根据用户id查询已签收订单

    List<Order> getByUser4(int userId);//根据用户id查询退款中订单

    List<Order> getByUser(int userId);//根据用户id查询所有订单

    Boolean confirmOrder(int oId);//根据订单id确定订单

    Boolean refundOrder(int oId);//根据订单id申请退款

    Boolean cancelOrder(int oId);//根据订单id取消订单

    List<Order> order(List<Car> car);

    PageInfo get1(Map<String,Object> map, int pageNum, int pageSize);//分页查询订单信息

}
