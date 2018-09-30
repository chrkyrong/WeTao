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
 * @Description: WeTao
 * @Version: 1.0
 * @Date: 2018/9/19
 * @Time: 14:51
 **/
@RestController
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    /**
     * 【收藏夹】
     * 查找用户uId的所有收藏且商品状态为正常的商品
     * @return
     */
    @GetMapping("/coll/find")
    public Result find(@SessionAttribute(value = "uId", required = false)Integer uId){
        List<ItemsCollection> list = collectionService.findCollection(uId);
        return ResultUtil.success(list);
    }

    /**
     * 【收藏夹】
     * 根据收藏夹的主键cId删除收藏商品
     * @param cId
     * @return
     */
    @GetMapping("/coll/delete/{cId}")
    public Result delete(@SessionAttribute(value = "uId", required = false)Integer uId,@PathVariable("cId") int cId){
        int count = collectionService.removeCollection(cId);
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
    @GetMapping("/coll/add/{iId}")
    public Result add(@SessionAttribute(value = "uId", required = false)Integer uId,@PathVariable("iId") int iId){
        int count = collectionService.addCollection(iId,uId);
        if(count!=0){
            return ResultUtil.success();
        } else {
            return ResultUtil.error("加入失败！","1");
        }
    }

    @GetMapping("/coll/isExist/{iId}")
    public Result isExist(@SessionAttribute(value = "uId", required = false)Integer uId,@PathVariable("iId") int iId){
        int result = collectionService.isExistCollection(iId,uId);
        if (result==1)
            return ResultUtil.success();
        else
            return ResultUtil.error("不存在","1");
    }
}