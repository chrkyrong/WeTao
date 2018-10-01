package com.weitao.controller;

import com.weitao.bean.Seller;
import com.weitao.exception.ResultEnum;
import com.weitao.service.SellerService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: hzb
 * @Description: WeTao1
 * @Version: 1.0
 * @Date: 2018/9/30
 * @Time: 15:22
 **/
@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    /**
     * 商家登录
     * @param httpSession
     * @param seller
     * @return
     * @throws Exception
     */
    @PostMapping("/seller/login")
    public Result login(HttpSession httpSession, Seller seller) throws Exception{
        if(sellerService.login(seller)) {
            httpSession.setAttribute("sId",seller.getsId());
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.USER_LOGIN_FAIL);
        }
    }

    /**
     * 商家注册
     * @param seller
     * @return
     * @throws Exception
     */
    @PostMapping("/seller/register")
    public Result register(Seller seller) throws Exception{
        System.out.println(seller);
        if (sellerService.register(seller)!=null)
            return ResultUtil.success(seller);
        return ResultUtil.error(ResultEnum.USER_REGISTER_FAIL);
    }

    /**
     * 退出登录
     * @param httpSession
     */
    @GetMapping("/seller/logout")
    public void logout(HttpSession httpSession){
        httpSession.invalidate();
    }

    /**
     * 修改商家的个人信息
     * @param seller
     * @return
     * @throws Exception
     */
    @PostMapping("/seller/modify/info")
    public Result modifyInfo(Seller seller) throws Exception{
        if(sellerService.modifySeller(seller))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USER_RSVISE_FAIL);
    }

    /**
     * 修改商家的登录密码
     * @param seller
     * @return
     * @throws Exception
     */
    @PostMapping("/seller/modify/pass")
    public Result modifyPass(Seller seller) throws Exception{
        if(sellerService.modifySellerPassword(seller))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USER_RSVISE_FAIL);
    }

    /**
     * 根据商家sId查找商家
     * @param sId
     * @return
     */
    @GetMapping("/seller/find/{sId}")
    public Result find(@PathVariable("sId")Integer sId){
        Seller seller = sellerService.findSellerBySid(sId);
        if (seller!=null)
            return ResultUtil.success(seller);
        return ResultUtil.error(ResultEnum.USER_GET_FAIL);
    }
}
