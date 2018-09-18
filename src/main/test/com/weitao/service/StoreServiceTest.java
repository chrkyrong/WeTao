package com.weitao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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

//    管理员，模糊搜索商店，可输入商家id，店铺id（精确搜索），输入商家名字，店铺名字（模糊搜索）
    @Test
    public void managerSeachTset() throws Exception {
        System.out.println(storeService.managerSeach("大"));
    }
}
