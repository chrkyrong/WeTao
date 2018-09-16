package com.weitao.service.serviceImpl;

import com.weitao.bean.Store;
import com.weitao.dao.StoreMapper;
import com.weitao.service.StoreService;
import com.weitao.vo.StoreVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    //    商家，搜索自己拥有的所有商店
    @Override
    public List<Store> seleteStore(Store store) {
        return storeMapper.seleteStore(store);
    }

    //    管理员，搜索所有商店
    @Override
    public List<StoreVo> managerSeleteStore(int status) {
        if (status != 0 && status != 1||status != 1 && status != 0) {
            return storeMapper.managerSelectByStatus(status);
        } else {
            return storeMapper.managerSelectStore();
        }
    }

    @Override
    public StoreVo managerSelectById(int stId) {
        return storeMapper.managerSelectById(stId);
    }

    //    添加店铺
    @Override
    public boolean insertStore(Store store) throws Exception {
//        将店铺状态默认为1
        store.setStStatus((byte) 0);
//        执行添加方法，返回insert条数
        int insert = storeMapper.insertSelective(store);
        if (insert == 1) {
//            插入成功返回的是1
            return true;
        }
        return false;
    }

    //    修改店铺名/状态
    @Override
    public boolean updateStore(Store store) throws Exception {
        boolean result = false;
        if (store.getStStatus() != 0) {
            int update = storeMapper.updateByPrimaryKeySelective(store);
            if (update == 1) {
//            更新店铺名成功返回的是1
                result = true;
            }
        } else {
            //还没开始写
        }
        return result;
    }
}
