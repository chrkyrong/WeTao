package com.weitao.controller;

import com.weitao.bean.Collection;
import com.weitao.bean.ItemsCollection;
import com.weitao.service.CollectionService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/19
 * @Time: 14:51
 **/
@RestController
@RequestMapping("/coll")
public class CollectionController {
    //测试数据
    private static final Integer uId=101;

    @Autowired
    private CollectionService service;

    /**
     * 【收藏夹】
     * 查找用户uId的所有收藏且商品状态为正常的商品
     * @return
     */
    @GetMapping("/find")
    public Result find(){
        List<ItemsCollection> list = service.findCollection(uId);
        return ResultUtil.success(list);
    }

    /**
     * 【收藏夹】
     * 根据收藏夹的主键cId删除收藏商品
     * @param cId
     * @return
     */
    @GetMapping("/delete/{cId}")
    public Result delete(@PathVariable("cId") int cId){
        int count = service.removeCollection(cId);
        if(count!=0){
            return ResultUtil.success();
        } else {
            return ResultUtil.error("删除失败！","1");
        }
    }

    /**
     * 收藏夹
     * 商品加入收藏夹
     * @param
     * @return
     */
    @GetMapping("/add/{iId}")
    public Result add(@PathVariable("iId") int iId){
        int count = service.addCollection(iId,uId);
        if(count!=0){
            return ResultUtil.success();
        } else {
            return ResultUtil.error("加入失败！","1");
        }
    }
}