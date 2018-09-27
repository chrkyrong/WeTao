package com.weitao.dao;

import com.weitao.bean.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderMapperTest {
    @Test
    public void selectConditions() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",100);
        map.put("oId",1);
        map.put("sellerId",2);
        System.out.println(orderMapper.selectConditions(map));
    }

    @Test
    public void select1() throws Exception {
        int userId=2;
        System.out.println(orderMapper.select1(userId));
    }

    @Test
    public void confirmOrder() throws Exception {
        int oId=2;
        System.out.println(orderMapper.confirmOrder(oId));
    }

    @Test
    public void selectByUser2() throws Exception {
        int userId = 1000000;
        System.out.println(orderMapper.selectByUser2(userId));
    }

    @Test
    public void selectByUser3() throws Exception {
        int userId = 1000000;
        System.out.println(orderMapper.selectByUser3(userId));
    }

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void selectByUser1() throws Exception {
        int userId = 1000000;
        System.out.println(orderMapper.selectByUser1(userId));
    }

//    by CC
    @Test
    public void insertAndGetIdTest() throws Exception {
        Order order = new Order();
//        邮寄状态
        order.setoPost((byte) 0);
//        总价
        order.setoPrice(new BigDecimal(6.666));
//        下单时间
        order.setoDate(new Date());
//        订单状态
        order.setoStatus((byte) 0);
//        留言
        order.setoMessage("创建订单测试1");
//        买家id
        order.setUserId(1000000);
//        卖家id
        order.setSellerId(2000000);
//        商店id
        order.setStoreId(7000000);
        System.out.println("插入前主键为："+order.getoId());
        orderMapper.insertAndGetId(order);
//        返回添加订单后的主键
        System.out.println("插入后主键为："+order.getoId());
    }
}