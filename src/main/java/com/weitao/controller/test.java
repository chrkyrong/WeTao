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

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/10/4
 * @Time: 21:09
 **/
@RestController
public class test {
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
        List<Order> orderList = orderService.selectAllOrderBySid(sId);
        List<OrderVo> orderVoList = new ArrayList<OrderVo>();
        for (Order order:orderList){
            OrderVo orderVo = new OrderVo();
            orderVo.setOrder(order);
            orderVo.setDate(order.getoDate().getYear()+1900+"/"+(order.getoDate().getMonth()+1));
            orderVoList.add(orderVo);
            //System.out.println(order.getoDate().getYear()+1900+"/"+order.getoDate().getMonth()+1);
        }
        return ResultUtil.success(orderVoList);
    }


}
