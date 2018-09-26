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
    public boolean insertEvaluate(Evaluate evaluate, Integer orderId) throws Exception {
        evaluate.setOrderId(orderId);
        Order order = orderMapper.selectByPrimaryKey(orderId);
        evaluate.setUserId(order.getUserId());
//        获得StoreId
        evaluate.setStoreId(order.getStoreId());
//        判断评论是否为空,为空：系统默认添加评论
        if (evaluate.geteDescription() == null||evaluate.geteDescription().equals(""))
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
                result = true;
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

    //    根据条件及搜索框模糊搜索，查询该商家想搜索的相关内容评价
    @Override
    public List<EvaluateVo2> searchEvaluation(Integer sellerId, String condition, String search, String oDate) throws Exception {
        String stName = "";
        String iName = "";
        Byte eLevel = null;
        String eDescription = "";

        switch (condition) {
            case "店铺":
                stName = search;
                break;
            case "商品":
                iName = search;
                break;
            case "评级":
                eLevel = Byte.parseByte(search);
                break;
            case "评论":
                eDescription = search;
                break;
        }
        List<EvaluateVo2> evaluateVo2List = evaluateMapper.searchEvaluation(sellerId, stName, iName, eLevel, eDescription, oDate);
        System.out.println(stName +"-"+ iName +"-"+ eLevel +"-"+ eDescription);
        if (evaluateVo2List == null)
            return null;
        else
            return evaluateVo2List;
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

}
