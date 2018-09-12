package com.weitao.service;

import com.weitao.bean.User;

/**
 * Created by lzr on 2018/9/11.
 */
public interface UserService {
    Boolean register(User user);//注册用户

    Boolean login(User user) throws Exception;//用户登陆
}
