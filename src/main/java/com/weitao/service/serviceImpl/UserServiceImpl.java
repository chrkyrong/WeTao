package com.weitao.service.serviceImpl;

import com.weitao.bean.User;
import com.weitao.dao.UserMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.exception.UserException;
import com.weitao.service.UserService;
import com.weitao.utils.MD5;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzr on 2018/9/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean register(User user) {
        //根据用户名查询用户
        User user1= userMapper.selectByUserName(user.getuUserName());
        //查询结果不为空则用户已存在
        if(user1!=null) {
            throw new UserException(ResultEnum.USERNAME_EXIST);
        }
        //密码加密
        String password= MD5.md5(user.getuPassword());
        user.setuPassword(password);
        user.setuIcon("head.jpg");
        user.setuStatus((byte) 0);
        //注册用户
        if(userMapper.insertSelective(user)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean login(User user) throws Exception {
        //根据用户名查询用户
        User user1= userMapper.selectByUserName(user.getuUserName());
        //查询结果为空则用户名不存在
        if(user1==null)
        {
            throw new UserException(ResultEnum.USER_NOT_EXIST);
        }
        //密码加密
        String password=MD5.md5(user.getuPassword());
        //验证登陆
        if(password.equals(user1.getuPassword()))
            return true;
        else
            return false;
    }


}
