package com.weitao.service.serviceImpl;

import com.weitao.bean.Evaluate;
import com.weitao.bean.Order;
import com.weitao.bean.Order_detail;
import com.weitao.dao.EvaluateMapper;
import com.weitao.dao.OrderMapper;
import com.weitao.service.EvaluateService;
import com.weitao.service.Order_detailService;
import com.weitao.vo.EvaluateVo;
import com.weitao.vo.EvaluateVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 19:43
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    EvaluateMapper evaluateMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    Order_detailService order_detailService;

    //    用户，添加评价
    @Override
    public boolean insertEvaluate(Evaluate evaluate,Integer orderId) throws Exception {
        evaluate.setOrderId(orderId);
        Order order = orderMapper.selectByPrimaryKey(orderId);
        evaluate.setUserId(order.getUserId());
//        获得StoreId
        evaluate.setStoreId(order.getStoreId());
//        判断评论是否为空,为空：系统默认添加评论
        if (evaluate.geteDescription() == null)
            evaluate.seteDescription("用户默认好评。");

        boolean result = false;

//        创建Order_detail集合
        List<Order_detail> order_details = order_detailService.getOrderDetail(orderId);
        for (Order_detail detail : order_details) {
//            获得itemsId
            int id = detail.getItemsId();
            evaluate.setItemsId(id);
//            执行添加操作
            int insert = evaluateMapper.insertSelective(evaluate);
            if (insert == 1) {
                result =  true;
            } else {
                break;
            }
        }
        return result;
    }

    //    根据商品id，查询所有该商品的评价
    @Override
    public List<EvaluateVo> selectEvaluate(Integer itemsId) throws Exception {
        List<EvaluateVo> result = evaluateMapper.selectByItemsId(itemsId);
        return result;
    }

    //    查询该商家的收到的所有的评价
    @Override
    public List<EvaluateVo2> sellerEvaluation(Integer sellerId) throws Exception {
        List<EvaluateVo2> evaluateVo2List = evaluateMapper.selectBySeller(sellerId);
        if (evaluateVo2List == null)
            return null;
        else
            return evaluateVo2List;
    }

    //    根据订单id，查询所有订单详情
//    @Override
//    public List<Order_detail> selectOrderDetail(Integer oId) throws Exception {
//        Order_detailService order_detailService = new Order_detailServiceImpl();
//        List<Order_detail> list = order_detailService.getOrderDetail(oId);
//        return list;
//    }
}
