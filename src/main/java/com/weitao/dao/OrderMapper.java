package com.weitao.dao;

import com.weitao.bean.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByUser1(int userId);//根据用户id查询待发货订单

    List<Order> selectByUser2(int userId);//根据用户id查询已发货订单

    List<Order> selectByUser3(int userId);//根据用户id查询已签收订单

//    edited by CC
    void insertAndGetId(Order order);//添加订单到数据库并获得新增的主键
}