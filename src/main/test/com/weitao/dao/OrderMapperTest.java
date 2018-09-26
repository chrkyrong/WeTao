package com.weitao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        int userId=1000000;
        System.out.println(orderMapper.selectByUser2(userId));
    }

    @Test
    public void selectByUser3() throws Exception {
        int userId=1000000;
        System.out.println(orderMapper.selectByUser3(userId));
    }

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void selectByUser1() throws Exception {
        int userId=1000000;
        System.out.println(orderMapper.selectByUser1(userId));
    }
}