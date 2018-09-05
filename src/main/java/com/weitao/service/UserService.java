package com.weitao.service;

import com.weitao.bean.User;

/**
 * Created by lzr on 2018/9/4.
 */
public interface UserService {

    User register(User user) throws Exception;

    Boolean login(User user) throws Exception;
}
