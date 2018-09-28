package com.weitao.controller;

import com.weitao.bean.Order_detail;
import com.weitao.exception.ResultEnum;
import com.weitao.service.Order_detailService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lzr on 2018/9/15.
 */
@RestController
public class Order_detailController {

    @Autowired
    private Order_detailService order_detailService;

    /**
     * 根据订单id查询订单详情关联查询商品信息
     * @param oId
     * @return
     */
    @GetMapping("/detail/orderId")
    public Result getByOrderId(int oId)
    {
        List<Order_detail> order_detail=order_detailService.getOrderDetail(oId);
        if(order_detail!=null)
            return ResultUtil.success(order_detail);
        else
            return ResultUtil.error(ResultEnum.DETAIL_USER_FAIL);
    }
}
