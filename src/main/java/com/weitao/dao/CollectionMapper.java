package com.weitao.dao;

import com.weitao.bean.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}