package com.weitao.service.serviceImpl;

import com.weitao.bean.Order_detail;
import com.weitao.dao.Order_detailMapper;
import com.weitao.service.Order_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
@Service
public class Order_detailServiceImpl implements Order_detailService {

    @Autowired
    private Order_detailMapper order_detailMapper;

    @Override
    public List<Order_detail> getOrderDetail(int orderId) {
        return order_detailMapper.selectByOrderId(orderId);
    }
}
