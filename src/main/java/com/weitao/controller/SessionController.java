package com.weitao.controller;

import com.weitao.bean.User;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lzr on 2018/9/13.
 */
public class SessionController {
    @GetMapping("/session")
    public Result checkUser(HttpServletRequest httpServletRequest)
    {
        //获取session
        HttpSession session=httpServletRequest.getSession();
        User user= (User) session.getAttribute("user");
        return ResultUtil.success(user);
    }
}
