package com.weitao.service.serviceImpl;

import com.weitao.bean.Collection;
import com.weitao.bean.ItemsCollection;
import com.weitao.dao.CollectionMapper;
import com.weitao.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/19
 * @Time: 14:55
 **/
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper mapper;

    /**
     * 查找用户uId的所有收藏且商品状态为正常的商品
     * @param uId
     * @return
     */
    @Override
    public List<ItemsCollection> findCollection(Integer uId) {
        List<ItemsCollection> list = mapper.selectAllItemsOfCollectionByUid(uId);
        return list;
    }

    /**
     * 根据收藏夹的主键cId删除收藏商品
     * @param cId
     * @return
     */
    @Override
    public int removeCollection(int cId) {
        return mapper.deleteCollectionByCid(cId);
    }

    /**
     * 将商品加入收藏夹
     * @param iId
     * @return
     */
    @Override
    public int addCollection(int iId,int uId) {
        return mapper.insertCollection(iId,uId);
    }
}

