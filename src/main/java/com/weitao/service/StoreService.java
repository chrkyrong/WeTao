package com.weitao.service;

import com.weitao.bean.Store;
import com.weitao.vo.StoreVo;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ycp on 2018/9/5.
 */
public interface StoreService {
    //    商家，搜索自己拥有的所有店铺
    public List<Store> seleteStore(Store store);

    //    商家，根据店铺状态和搜索框模糊搜索自己拥有的所有店铺
    public List<Store> sellerSelectByCondition(Integer sellerId, String research, Byte stStatus);

    //    商家，添加店铺
    public boolean insertStore(String stName, Integer sellerId) throws Exception;

    //    商家，修改店铺信息
    public boolean updateStore(Store store) throws Exception;

    //    管理员，搜索所有店铺
    public List<StoreVo> managerSeleteStore(int Status);

    //    管理员，模糊搜索店铺
    public List<StoreVo> managerSeach(String research, String condition, Byte stStatus);

    //    管理员，封店或者是解封
    public boolean changeStoreStatus(Store store);

}
