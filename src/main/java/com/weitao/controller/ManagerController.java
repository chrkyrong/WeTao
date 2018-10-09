package com.weitao.controller;
import com.weitao.bean.Manager;
import com.weitao.exception.ResultEnum;
import com.weitao.service.ManagerService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result login(Manager manager) {
        int result = managerService.login(manager);
        if (result==0)
            return ResultUtil.success();
        else if (result==1)
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST);
        else
            return ResultUtil.error(ResultEnum.USER_PASSWROD_FAIL);
    }
}
