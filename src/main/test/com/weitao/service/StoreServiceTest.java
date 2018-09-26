package com.weitao.service;

import com.weitao.bean.Store;
import com.weitao.vo.StoreVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 15:18
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StoreServiceTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void changeStoreStatusTest() throws Exception {
        List<Integer> stId = new ArrayList<>();
        stId.add(7000000);
        stId.add(7000001);
        stId.add(7000002);
        System.out.println(storeService.changeStoreStatus(stId, (byte) 0));
    }

    @Test
    public void updateStoreTest() throws Exception {
        Store store = new Store();
        store.setStId(7000001);
        store.setStName("冬瓜店");
        System.out.println(storeService.updateStore(store));
    }

    @Test
    public void managerSeachTest() throws Exception {
        Store store = new Store();
//        设置查询店铺id
//        store.setStId(01);
//        设置查询店铺名字
//        store.setStName("");
//        设置查询店铺状态
        store.setStStatus((byte) 0);
//        设置查询卖家名字，卖家id

    }
}
