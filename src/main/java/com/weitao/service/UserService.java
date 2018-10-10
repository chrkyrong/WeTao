package com.weitao.service;

import com.github.pagehelper.PageInfo;
import com.weitao.bean.User;

import java.util.Map;

/**
 * Created by lzr on 2018/9/11.
 */
public interface UserService {
    User register(User user);//注册用户

    Boolean login(User user) throws Exception;//用户登陆

    User lookByUserName(String userName);//根据用户名查询用户

    User look(int uId);//根据用户id查询用户

    Boolean revise(User user);//修改用户信息

    Boolean revisePassword(User user);//修改用户密码

    Boolean lockByUserId(int userId);//封用户

    Boolean unlockByUserId(int userId);//解封用户

    PageInfo lookUsers(int pageNum, int pageSize);//分页查询所有用户

    PageInfo getConditions(Map<String,Object> map,int pageNum, int pageSize);//多条件查询用户
}
