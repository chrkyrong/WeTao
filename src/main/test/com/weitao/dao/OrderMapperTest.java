package com.weitao.dao;

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
public class OrderMapperTest {
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