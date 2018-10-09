package com.weitao.dao;

import com.weitao.bean.Manager;
import com.weitao.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:Cc
 * @Date:2018/10/9
 * @program: weitao
 * @description: ${测试ManageMapper}
 * @create: 2018-10-09 15:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManageMapperTest {

    @Autowired
    private ManagerMapper managerMapper;

    @Test
    public void addManagerTest() throws Exception {
        Manager manager = new Manager();
        manager.setmPassword(MD5.md5("123456"));
        manager.setmAuthority((byte) 0);

        managerMapper.addManager(manager);
//        返回添加后的主键
        System.out.println(manager.getmId());
    }

    @Test
    public void name() throws Exception {
        Integer aa = 0;
        if(aa == 1){
            System.out.println("dui");
        }
        else System.out.println(".......");
    }
}
