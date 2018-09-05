package com.weitao.service.serviceImpl;

import com.weitao.bean.User;
import com.weitao.dao.UserMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.exception.UserException;
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
    public User register(User user) throws Exception{
        //根据用户名查询用户
        User user1= userMapper.selectByUserName(user.getuUsername());
        if(user1!=null) {
            throw new UserException(ResultEnum.USERNAME_EXIST);
        }
        String password= MD5.md5(user.getuPassword());
        user.setuPassword(password);
        userMapper.insertSelective(user);
        return user1;
    }

    @Override
    public Boolean login(User user) throws Exception {
        //根据用户名查询用户
        User user1= userMapper.selectByUserName(user.getuUsername());
        if(user1==null)
        {
            throw new UserException(ResultEnum.USER_NOT_EXIST);
        }
        String password=MD5.md5(user.getuPassword());
        if(password.equals(user1.getuPassword()))
            return true;
        else
            return false;
    }
}
