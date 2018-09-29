package com.weitao.service;

import com.weitao.bean.Car;
import com.weitao.dao.CarMapper;
import com.weitao.dao.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceTest {
    @Test
    public void select1() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",100);
        map.put("oId",1);
        map.put("sellerId",2);
        int num=1;
        int size=2;
//        System.out.println(orderService.get1(map,num,size));
    }

    @Test
    public void order() throws Exception {
        List<Car> carList=new ArrayList<>();
        Car car=new Car();
        car.setItemsId(1);
        car.setSellerId(2);
        car.setNumber(2);
        car.setUserId(1000000);
        carList.add(car);
//        orderService.order(carList);
    }

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

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