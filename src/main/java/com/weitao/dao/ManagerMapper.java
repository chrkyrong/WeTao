package com.weitao.dao;

import com.weitao.bean.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}