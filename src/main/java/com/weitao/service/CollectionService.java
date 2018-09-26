package com.weitao.service;

import com.weitao.bean.ItemsCollection;
import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/19
 * @Time: 14:54
 **/
public interface CollectionService {
    //查找uId用户收藏的所有商品,返回的是List<ItemsCollection>
    List<ItemsCollection> findCollection(Integer uId);

    //删除收藏
    int removeCollection(int cId);

    //增加收藏
    int addCollection(int iId,int uId);
}
