package com.weitao.dao;

import com.weitao.bean.Evaluate;
import com.weitao.vo.EvaluateVo;

import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKeyWithBLOBs(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<EvaluateVo> selectByItemsId(int itemsId);
}