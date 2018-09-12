package com.weitao.dao;

import com.weitao.bean.Items;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}