package com.weitao.service.serviceImpl;

import com.weitao.bean.Evaluate;
import com.weitao.dao.EvaluateMapper;
import com.weitao.service.EvaluateService;
import com.weitao.vo.EvaluateVo;
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

    //    用户，添加评价
    @Override
    public boolean insertEvaluate(Evaluate evaluate) throws Exception {
        int insert = evaluateMapper.insertSelective(evaluate);
        if (insert == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    根据商品id，查询所有该商品的评价
    @Override
    public List<EvaluateVo> selectEvaluate(Integer itemsId) throws Exception {
        List<EvaluateVo> result = evaluateMapper.selectByItemsId(itemsId);
        return result;
    }
}
