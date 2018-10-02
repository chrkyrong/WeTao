package com.weitao.dao;

import com.weitao.bean.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oId);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(Order record);

    List<Order> selectByUser1(int userId);//根据用户id查询待发货订单

    List<Order> selectByUser2(int userId);//根据用户id查询已发货订单

    List<Order> selectByUser3(int userId);//根据用户id查询已签收订单

    List<Order> selectByUser9(int userId);//根据用户id查询已评价订单

    List<Order> selectByUser4(int userId);//根据用户id查询退款中订单

    List<Order> selectByUser(int userId);//根据用户id查询所有订单

    int confirmOrder(int oId);//根据订单id确定订单

    int refundOrder(int oId);//根据订单id申请退款

    int cancelOrder(int oId);//根据订单id取消订单

    List<Order> select1 (int sellerId);//根据卖家id查询待发货订单

    List<Order> selectCondition1(Map<String,Object> map);//商家多条件查询待发货订单

    List<Order> select2 (int sellerId);//根据卖家id查询已发货订单

    List<Order> selectCondition2(Map<String,Object> map);//商家多条件查询已发货订单

    List<Order> select3 (int sellerId);//根据卖家id查询已到货订单

    List<Order> selectCondition3(Map<String,Object> map);//商家多条件查询已到货订单

    List<Order> select4 (int sellerId);//根据卖家id查询退款中订单

    List<Order> selectCondition4(Map<String,Object> map);//商家多条件查询退款中订单

    List<Order> select5 (int sellerId);//根据卖家id查询退款中订单

    List<Order> selectCondition5(Map<String,Object> map);//商家多条件查询退款中订单

//    edited by CC
    int insertAndGetId(Order order);//添加订单到数据库并获得新增的主键

    int sendOrder (int oId);//根据订单id发货
}