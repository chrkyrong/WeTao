package com.weitao.service.serviceImpl;

import com.weitao.bean.User;
import com.weitao.dao.UserMapper;
import com.weitao.service.UserService;
import com.weitao.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzr on 2018/9/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean register(User user) {
        String password= MD5.md5(user.getuPassword());
        user.setuPassword(password);
        userMapper.insertSelective(user);
        return true;
    }
}
