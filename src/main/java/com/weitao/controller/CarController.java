package com.weitao.controller;

import com.weitao.bean.ItemsCar;
import com.weitao.service.CarService;
import com.weitao.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/20
 * @Time: 21:19
 **/
@RestController
public class CarController {
    //测试数据
    private static final Integer uId=101;

    @Autowired
    private CarService carService;

    /**
     * 根据用户uId查找购物车
     * @return
     */
    @GetMapping("/car/find")
    public Result find(){
        List<ItemsCar> list = carService.findCar(uId);
        for(ItemsCar car:list){
            car.setTotalPrice(car.getiPrice().multiply(new BigDecimal(car.getNumber())));
        }
        return ResultUtil.success(list);
    }

    /**
     * 根据商品iId删除用户uId购物车的商品
     * @param iId
     * @return
     */
    @GetMapping("/car/delete/{iId}")
    public Result delete(@PathVariable("iId") Integer iId){
        int count = carService.removeCar(iId,uId);
        if (count!=0)
            return ResultUtil.success();
        else
            return ResultUtil.error("删除失败！","1");
    }

    /**
     * 根据商品iId增加用户uId购物车商品的数量
     * @param iId
     * @return
     */
    @GetMapping("/car/addNum/{iId}")
    public Result addNum(@PathVariable("iId") Integer iId){
        int count = carService.updateAddCar(iId,uId);
        if (count!=0)
            return ResultUtil.success();
        else
            return ResultUtil.error("增加失败","1");
    }

    /**
     * 根据商品iId减少用户uId购物车商品的数量
     * @param iId
     * @return
     */
    @GetMapping("/car/cutNum/{iId}")
    public Result cutNum(@PathVariable("iId") Integer iId){
        int count = carService.updateCutCar(iId,uId);
        if (count!=0)
            return ResultUtil.success();
        else
            return ResultUtil.error("减少失败","1");
    }

    /**
     * 加入购物车
     * @param iId
     * @param number
     * @return
     */
    @GetMapping("/car/add/{iId}/{number}")
    public Result add(@PathVariable("iId") Integer iId,@PathVariable("number") Integer number){
        Integer sId = carService.findSellerId(iId);
        int count = carService.addCar(iId,uId,number,sId);
        if (count!=0)
            return ResultUtil.success();
        else
            return ResultUtil.error("加入购物车失败","1");
    }
}
