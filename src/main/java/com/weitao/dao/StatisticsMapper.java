package com.weitao.dao;

import com.weitao.bean.Statistics;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}