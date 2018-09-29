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
import org.springframework.web.bind.annotation.RequestParam;

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
    public boolean changeStoreStatus(Store store) {
//        判断是否修改成功的key
        boolean result = false;
//        判断店铺名是否为空
        if (storeMapper.updateByPrimaryKeySelective(store) != 0) {
//                将其店铺下的所有商品状态都修改为1
            List<Integer> stIdList = new ArrayList<>();
            stIdList.add(store.getStId());
            if (itemsMapper.changeItemsStatus(stIdList, store.getStStatus()) > 0) {
                System.out.println("change store's items success");
                result = true;
            }
        }
        return result;
    }


    //    添加店铺
    @Override
    public boolean insertStore(String stName, Integer sellerId) throws Exception {
        Store store = new Store();
//        设置商家id
        store.setSellerId(sellerId);
//        设置店铺名
        store.setStName(stName);
//        将店铺状态默认为0
        store.setStStatus((byte) 0);
//        执行添加方法，返回insert条数
        int insert = storeMapper.insertSelective(store);
        if (insert == 1) {
//            插入成功返回的是1
            return true;
        }
        return false;
    }

    //    买家修改店铺名/状态
    @Override
    public boolean updateStore(Store store) throws Exception {
//        判断是否修改成功的key
        boolean result = false;
//        判断店铺名是否为空
        if (store.getStName().equals(null) || store.getStName().equals("")) {
//                防止同时修改了名字
            System.out.println(storeMapper.selectByPrimaryKey(store.getStId()).getStName());
//            关闭店铺
            if (storeMapper.updateByPrimaryKeySelective(store) != 0) {
//                将其店铺下的所有商品状态都修改为1
                List<Integer> stIdList = new ArrayList<>();
                stIdList.add(store.getStId());
                if (itemsMapper.changeItemsStatus(stIdList, store.getStStatus()) > 0) {
                    System.out.println("change store's information success");
                    result = true;
                }
            }

        } else {
//            防止同时修改了状态
            store.setStStatus((byte) 0);
//            修改店铺名字
            if (storeMapper.updateByPrimaryKeySelective(store) != 0) {
                System.out.println("change store's stName success");
                result = true;
            }
        }

        return result;
    }
}
