package com.weitao.controller;

import com.weitao.bean.Store;
import com.weitao.exception.ResultEnum;
import com.weitao.service.StoreService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:Cc
 * @Date:2018/9/27
 * @program: weitao
 * @description: ${商店的controller}
 * @create: 2018-09-27 08:18
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;


    //    商家添加一个新的店铺
    @RequestMapping(value = "/addNewStore", method = RequestMethod.POST)
    public Result addNewStore(@RequestParam("stName") String stName,
                              @SessionAttribute(value = "sId", required = false) Integer sellerId) throws Exception {
//        后台session获取卖家id
        if (storeService.insertStore(stName, sellerId))
//            添加店铺成功后带上sellerId返回
            return ResultUtil.success(sellerId);
        else
            return ResultUtil.error(ResultEnum.STORE_INSERT_FAIL);
    }


    //    商家修改店铺名字或者是关店
    @RequestMapping(value = "/sellerChangeStore", method = RequestMethod.POST)
    public Result sellerChangeStore(Store store) throws Exception {
        if (storeService.updateStore(store))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.STORE_CHANGE_FAIL);
    }

    //    商家查找出所有状态为属于他的店铺
    @RequestMapping(value = "/sellerSearchStore", method = RequestMethod.POST)
    public Result sellerSearchStore(@SessionAttribute(value = "sId", required = false) Integer sellerId,
                                    @RequestParam(value = "stStatus", defaultValue = "0") int stStatus) throws Exception {
//        后台session获取卖家id
        Store store = new Store();
        store.setSellerId(sellerId);
        store.setStStatus((byte) stStatus);
        List<Store> stores = storeService.seleteStore(store);
        return ResultUtil.success(stores);
    }

    //    管理员根据条件模糊搜索查询店铺
    @RequestMapping(value = "/researchStoreByCondition", method = RequestMethod.POST)
    public Result researchStoreByCondition(@RequestParam("research") String research,
                                           @RequestParam("condition") String condition,
                                           @RequestParam("stStatus") Byte stStatus) throws Exception {
        List<StoreVo> storeVoList = storeService.managerSeach(research, condition, stStatus);
        if (storeVoList != null)
            return ResultUtil.success(storeVoList);
        else
            return ResultUtil.error(ResultEnum.STORE_NOT_FOUND);
    }


    //    管理员修改店铺状态
    @RequestMapping(value = "/managerChangeStore", method = RequestMethod.POST)
    public Result managerChangeStore(Integer stId, Byte stStatus) throws Exception {
        Store store = new Store();
        store.setStId(stId);
        store.setStStatus(stStatus);
        if (storeService.changeStoreStatus(store))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.STORE_CHANGE_FAIL);
    }


    //    商家根据店铺状态和搜索框模糊搜索自己拥有的所有店铺
    @RequestMapping(value = "/selleResearchStore", method = RequestMethod.POST)
    public Result selleResearchStore(@SessionAttribute(value = "sId", required = false) Integer sellerId,
                                     String research, Byte stStatus) throws Exception {
        List<Store> storeList = storeService.sellerSelectByCondition(sellerId, research, stStatus);
        if (storeList.size() > 0)
            return ResultUtil.success(storeList);
        else
            return ResultUtil.error(ResultEnum.STORE_NOT_FOUND);
    }
}
