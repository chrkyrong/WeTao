package com.weitao.service;

import com.github.pagehelper.PageInfo;
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

//    edited by CC
//    生成订单(用户id、邮寄方式、收货地址、留言)
    List<Order> addOrder(Integer userId,Byte oPost,String oAddress,String oMessage);

    PageInfo getCondition1(Map<String,Object> map, int pageNum, int pageSize);//分页查询待发货订单信息

    PageInfo get1(int sellerId,int pageNum, int pageSize);//根据卖家id查询待发货订单

    PageInfo getCondition2(Map<String,Object> map, int pageNum, int pageSize);//分页查询待发货订单信息

    PageInfo get2(int sellerId,int pageNum, int pageSize);//根据卖家id查询待发货订单

    PageInfo getCondition3(Map<String,Object> map, int pageNum, int pageSize);//分页查询待发货订单信息

    PageInfo get3(int sellerId, int pageNum, int pageSize);//根据卖家id查询待发货订单

    PageInfo getCondition4(Map<String,Object> map, int pageNum, int pageSize);//分页查询退款中订单信息

    PageInfo get4(int sellerId, int pageNum, int pageSize);//根据卖家id查询退款中订单

    PageInfo getCondition5(Map<String,Object> map, int pageNum, int pageSize);//分页查询退款完成订单信息

    PageInfo get5(int sellerId,int pageNum, int pageSize);//根据卖家id查询退款完成订单

    Boolean sendOrder (int oId);//根据订单id发货
}
