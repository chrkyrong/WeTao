package com.weitao.dao;

import com.weitao.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insertSelective(User record);//添加用户

    User selectByPrimaryKey(Integer uId);//根据用户id查询用户

    int updateByPrimaryKeySelective(User record);//根据用户id修改用户

    User selectByUserName(String userName);//根据用户名查询用户

    List<User> selectUser();//查询所有用户

    List<User> selectCondition(Map<String,Object> map);//多条件查询用户
}