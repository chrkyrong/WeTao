package com.weitao.dao;

import com.weitao.bean.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer caId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer caId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}