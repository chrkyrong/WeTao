package com.weitao.dao;

import com.weitao.bean.Evaluate;
import com.weitao.vo.EvaluateVo2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        evaluate.setePhotos("bg-1.jpg");
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

    //    商家，查询该商家的收到的所有的评价
    @Test
    public void selectBySellerTest() throws Exception {
        for (EvaluateVo2 aa : evaluateMapper.selectBySeller(2000000)) {
            System.out.println(aa);
        }
    }

    //    商家，根据条件模糊搜索
    /*@Test
    public void selectByConditionTest() throws Exception {
        List<EvaluateVo2> aa = evaluateMapper.selectByCondition(2000000, "");
        for (EvaluateVo2 evaluateVo2 : aa) {
            System.out.println(evaluateVo2);
        }
    }*/

    //    商家，模糊查询所收到的评论
    @Test
    public void searchEvaluationTest() throws Exception {
        List<EvaluateVo2> aa = evaluateMapper.searchEvaluation(2000001, "", "", null, "瓜", "");
        for (EvaluateVo2 evaluateVo2 : aa) {
            System.out.println(evaluateVo2);
        }
    }
}
