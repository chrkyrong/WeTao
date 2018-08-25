package com.ssm.controller;

import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lzr on 2018/8/23.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public void get()
    {
        int id=1;
        userService.selectByPrimaryKey(id);
    }
}
