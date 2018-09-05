package com.weitao.dao;

import com.weitao.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insertSelective(User record);//注册用户

    User selectByUserName(String username);//根据用户名查询用户

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}