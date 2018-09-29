package com.weitao.controller;

import com.github.pagehelper.PageInfo;
import com.weitao.bean.Order;
import com.weitao.exception.ResultEnum;
import com.weitao.service.OrderService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by lzr on 2018/9/15.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据用户id查询待发货订单
     * @param uId
     * @return
     */
    @GetMapping("/order/user/1")
    public Result orderByUser1(int uId)
    {
        List<Order> orderList=orderService.getByUser1(uId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据用户id查询已发货订单
     * @param uId
     * @return
     */
    @GetMapping("/order/user/2")
    public Result orderByUser2(int uId)
    {
        List<Order> orderList=orderService.getByUser2(uId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据用户id查询已签收订单
     * @param uId
     * @return
     */
    @GetMapping("/order/user/3")
    public Result orderByUser3(int uId)
    {
        List<Order> orderList=orderService.getByUser3(uId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据用户id查询退款订单
     * @param uId
     * @return
     */
    @GetMapping("/order/user/4")
    public Result orderByUser4(int uId)
    {
        List<Order> orderList=orderService.getByUser4(uId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     *根据用户id查询所有订单
     * @param userId
     * @return
     */
    @GetMapping("/order/user")
    public Result orderByUser(int userId)
    {
        List<Order> orderList=orderService.getByUser(userId);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据订单id确认订单到货
     * @param oId
     * @return
     */
    @GetMapping("/order/confirm")
    public Result confirmOrder(int oId)
    {
        if(orderService.confirmOrder(oId))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ORDER_CONFIRM_FAIL);
    }

    /**
     * 根据订单id申请退款
     * @param oId
     * @return
     */
    @GetMapping("/order/refund")
    public Result refundOrder(int oId)
    {
        if(orderService.refundOrder(oId))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ORDER_REFUND_FAIL);
    }

    /**
     * 根据订单id取消订单
     * @param oId
     * @return
     */
    @GetMapping("/order/cancel")
    public Result cancelOrder(int oId)
    {
        if(orderService.cancelOrder(oId))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ORDER_CANCEL_FAIL);
    }


    @GetMapping("/order/get1")
    public Result get1(@RequestParam Map<String,Object> map, @RequestParam(defaultValue="1") int pageNum, @RequestParam(defaultValue="2")int pageSize)
    {
        PageInfo page=orderService.get1(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    @RequestMapping("order/addOrders")
    public Result addOrders(@SessionAttribute(value = "uId",required = false) Integer userId, Byte oPost, String oAddress, String oMessage){
        List<Order> orderList = orderService.addOrder(userId, oPost,oAddress,oMessage);
        return ResultUtil.success(orderList);
    }
}
