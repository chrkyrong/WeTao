package com.weitao.service.serviceImpl;

import com.weitao.bean.Seller;
import com.weitao.dao.SellerMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.exception.SellerException;
import com.weitao.service.SellerService;
import com.weitao.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/10/1
 * @Time: 8:35
 **/
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerMapper sellerMapper;

    /**
     * 商家注册
     * @param seller
     * @return
     */
    @Override
    public Seller register(Seller seller) {
        //1、先将商家注册的密码进行MD5加密操作并替换seller里边的sPassword属性
        String password= MD5.md5(seller.getsPassword());
        seller.setsPassword(password);

        //2、对注册的商家没有上传头像的设置默认头像，并设置状态为0
        if (seller.getsIcon()==null)
            seller.setsIcon("seller_default.jpg");
        seller.setsStutas((byte) 0);

        //
        System.out.println(seller.getsAddress());

        //3、将商家信息保存进数据库中
        if (sellerMapper.insertSelective(seller)==1)
            return seller;
        return null;
    }

    /**
     * 商家登录
     * @param seller
     * @return
     * @throws Exception
     */
    @Override
    public int login(Seller seller) throws Exception {
        //1、根据输入的商家sId查找数据库中的商家
        Seller seller1 = sellerMapper.selectByPrimaryKey(seller.getsId());

        //2、判断商家是否存在
        if (seller1==null)
            return 1;

        //3、判断商家是否违规
        if (seller1.getsStutas()==1)
            return 2;

        //4、先将商家登录的密码进行MD5加密操作，再验证密码是否通过
        String password= MD5.md5(seller.getsPassword());
        if (!password.equals(seller1.getsPassword()))
            return 3;

        return 0;
    }

    /**
     * 根据商家的sId查找商家信息
     * @param sId
     * @return
     */
    @Override
    public Seller findSellerBySid(Integer sId) {
        return sellerMapper.selectByPrimaryKey(sId);
    }

    /**
     * 修改商家信息
     * @param seller
     * @return
     */
    @Override
    public Boolean modifySeller(Seller seller) {
        if (seller.getsIcon()==null)
            seller.setsIcon("seller_default.jpg");
        if (sellerMapper.updateByPrimaryKeySelective(seller)==1)
            return true;
        return false;
    }

    /**
     * 更改商家的密码
     * @param seller
     * @return
     */
    @Override
    public int modifySellerPassword(Seller seller) {
        //1、根据登录的商家sId
        Seller seller1 = sellerMapper.selectByPrimaryKey(seller.getsId());

        //2、判断商家的状态
        if (seller1.getsStutas()==1)
            return 1;

        //3、验证电话号码
        if (!seller.getsTel().equals(seller1.getsTel()))
            return 2;

        //4、将输入的密码进行MD5加密，再替换seller里边的sPassword属性
        String password = MD5.md5(seller.getsPassword());
        seller.setsPassword(password);

        //5、修改商家密码
        if (sellerMapper.updateByPrimaryKeySelective(seller)==1)
            return 0;
        return 3;
    }
}
