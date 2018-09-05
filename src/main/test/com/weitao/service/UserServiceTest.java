package com.weitao.service;

import com.weitao.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lzr on 2018/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceTest {
    @Test
    public void login() throws Exception {
        User user=new User();
        user.setuUsername("chrky");
        user.setuPassword("123456432");
        System.out.println(userService.login(user));
    }

    @Autowired
    private UserService userService;

    @Test
    public void register() throws Exception {
        User user=new User();
        user.setuPassword("123456");
        user.setuSex("男");
        user.setuUsername("abadsf");
        userService.register(user);
    }
}