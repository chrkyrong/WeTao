package com.weitao.dao;

import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Items record);

    int insertSelective(Items record);
    /*根據id查詢單個商品*/
    List<Items> selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
    /*根据各种条件来查询，父类，商品名，子类，升序排序条件*/
    List<ItemsVo> selectItemsUp(@Param("caFather") String caFather,
                              @Param("iName") String iName,
                              @Param("caId") String caId ,@Param("type") String type);
    /*根据各种条件来查询，父类，商品名，子类，降序排序条件*/
    List<ItemsVo> selectItemsDown(@Param("caFather") String caFather,
                              @Param("iName") String iName,
                              @Param("caId") String caId ,@Param("type") String type);
    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    List<ItemsVo> selectItemsAll(@Param("search") String search);

<<<<<<< HEAD
    /*查询所有商品，显示销售量最高的九件商品*/
    List<Items> selectItems();

    /*查询所有商品，显示最新上架的九件商品*/
    List<Items> selectItems1();
=======
//    By CC
//    商家店铺被封或解封，商品状态更变
    int changeItemsStatus(@Param("storeId")List<Integer> storeId,@Param("iStatus")Byte iStatus);

>>>>>>> 2981b4295ca342c8b714af0e6059069ce05661c7
}