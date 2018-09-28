package com.weitao.dao;

import com.weitao.bean.Items;
import com.weitao.bean.Order_detail;
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

//    edited by CC
//    添加订单详情
    @Test
    public void insertSelectiveTest() throws Exception {
        Order_detail order_detail = new Order_detail();
//        数量
        order_detail.setOrDeNumber(2);
//        订单号
        order_detail.setOrderId(3000006);
//        商品号
        order_detail.setItemsId(8000000);
//        添加订单详情
        System.out.println(order_detailMapper.insertSelective(order_detail));

    }
}