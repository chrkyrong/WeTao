package com.weitao.service.serviceImpl;

import com.weitao.bean.ItemsCar;
import com.weitao.dao.CarMapper;
import com.weitao.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/9/20
 * @Time: 21:17
 **/
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    //根据用户uId查找该用户加购而且商品状态正常的商品
    @Override
    public List<ItemsCar> findCar(Integer uId) {
        return carMapper.selectAllItemsOfCarByUid(uId);
    }

    //根据商品iId和对应的用户uId删除加购记录
    @Override
    public int removeCar(Integer iId,Integer uId) {
        return carMapper.deleteCarByIid(iId,uId);
    }

    //根据商品iId和对应的用户uId增加商品的加购数量
    @Override
    public int updateAddCar(Integer iId,Integer uId) {
        return carMapper.updateAddCarItemsNumberByIid(iId,uId);
    }

    //根据商品iId和对应的用户uId减少商品的加购数量
    @Override
    public int updateCutCar(Integer iId, Integer uId) {
        return carMapper.updateCutCarItemsNumberByIid(iId, uId);
    }

    //下单之后，根据用户uId删除该用户加购且商品正常的商品
    @Override
    public int removeCar(Integer uId) {
        return carMapper.deleteCarByUid(uId);
    }

    //根据登录的 用户uId、对应的商品iId、加购的数量number 和 销售该商品的商家sId 增加购物车记录
    @Override
    public int addCar(Integer iId, Integer uId, Integer number, Integer sId) {
        return carMapper.insertCarByIidAndUid(iId, uId, number, sId);
    }

    //根据商品的iId查找对应的销售者sId
    @Override
    public Integer findSellerId(Integer iId) {
        return carMapper.selectSellerIdByItemsId(iId);
    }
}
