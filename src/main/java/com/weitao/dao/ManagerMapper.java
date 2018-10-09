package com.weitao.dao;

import com.weitao.bean.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    //根据管理员的mId查找管理员
    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}