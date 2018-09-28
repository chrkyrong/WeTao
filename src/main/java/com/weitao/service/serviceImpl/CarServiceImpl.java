package com.weitao.service.serviceImpl;

import com.weitao.bean.ItemsCar;
import com.weitao.dao.CarMapper;
import com.weitao.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/20
 * @Time: 21:17
 **/
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<ItemsCar> findCar(Integer uId) {
        return carMapper.selectAllItemsOfCarByUid(uId);
    }

    @Override
    public int removeCar(Integer iId,Integer uId) {
        return carMapper.deleteCarByIid(iId,uId);
    }

    @Override
    public int updateAddCar(Integer iId,Integer uId) {
        return carMapper.updateAddCarItemsNumberByIid(iId,uId);
    }

    @Override
    public int updateCutCar(Integer iId, Integer uId) {
        return carMapper.updateCutCarItemsNumberByIid(iId, uId);
    }

    @Override
    public int removeCar(Integer uId) {
        return carMapper.deleteCarByUid(uId);
    }

    @Override
    public int addCar(Integer iId, Integer uId, Integer number, Integer sId) {
        return carMapper.insertCarByIidAndUid(iId, uId, number, sId);
    }

    @Override
    public Integer findSellerId(Integer iId) {
        return carMapper.selectSellerIdByItemsId(iId);
    }
}
