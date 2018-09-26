package com.weitao.service;

import com.weitao.bean.Evaluate;
import com.weitao.service.serviceImpl.EvaluateServiceImpl;
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
 * @create: 2018-09-17 20:17
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EvaluateServiceTest {

    @Autowired
    private EvaluateService evaluateService;

    //添加评论
    @Test
    public void insertEvaluateTest() throws Exception {
        Evaluate evaluate = new Evaluate((byte) 5,"bg-1.jpg",3000002,7000001,1000000,8000003,"好好吃");
        evaluateService.insertEvaluate(evaluate,3000002);
    }

    //根据商品id查评论
    @Test
    public void selectEvaluateByItemsId() throws Exception {
        System.out.println(evaluateService.selectEvaluate(8000003));
    }

    //根据商家id查询他拥有的产品的评论
    @Test
    public void sellerEvaluationTest() throws Exception {
        for(EvaluateVo2 evaluateVo2 : evaluateService.sellerEvaluation(2000000))
        {
        System.out.println(evaluateVo2);
        }
    }

    //根据商家选择的条件，进行评论的模糊查询
    @Test
    public void searchEvaluationTest() throws Exception {
        for(EvaluateVo2 evaluateVo2 :evaluateService.searchEvaluation(2000001,"评论","娃",""))
        {
            System.out.println(evaluateVo2);
        }
    }
}
