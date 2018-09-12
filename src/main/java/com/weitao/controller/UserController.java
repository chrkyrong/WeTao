package com.weitao.controller;

import com.weitao.bean.User;
import com.weitao.exception.ResultEnum;
import com.weitao.service.UserService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by lzr on 2018/9/11.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user")
    @ResponseBody
    public Result user (User user) throws Exception {
        if(userService.register(user))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USERNAME_EXIST);
    }

    /**
     * 用户登陆
     * @param httpSession
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user/login")
    @ResponseBody
    public Result result(HttpSession httpSession,User user) throws Exception{
        if(userService.login(user)) {
            //保存用户信息
            httpSession.setAttribute("user",user);
            return ResultUtil.success();
            //重定向到主页界面
        }
        else
            return ResultUtil.error(ResultEnum.USER_LOGIN_FAIL);
    }

    @GetMapping("/user/logout")
    @ResponseBody
    public void logout(HttpSession httpSession)
    {
        httpSession.invalidate();
        //重定向到主页界面
    }
}
