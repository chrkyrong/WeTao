package com.weitao.service;

import com.weitao.bean.Car;
import com.weitao.bean.ItemsCar;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/20
 * @Time: 21:14
 **/
public interface CarService {
    //查找用户uId的所有加购且商品状态为正常的商品
    List<ItemsCar> findCar(Integer uId);

    //根据商品的iId删除购物车商品
    int removeCar(Integer iId,Integer uId);

    //根据商品的iId增加购物车商品数量
    int updateAddCar(Integer iId,Integer uId);

    //根据商品的iId减少购物车商品数量
    int updateCutCar(Integer iId,Integer uId);

    //用户下单时，根据用户uId删除所有加购且商品状态为正常的商品
    int removeCar(Integer uId);

    //增加购物（购物车中不存在该用户加购的商品）
    int addCar(Integer iId,Integer uId,Integer number,Integer sId);

    //查找商品的商家id
    Integer findSellerId(Integer iId);

    //查找加入购物车的商品是否已经存在在购物车中
    Integer isExistCar(Integer iId,Integer uId);

    //增加购物（购物车中存在该用户加购的商品）
    int updateCar(Integer iId,Integer uId,Integer number);
}
