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
@RequestMapping("/car")
public class CarController {
    //测试数据
    private static final Integer uId=101;

    @Autowired
    private CarService service;

    /**
     * 根据用户uId查找购物车
     * @return
     */
    @GetMapping("/find")
    public Result find(){
        List<ItemsCar> list = service.findCar(uId);
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
    @GetMapping("/delete/{iId}")
    public Result delete(@PathVariable("iId") Integer iId){
        int count = service.removeCar(iId,uId);
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
    @GetMapping("/addNum/{iId}")
    public Result addNum(@PathVariable("iId") Integer iId){
        int count = service.updateAddCar(iId,uId);
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
    @GetMapping("/cutNum/{iId}")
    public Result cutNum(@PathVariable("iId") Integer iId){
        int count = service.updateCutCar(iId,uId);
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
    @GetMapping("/add/{iId}/{number}")
    public Result add(@PathVariable("iId") Integer iId,@PathVariable("number") Integer number){
        Integer sId = service.findSellerId(iId);
        int count = service.addCar(iId,uId,number,sId);
        if (count!=0)
            return ResultUtil.success();
        else
            return ResultUtil.error("加入购物车失败","1");
    }
}
