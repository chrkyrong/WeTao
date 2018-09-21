package com.weitao.dao;

import com.weitao.bean.Evaluate;
import com.weitao.vo.EvaluateVo2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 18:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EvaluateMapperTest {

    @Autowired
    EvaluateMapper evaluateMapper;

//    用户，添加评论
    @Test
    public void insertEvaluateTest() throws Exception {
        Evaluate evaluate = new Evaluate();
        evaluate.seteLevel((byte) 5);
        evaluate.seteDescription("非常好！");
        evaluate.setePhotos("C://ccop");
        evaluate.setOrderId(3000002);
        evaluate.setStoreId(7000001);
        evaluate.setUserId(1000000);
        evaluate.setItemsId(8000003);
        evaluateMapper.insertSelective(evaluate);

    }

//    查询该商品所有评价
    @Test
    public void selectByItemsIdTest() throws Exception {
        System.out.println(evaluateMapper.selectByItemsId(8000003));
    }

//    查询该商家的收到的所有的评价
    @Test
    public void selectBySellerTest() throws Exception {
        System.out.println(evaluateMapper.selectBySeller(2000000));
    }

    @Test
    public void selectByConditionTest() throws Exception {
        EvaluateVo2 vo = new EvaluateVo2();
        vo.getEvaluateVo().getEvaluate().seteDescription("");
    }
}
