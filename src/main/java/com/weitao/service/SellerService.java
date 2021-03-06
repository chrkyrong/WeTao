package com.weitao.service;

import com.github.pagehelper.PageInfo;
import com.weitao.bean.Seller;

import java.util.Map;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/10/1
 * @Time: 8:30
 **/
public interface SellerService {
    //注册
    Seller register(Seller seller);

    //登录
    int login(Seller seller) throws Exception;

    //根据商家sId查找商家信息
    Seller findSellerBySid(Integer sId);

    //修改商家信息
    Boolean modifySeller(Seller seller);

    //修改商家的登录密码
    int modifySellerPassword(Seller seller);

    Seller getSellerId(Long iId);

    PageInfo lookSellers(int pageNum, int pageSize);//分页查询所有卖家

    PageInfo getConditions(Map<String,Object> map, int pageNum, int pageSize);//多条件查询卖家

    Boolean lockBySellerId(int sellerId);//封用户

    Boolean unlockBySellerId(int sellerId);//解封用户
}
