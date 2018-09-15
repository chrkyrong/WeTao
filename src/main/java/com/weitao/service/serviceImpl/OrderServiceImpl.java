package com.weitao.service.serviceImpl;

import com.weitao.bean.Order;
import com.weitao.dao.OrderMapper;
import com.weitao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getByUser1(int userId) {
        //根据用户id查询待发货订单
        return orderMapper.selectByUser1(userId);
    }

    @Override
    public List<Order> getByUser2(int userId) {
        //根据用户id查询已发货订单
        return orderMapper.selectByUser2(userId);
    }

    @Override
    public List<Order> getByUser3(int userId) {
        //根据用户id查询已签收订单
        return orderMapper.selectByUser3(userId);
    }


}
