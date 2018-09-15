package com.weitao.service;

import com.weitao.dao.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void getByUser1() throws Exception {
        int userId=1000000;
        System.out.println(orderMapper.selectByUser1(userId));
    }

    @Test
    public void getByUser2() throws Exception {
        int userId=1000000;
        System.out.println(orderMapper.selectByUser2(userId));
    }

    @Test
    public void getByUser3() throws Exception {
        int userId=1000000;
        System.out.println(orderMapper.selectByUser3(userId));
    }

}