package com.weitao.dao;

import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer iId);

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

    /*查询所有商品，显示销售量最高的九件商品*/
    List<Items> selectItems();

    /*查询所有商品，显示最新上架的九件商品*/
    List<Items> selectItems1();

    /*查询所有商品，显示库存最多的前5件商品展示*/
    List<Items> selectItemsExsit();
    /*By CC*/
   /*商家店铺被封或解封，商品状态更变*/
    int changeItemsStatus(@Param("storeId")List<Integer> storeId,@Param("iStatus")Byte iStatus);

    /*根據id查詢單個商品*/
    List<Items> selectByPrimaryKey1(Integer iId);

    /*查询所有商品*/
    List<Items> selectAll(Integer storeId);

    /*商家根据不同条件查询自己的商品*/
    List<Items> sellerItems(@Param("storeId") Integer storeId,@Param("search") String search,@Param("iStatus") Integer iStatus);

}