package com.weitao.dao;

import com.weitao.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertSelective() throws Exception {
        User user=new User();
        user.setuPassword("123456");
        user.setuTel("1123123123123");
        user.setuIcon("abc123");
        user.setuAddress1("深圳");
        user.setuSex("男");
        user.setuUsername("chrky");
        userMapper.insertSelective(user);
    }

}