package com.weitao.service.serviceImpl;

import com.weitao.dao.ManagerMapper;
import com.weitao.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/10/9
 * @Time: 10:28
 **/
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
}
