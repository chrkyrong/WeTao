package com.weitao.service.serviceImpl;

import com.weitao.bean.Seller;
import com.weitao.bean.Store;
import com.weitao.dao.ItemsMapper;
import com.weitao.dao.StoreMapper;
import com.weitao.service.StoreService;
import com.weitao.vo.StoreVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ycp on 2018/9/4.
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    //    商家，搜索自己拥有的所有商店
    @Override
    public List<Store> seleteStore(Store store) {
        return storeMapper.seleteStore(store);
    }

    //    管理员，搜索所有商店
    @Override
    public List<StoreVo> managerSeleteStore(int status) {
        if (status != 0 && status != 1 || status != 1 && status != 0) {
            return storeMapper.managerSelectByStatus(status);
        } else {
            return storeMapper.managerSelectStore();
        }
    }


    //    管理员，根据条件模糊搜索
    @Override
    public List<StoreVo> managerSeach(String research, String condition, Byte stStatus) {
//        创建存放数据结果的result(List)
        List<StoreVo> result = new ArrayList<StoreVo>();

//        初始化所有条件
        String stId = "";
        String sId = "";
        String sAccount = "";
        String stName = "";

//        判断查询条件
        switch (condition) {
            case "商家":
                sAccount = research;
                break;
            case "商家id":
                sId = research;
                break;
            case "店铺":
                stName = research;
                break;
            case "店铺id":
                stId = research;
                break;
        }
//        执行查询
        result = storeMapper.managerSelectByCondition(stId, stStatus, stName, sId, sAccount);
        return result;
    }


    //    管理员，封店或者是解封
    @Override
    public boolean changeStoreStatus(List<Integer> stId, byte stStatus) {
//        result为操作结果
        boolean result = false;
//        判断是否改变了店铺状态
        if (storeMapper.changeStoreStatus(stId, stStatus) != 0) {
//            改变商品状态
            int count = itemsMapper.changeItemsStatus(stId, stStatus);
            System.out.println(count);
            result = true;
        }
        return result;
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
        int update = storeMapper.updateByPrimaryKeySelective(store);
        if (update == 1) {
//            更新店铺名成功返回的是1
            result = true;
        }
        return result;
    }
}
