package com.weitao.dao;

import com.weitao.bean.Seller;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Seller record);

    //1、商家注册
    int insertSelective(Seller record);

    //2、根据商家id查询商家
    Seller selectByPrimaryKey(Integer sId);

    //3、根据商家id修改商家
    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    Seller getSellerId(Long iId);

}