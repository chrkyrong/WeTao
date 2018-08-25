package com.ssm.service;

import com.ssm.bean.User;
import org.springframework.stereotype.Service;

/**
 * Created by lzr on 2018/8/23.
 */
public interface UserService {

    User selectByPrimaryKey(Integer id);
}
