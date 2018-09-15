package com.weitao.service;

import com.weitao.bean.User;

/**
 * Created by lzr on 2018/9/11.
 */
public interface UserService {
    Boolean register(User user);//注册用户

    Boolean login(User user) throws Exception;//用户登陆

    User lookByUserName(String userName);//根据用户名查询用户

    User look(int uId);//根据用户id查询用户

    Boolean revise(User user);//修改用户信息

    Boolean revisePassword(User user);//修改用户密码
}
