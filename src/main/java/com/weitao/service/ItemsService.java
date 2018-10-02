package com.weitao.service;

import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */
@Service
public interface ItemsService {
    /*插入商品信息*/
    public boolean insertItems(Items items) throws  Exception;

    /*根据各种条件来查询，父类，商品名，子类，升序排序条件*/
    public List<ItemsVo> selectItemsUp(String caFather, String iName, String caId ,String type)
                                        throws  Exception;

    /*根据各种条件来查询，父类，商品名，子类，降序排序条件*/
    public List<ItemsVo> selectItemsDown(String caFather, String iName, String caId, String type)throws  Exception;

    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    public List<ItemsVo> selectItemsAll(String search);

    /*显示所有商品,显示销售量最高的九件商品*/
    public List<Items> selectItems();

    /*显示所有商品，显示最新上架的九件商品*/
    public List<Items> selectItems1();

    /*显示所有商品，显示库存最多的五件商品*/
    public List<Items> selectItemsExsit();

    /*查詢當個商品*/
    public List<Items> selectOneItems(Integer iId);

    /*查询所有商品*/
    public List<Items> selectAll(Integer storeId);

    /*卖家根据条件查询各店铺下的商品*/
    public List<Items> sellerItems(Integer storeId,String search,Integer iStatus);

    /*根据商品id更改商品的状态*/
    public int deleteItems(Integer iId);

    /*根据商品id更改商品信息*/
    public int updateItems(Items items);
}
