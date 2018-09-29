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
//        System.out.println(storeService.changeStoreStatus(stId, (byte) 0));
    }

    @Test
    public void managerSeachTest() throws Exception {
//        设置查询条件
//        String condition = "商家";
//        String condition = "商家id";
        String condition = "店铺";
//        String condition = "店铺id";

//        设置搜索框内容
        String research = "";
//        String research = "弟";

//        设置查询店铺状态
        Byte stStatus = 0;
//        Byte stStatus = "1";

        for(StoreVo vo : storeService.managerSeach(research,condition,stStatus))
        {
        System.out.println(vo);
        }
    }

    @Test
    public void updateStoreTest() throws Exception {
        Store store = new Store();
//        store.setStName("斐济店铺");
        store.setStStatus((byte) 0);
        store.setStId(7000001);
        boolean result = storeService.updateStore(store);
        System.out.println(result);
    }
}
