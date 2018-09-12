package com.weitao.dao;

import com.weitao.bean.Seller;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}