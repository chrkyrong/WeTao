package com.weitao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Order_detailMapperTest {

    @Autowired
    private Order_detailMapper order_detailMapper;

    @Test
    public void selectByOrderId() throws Exception {
        int i=1;
        System.out.println(order_detailMapper.selectByOrderId(i));
    }

}