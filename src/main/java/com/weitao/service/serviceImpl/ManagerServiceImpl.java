package com.weitao.service.serviceImpl;

import com.weitao.bean.Manager;
import com.weitao.dao.ManagerMapper;
import com.weitao.service.ManagerService;
import com.weitao.utils.MD5;
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

    /**
     * 根据管理员mId查找管理员的信息
     *
     * @param manager
     * @return
     */
    @Override
    public int login(Manager manager) {
        //1、根据前端获得的管理员mId查找数据库中的管理员信息
        Manager manager1 = managerMapper.selectByPrimaryKey(manager.getmId());

        //2、判断管理员是否存在
        if (manager1 == null)
            return 1;

        //3、验证密码是否正确
        String password = MD5.md5(manager.getmPassword());
        if (!password.equals(manager1.getmPassword()))
            return 2;

        if (manager1.getmAuthority()==0)
            return 0;
        return 3;
    }

    @Override
    public int addManager(Manager manager) {
        String password = MD5.md5(manager.getmPassword());
//        管理员密码加密
        manager.setmPassword(password);
//        权限设置为0
        manager.setmAuthority((byte) 0);

        if (managerMapper.addManager(manager) != 0) {
//            假如添加管理员成功，则返回刚刚新管理员的id
            return manager.getmId();
        } else {
            return 0;
        }
    }
}
