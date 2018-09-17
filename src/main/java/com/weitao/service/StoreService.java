package com.weitao.service;

import com.weitao.bean.Store;
import com.weitao.vo.StoreVo;

import java.util.List;

/**
 * Created by ycp on 2018/9/5.
 */
public interface StoreService {
//    商家，搜索自己拥有的所有店铺
    public List<Store> seleteStore(Store store);

//    商家，添加店铺
    public boolean insertStore(Store store) throws Exception;

//    修改店铺名、状态
    public boolean updateStore(Store store) throws Exception;

//    管理员，搜索所有店铺
    public List<StoreVo> managerSeleteStore(int Status);

//    管理员，根据店铺id搜索商店
    public StoreVo managerSeach(String select);

}
