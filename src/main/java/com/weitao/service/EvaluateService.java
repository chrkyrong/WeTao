package com.weitao.service;

import com.weitao.bean.Evaluate;
import com.weitao.bean.Order_detail;
import com.weitao.vo.EvaluateVo;
import com.weitao.vo.EvaluateVo2;

import java.util.List;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 19:39
 */

public interface EvaluateService {
//    用户，添加评价
    public boolean insertEvaluate(Evaluate evaluate,Integer orderId) throws Exception;

//    根据商品id，查询所有该商品的评价
    public List<EvaluateVo> selectEvaluate(Integer itemsId) throws Exception;

//    根据订单id，查询所有订单详情
//    public List<Order_detail> selectOrderDetail(Integer oId) throws Exception;

//    查询该商家的收到的所有的评价
    public List<EvaluateVo2> sellerEvaluation(Integer sellerId) throws Exception;


}
