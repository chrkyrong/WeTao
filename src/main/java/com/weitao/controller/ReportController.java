package com.weitao.controller;

import com.weitao.bean.Items;
import com.weitao.bean.Order;
import com.weitao.service.ItemsService;
import com.weitao.service.OrderService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/10/4
 * @Time: 21:09
 **/
@RestController
public class ReportController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private OrderService orderService;

     /**
     * 查找top10的报表
     * @param sId
     * @return
     */
    @GetMapping("/top10")
    public Result saleTop(@SessionAttribute(value = "sId", required = false)Integer sId){
        List<Items> itemsList = itemsService.saleTop(sId);
        return ResultUtil.success(itemsList);
    }

    @GetMapping("/half")
    public Result order(@SessionAttribute(value = "sId", required = false)Integer sId){
        Date date = new Date();
        int month = date.getMonth()+1;
        int year = date.getYear()+1900;
        int new_month,new_year;
        if (month>=7) {
            new_month = month - 6;
            new_year = year;
        }
        else {
            new_month = month + 6;
            new_year = year - 1;
        }
        List<Order> orderList = orderService.selectAllOrderBySid(sId);
        List<OrderVo> orderVoList = new ArrayList<OrderVo>();

        for (Order order:orderList){

            for (;new_month<(order.getoDate().getMonth()+1);new_month++){
                Order order1 = new Order();
                order1.setoPrice(new BigDecimal(0));
                OrderVo orderVo1 = new OrderVo();
                orderVo1.setOrder(order1);
                orderVo1.setDate(new_year+"/"+new_month);
                orderVoList.add(orderVo1);
                if (new_month==12){
                    new_month = 0;
                    new_year++;
                }
            }
            OrderVo orderVo = new OrderVo();
            orderVo.setOrder(order);
            orderVo.setDate(order.getoDate().getYear()+1900+"/"+(order.getoDate().getMonth()+1));
            orderVoList.add(orderVo);
            if (new_month==12){
                new_month = 0;
                new_year++;
            }
            new_month++;
        }
        for (;new_month<month;new_month++){
            Order order = new Order();
            order.setoPrice(new BigDecimal(0));
            OrderVo orderVo = new OrderVo();
            orderVo.setOrder(order);
            orderVo.setDate(new_year+"/"+new_month);
            orderVoList.add(orderVo);
            if (new_month==12){
                new_month = 0;
                new_year++;
            }
        }
        return ResultUtil.success(orderVoList);
    }
}
