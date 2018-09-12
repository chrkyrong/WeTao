package com.weitao.dao;

import com.weitao.bean.Order_detail;

public interface Order_detailMapper {
    int deleteByPrimaryKey(Integer orDeId);

    int insert(Order_detail record);

    int insertSelective(Order_detail record);

    Order_detail selectByPrimaryKey(Integer orDeId);

    int updateByPrimaryKeySelective(Order_detail record);

    int updateByPrimaryKey(Order_detail record);
}