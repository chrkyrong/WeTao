package com.weitao.controller;

import com.weitao.exception.ResultEnum;
import com.weitao.service.StoreService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //    管理员根据条件模糊搜索查询店铺
    @RequestMapping("/researchStoreByCondition")
    public Result researchStoreByCondition(Model model, HttpServletRequest request, String research, String condition, Byte stStatus) throws Exception {
        research = request.getParameter("search");
        condition = request.getParameter("condition");
        stStatus = Byte.parseByte(request.getParameter("stStatus"));
        List<StoreVo> storeVoList = storeService.managerSeach(research, condition, stStatus);
        if (storeVoList != null)
            return ResultUtil.success(storeVoList);
        else
            return ResultUtil.error(ResultEnum.STORE_NOT_FOUND);
    }
}
