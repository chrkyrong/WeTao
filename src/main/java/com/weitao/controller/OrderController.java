package com.weitao.controller;

import com.weitao.bean.Order;
import com.weitao.exception.ResultEnum;
import com.weitao.service.OrderService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/user/1")
    public Result orderByUser1(int userId)
    {
        List<Order> orderList=orderService.getByUser1(userId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    @GetMapping("/order/user/2")
    public Result orderByUser2(int userId)
    {
        List<Order> orderList=orderService.getByUser2(userId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }
    @GetMapping("/order/user/3")
    public Result orderByUser3(int userId)
    {
        List<Order> orderList=orderService.getByUser3(userId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

}
