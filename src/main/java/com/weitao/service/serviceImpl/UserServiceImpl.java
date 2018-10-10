package com.weitao.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import java.util.List;
import java.util.Map;

/**
 * Created by lzr on 2018/9/11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User register(User user) {
        //密码加密
        String password= MD5.md5(user.getuPassword());
        user.setuPassword(password);
        System.out.println(user.getuIcon());
        if(user.getuIcon()==null||user.getuIcon().equals("")==true) {
            user.setuIcon("Wetao_logo_icon.jpg");
        }
        user.setuStatus((byte) 0);
        //注册用户
        if(userMapper.insertSelective(user)>0)
            return user;
        else
            return null;
    }

    @Override
    public Boolean login(User user) throws Exception {
        //根据用户id查询用户
        User user1=look(user.getuId());
        if(user1==null)
            throw new UserException(ResultEnum.USER_NOT_EXIST);
        //验证账号状态
        int status=user1.getuStatus();
        if(status==1)
            throw new UserException(ResultEnum.USER_LOCK);
        //密码加密
        String password=MD5.md5(user.getuPassword());
        //验证密码
        if(!password.equals(user1.getuPassword()))
            throw new UserException(ResultEnum.USER_PASSWROD_FAIL);
        return true;
    }

    @Override
    public User lookByUserName(String userName) {
        //根据用户名查询用户
        return userMapper.selectByUserName(userName);
    }

    @Override
    public User look(int uId) {
        //根据用户id查询用户
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public Boolean revise(User user) {
        //修改用户信息
        if(userMapper.updateByPrimaryKeySelective(user)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean revisePassword(User user) {
        //根据用户id查询用户电话
        User user1=look(user.getuId());
        String phone=user1.getuTel();
        //验证账号状态
        int status=user1.getuStatus();
        if(status==1)
            throw new UserException(ResultEnum.USER_LOCK);
        //验证电话
        if(!phone.equals(user.getuTel()))
            throw new UserException(ResultEnum.USER_PHONE_FAIL);
        //密码加密
        String password=MD5.md5(user.getuPassword());
        user.setuPassword(password);
        //修改用户密码
        if(userMapper.updateByPrimaryKeySelective(user)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean lockByUserId(int userId) {
        //根据用户id查询用户
        User user=userMapper.selectByPrimaryKey(userId);
        //验证是否被锁定
        if(user.getuStatus()==1)
            throw new UserException(ResultEnum.USER_LOCK);
        //封号
        user.setuStatus((byte) 1);
        //修改用户状态
        if(userMapper.updateByPrimaryKeySelective(user)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean unlockByUserId(int userId) {
        //根据用户id查询用户
        User user=userMapper.selectByPrimaryKey(userId);
        //验证是否是正常
        if(user.getuStatus()==0)
            throw new UserException(ResultEnum.USER_NORMAL);
        //解封
        user.setuStatus((byte) 0);
        //修改用户状态
        if(userMapper.updateByPrimaryKeySelective(user)>0)
            return true;
        else
            return false;
    }

    @Override
    public PageInfo lookUsers(int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum,pageSize);
        //查询所有用户
        List<User> userList=userMapper.selectUser();
        //封装到分页对象
        PageInfo pageInfo=new PageInfo(userList);
        return pageInfo;
    }

    @Override
    public PageInfo getConditions(Map<String, Object> map, int pageNum, int pageSize) {
        //分页信息
        PageHelper.startPage(pageNum,pageSize);
        //多条件查询用户
        List<User> userList=userMapper.selectCondition(map);
        //封装到分页对象
        PageInfo pageInfo=new PageInfo(userList);
        return pageInfo;
    }
}
