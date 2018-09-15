package com.weitao.dao;

import com.weitao.bean.Order_detail;

import java.util.List;

public interface Order_detailMapper {
    int deleteByPrimaryKey(Integer orDeId);

    int insert(Order_detail record);

    int insertSelective(Order_detail record);

    Order_detail selectByPrimaryKey(Integer orDeId);

    int updateByPrimaryKeySelective(Order_detail record);

    int updateByPrimaryKey(Order_detail record);

    List<Order_detail> selectByOrderId(int orderId);//根据订单id查询订单详情关联查询商品信息

}