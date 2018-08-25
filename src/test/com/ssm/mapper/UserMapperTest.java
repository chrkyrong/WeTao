package com.ssm.mapper;

import com.ssm.bean.User;
import com.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lzr on 2018/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        int id=1;
        System.out.println(userMapper.selectByPrimaryKey(id));
    }


}