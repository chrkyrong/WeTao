package com.weitao.controller;

import com.weitao.bean.User;
import com.weitao.exception.ResultEnum;
import com.weitao.service.UserService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lzr on 2018/9/4.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user")
    @ResponseBody
    public Result user (User user) throws Exception {
        User user1=userService.register(user);
        if(user1!=null)
             return ResultUtil.success(user1);
        else
            return ResultUtil.error(ResultEnum.USERNAME_EXIST);
    }

    /**
     * 用户登陆
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ResponseBody
    public Result result(User user) throws Exception{
        if(userService.login(user))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USER_LOGIN_FAIL);
    }
}
