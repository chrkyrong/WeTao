package com.weitao.dao;

import com.weitao.bean.Car;
import com.weitao.bean.ItemsCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    //1、查找        （查找用户uId的所有加购且商品状态为正常的商品）
    List<ItemsCar> selectAllItemsOfCarByUid(Integer uId);

    //2、部分删除    （根据商品的iId删除购物车商品）
    int deleteCarByIid(@Param("iId") Integer iId,@Param("uId") Integer uId);

    //3、整体删除    （用户下单时，根据用户uId删除所有加购且商品状态为正常的商品）
    int deleteCarByUid(Integer uId);

    //4、部分增加    （根据商品的iId增加购物车商品数量）
    int updateAddCarItemsNumberByIid(@Param("iId") Integer iId,@Param("uId") Integer uId);

    //5、部分减少    （根据商品的iId减少购物车商品数量）
    int updateCutCarItemsNumberByIid(@Param("iId") Integer iId,@Param("uId") Integer uId);

    //6、增加购物（购物车中不存在该用户加购的商品）
    int insertCarByIidAndUid(@Param("iId") Integer iId,@Param("uId") Integer uId,@Param("number") Integer number,@Param("sId") Integer sId);

    //7、查找商品的商家id
    Integer selectSellerIdByItemsId(Integer iId);

    //8、查找加入购物车的商品是否已经存在在购物车中
    Integer isExistCar(@Param("iId") Integer iId, @Param("uId") Integer uId);

    //9、增加购物（购物车中存在该用户加购的商品）
    int updateCarByIidAndUid(@Param("iId") Integer iId,@Param("uId") Integer uId,@Param("number") Integer number);
}