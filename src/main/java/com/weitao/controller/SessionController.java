package com.weitao.controller;

import com.weitao.bean.User;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lzr on 2018/9/13.
 */
@RestController
public class SessionController {

    @GetMapping("/session/user")
    public Result checkUser(HttpServletRequest httpServletRequest)
    {
        //获取session
        HttpSession session=httpServletRequest.getSession();
        int uId= (int) session.getAttribute("uId");
        return ResultUtil.success(uId);
    }
}
