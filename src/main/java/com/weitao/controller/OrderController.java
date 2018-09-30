package com.weitao.controller;

import com.github.pagehelper.PageInfo;
import com.weitao.bean.Order;
import com.weitao.exception.ResultEnum;
import com.weitao.service.OrderService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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


    /**
     * 多条件查询待发货订单
     * @param oId
     * @param userId
     * @param oAddress
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/order/get/condition/1")
    public Result getCondition1(Integer oId,Integer userId ,String oAddress, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        int sellerId=2;
        Map<String,Object> map=new HashMap<>();
        map.put("oId",oId);
        map.put("userId",userId);
        map.put("oAddress",oAddress);
        map.put("sellerId",sellerId);
        PageInfo page=orderService.getCondition1(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    @RequestMapping("order/addOrders")
    public Result addOrders(@SessionAttribute(value = "uId",required = false) Integer userId, Byte oPost, String oAddress, String oMessage){
//        测试用途
        userId = 1000000;


        List<Order> orderList = orderService.addOrder(userId, oPost,oAddress,oMessage);
        return ResultUtil.success(orderList);
    }

    /**
     * 根据卖家id查询待发货订单
     * @param sellerId
     * @return
     */
    @GetMapping("/order/get/1")
    public Result getOrder1(Integer sellerId, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        PageInfo orderList=orderService.get1(2,pageNum,pageSize);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据订单id发货
     * @param oId
     * @return
     */
    @GetMapping("/order/send")
    public Result sendOrder(int oId)
    {
        if(orderService.sendOrder(oId))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ORDER_SEND_FAIL);
    }

    /**
     * 多条件查询已发货订单
     * @param oId
     * @param userId
     * @param oAddress
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/order/get/condition/2")
    public Result getCondition2(Integer oId,Integer userId ,String oAddress, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        int sellerId=2;
        Map<String,Object> map=new HashMap<>();
        map.put("oId",oId);
        map.put("userId",userId);
        map.put("oAddress",oAddress);
        map.put("sellerId",sellerId);
        PageInfo page=orderService.getCondition2(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据商户id查询已发货订单
     * @param sellerId
     * @return
     */
    @GetMapping("/order/get/2")
    public Result getOrder2(Integer sellerId,@RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        PageInfo orderList=orderService.get2(2,pageNum,pageSize);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 多条件查询已到货订单
     * @param oId
     * @param userId
     * @param oAddress
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/order/get/condition/3")
    public Result getCondition3(Integer oId,Integer userId ,String oAddress, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        int sellerId=2;
        Map<String,Object> map=new HashMap<>();
        map.put("oId",oId);
        map.put("userId",userId);
        map.put("oAddress",oAddress);
        map.put("sellerId",sellerId);
        PageInfo page=orderService.getCondition3(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据商户id查询已到货订单
     * @param sellerId
     * @return
     */
    @GetMapping("/order/get/3")
    public Result getOrder3(Integer sellerId ,@RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        PageInfo orderList=orderService.get3(2,pageNum,pageSize);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 多条件查询退款中订单
     * @param oId
     * @param userId
     * @param oAddress
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/order/get/condition/4")
    public Result getCondition4(Integer oId,Integer userId ,String oAddress, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        int sellerId=2;
        Map<String,Object> map=new HashMap<>();
        map.put("oId",oId);
        map.put("userId",userId);
        map.put("oAddress",oAddress);
        map.put("sellerId",sellerId);
        PageInfo page=orderService.getCondition4(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据商户id查询退款中订单
     * @param sellerId
     * @return
     */
    @GetMapping("/order/get/4")
    public Result getOrder4(Integer sellerId,@RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        PageInfo orderList=orderService.get4(sellerId,pageNum,pageSize);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 多条件查询退款完成订单
     * @param oId
     * @param userId
     * @param oAddress
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping("/order/get/condition/5")
    public Result getCondition5(Integer oId,Integer userId ,String oAddress, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize)
    {
        int sellerId=2;
        Map<String,Object> map=new HashMap<>();
        map.put("oId",oId);
        map.put("userId",userId);
        map.put("oAddress",oAddress);
        map.put("sellerId",sellerId);
        PageInfo page=orderService.getCondition5(map,pageNum,pageSize);
        if(page!=null)
            return ResultUtil.success(page);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }

    /**
     * 根据商户id查询退款完成订单
     * @param sellerId
     * @return
     */
    @GetMapping("/order/get/5")
    public Result getOrder5(Integer sellerId,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="3")Integer pageSize)
    {
        PageInfo orderList=orderService.get5(2,pageNum,pageSize);
        if(orderList!=null)
            return ResultUtil.success(orderList);
        else
            return ResultUtil.error(ResultEnum.ORDER_USER_FAIL);
    }
}
