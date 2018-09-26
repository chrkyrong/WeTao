package com.weitao.dao;

import com.weitao.bean.Collection;
import com.weitao.bean.ItemsCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    //查找用户uId的所有收藏且商品状态为正常的商品
    List<ItemsCollection> selectAllItemsOfCollectionByUid(Integer uId);

    //根据收藏夹的主键cId删除收藏商品
    int deleteCollectionByCid(int cId);

    //商品在商品页面将商品加入收藏夹
    int insertCollection(@Param("iId") int iId ,@Param("uId") int uId);
}