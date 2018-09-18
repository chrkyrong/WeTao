package com.weitao.service;

import com.weitao.bean.Evaluate;
import com.weitao.vo.EvaluateVo;

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
    public boolean insertEvaluate(Evaluate evaluate) throws Exception;

//    根据商品id，查询所有该商品的评价
    public List<EvaluateVo> selectEvaluate(Integer itemsId) throws Exception;
}
