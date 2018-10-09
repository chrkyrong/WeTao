package com.weitao.controller;

import com.weitao.bean.Manager;
import com.weitao.exception.ResultEnum;
import com.weitao.service.ManagerService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author:Cc
 * @Date:2018/10/9
 * @program: weitao
 * @description: ${description}
 * @create: 2018-10-09 10:14
 */


@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/manage/login")
    public Result login(HttpSession httpSession, Manager manager) {
        int result = managerService.login(manager);
        if (result == 0) {
            httpSession.setAttribute("power", 0);
            return ResultUtil.success();
        } else if (result == 3) {
            httpSession.setAttribute("power", 1);
            return ResultUtil.success();
        } else if (result == 1)
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST);
        else
            return ResultUtil.error(ResultEnum.USER_PASSWROD_FAIL);
    }

    @PostMapping("/manage/addManager")
    public Result addManager(Manager manager) {
        int result = managerService.addManager(manager);
        if (result == 0) {
//            添加管理员失败
            return ResultUtil.error(ResultEnum.MANAGE_INSERT_FAIL);
        } else {
//            添加管理员成功
            return ResultUtil.success(result);
        }
    }

    @PostMapping("/manage/checkPower")
    public Result checkPower(HttpSession httpSession) {
        int power = (int) httpSession.getAttribute("power");
        System.out.println(power);
        if (power == 1) {
            System.out.println("success");
            return ResultUtil.success(ResultEnum.MANAGE_INSERT_GO);
        } else {
            System.out.println("fail");
            return ResultUtil.error(ResultEnum.MANAGE_INSERT_NOPOWER);
        }
    }

    /**
     * 退出登录
     * @param httpSession
     */
    @GetMapping("/manage/logout")
    public void logout(HttpSession httpSession){
        httpSession.invalidate();
    }
}
