package com.weitao.service;

import com.weitao.bean.Manager;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/10/9
 * @Time: 10:28
 **/
public interface ManagerService {

    //根据管理员的mId查找管理员信息
    int login(Manager manager);

//    添加权限为0的管理员
    int addManager(Manager manager);
}
