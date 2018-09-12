package com.weitao.dao;

import com.weitao.bean.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}