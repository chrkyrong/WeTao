package com.weitao.dao;

import com.weitao.bean.Evaluate;
import com.weitao.vo.EvaluateVo;
import com.weitao.vo.EvaluateVo2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKeyWithBLOBs(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    //    根据商品id，查询所有该商品的评价
    List<EvaluateVo> selectByItemsId(Integer itemsId);

    //    根据商家id，查询该商家的收到的所有的评价
    List<EvaluateVo2> selectBySeller(Integer sellerId);

    //    商家，模糊搜索
    List<EvaluateVo2> searchEvaluation(@Param("sellerId") Integer sellerId,
                                       @Param("stName") String stName,
                                       @Param("iName") String iName,
                                       @Param("eLevel") Byte eLevel,
                                       @Param("eDescription") String eDescription,
                                       @Param("oDate") String oDate);
}