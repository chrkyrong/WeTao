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


    //    管理员，模糊搜索
    @Override
    public List<StoreVo> managerSeach(String select) {
//        创建存放数据结果的result(List)
        List<StoreVo> result = new ArrayList<StoreVo>();

//        首先传来的是字符串，进行店铺名字的模糊搜索或者是商家名字的模糊搜索
//        查询店铺
        if (storeMapper.selectStoreByStoreName(select) != null)
            result.addAll(storeMapper.selectStoreByStoreName(select));

//        查询卖家姓名
        Seller seller = new Seller();
        seller.setsAccount(select);
        if (storeMapper.selectStoreBySellerAccount(seller) != null)
            result.addAll(storeMapper.selectStoreBySellerAccount(seller));


//        使用正则表达式判断字符串是否为整型
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(select);

        if (isNum.matches()) {

//            字符串为整型，则转化为id(int)
            int id = Integer.parseInt(select);
//            创建一个第三个list存id模糊查询结果

//            判断id是否属于店铺id
            if (7000000 <= id && 8000000 > id) {
//                执行查询店铺id
                if (storeMapper.managerSelectById(id) != null)
                    result.add(storeMapper.managerSelectById(id));
            }
//            判断id是否属于商家id
            else if (2000000 <= id && 3000000 > id) {

//                执行查询商家id
                seller.setsId(id);
                if (storeMapper.selectStoreBySellerId(seller) != null)
                    result.addAll(storeMapper.selectStoreBySellerId(seller));
            }
        }

//        去重算法，需要优化

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = result.size() - 1; j > i; j--) {
                if (result.get(j).getStId().equals(result.get(i).getStId())) {
                    result.remove(j);
                }
            }
        }

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
