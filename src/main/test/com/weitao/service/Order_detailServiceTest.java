package com.weitao.service;

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
public class Order_detailServiceTest {

    @Autowired
    private Order_detailService order_detailService;

    @Test
    public void getOrderDetail() throws Exception {
        int i=1;
        System.out.println(order_detailService.getOrderDetail(i));
    }

}