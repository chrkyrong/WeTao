package com.weitao.dao;

import com.weitao.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insertSelective(User record);//添加用户

    User selectByPrimaryKey(Integer uId);//根据用户id查询用户

    int updateByPrimaryKeySelective(User record);//根据用户id修改用户

    User selectByUserName(String userName);//根据用户名查询用户

}