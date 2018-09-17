package com.weitao.dao;

import com.weitao.bean.Seller;
import com.weitao.bean.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author:Cc
 * @Date:2018/9/16
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-16 09:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StoreMapperTest {
    @Autowired
    StoreMapper storeMapper;

//    添加店铺
    @Test
    public void insertStoreTset() throws Exception {
        Store store = new Store("大木瓜店", (byte) 0, 2000000);
        int result = storeMapper.insertSelective(store);
        System.out.println(result);
    }

//    修改店铺名字
    @Test
    public void updateNameTest() throws Exception {
        Store store = new Store();
        store.setStId(7000001);
        store.setStName("大冬瓜店");
        int result = storeMapper.updateByPrimaryKeySelective(store);
        System.out.println(result);
    }

    @Test
    public void managerSelectStoreTest() throws Exception {
        int status = 1;

//    根据店铺状态，查询查询店铺
        System.out.println(storeMapper.managerSelectByStatus(status));

//    查询所有店铺
        System.out.println(storeMapper.managerSelectStore());

    }

//    查询id为7000000的店铺
    @Test
    public void selectByIdTest() throws Exception {
        int stId = 7000000;
        System.out.println(storeMapper.managerSelectById(stId));
    }

//    查询id为2000000卖家拥有的店铺
    @Test
    public void selectStoreBySellerIdTest() throws Exception {
        Seller seller = new Seller();
        seller.setsId(2000000);
        System.out.println(storeMapper.selectStoreBySellerId(seller));
    }

//    模糊查询卖家名字所拥有的店铺
    @Test
    public void selectStoreBySellerAccountdTest() throws Exception {
        Seller seller = new Seller();
        seller.setsAccount("大");
        System.out.println(storeMapper.selectStoreBySellerAccount(seller));
    }

//    模糊查询店铺名字
    @Test
    public void selectStoreByStoreNameTest() throws Exception {
        String stName = "瓜";
        System.out.println(storeMapper.selectStoreByStoreName(stName));
    }
}
