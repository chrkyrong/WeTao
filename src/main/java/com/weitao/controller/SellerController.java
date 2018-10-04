package com.weitao.controller;

import com.weitao.bean.Seller;
import com.weitao.exception.ResultEnum;
import com.weitao.service.SellerService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

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
        int result = sellerService.login(seller);
        if(result==0) {
            httpSession.setAttribute("sId",seller.getsId());
            return ResultUtil.success();
        }else if (result==1){
            return ResultUtil.error(ResultEnum.USER_NOT_EXIST);
        }else if (result==2){
            return ResultUtil.error(ResultEnum.USER_LOCK);
        }else {
            return ResultUtil.error(ResultEnum.USER_PASSWROD_FAIL);
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
    public Result modifyInfo(@SessionAttribute(value = "sId", required = false)Integer sId,Seller seller) throws Exception{
        seller.setsId(sId);
        System.out.println(seller.getsPassword()+seller.getsIcon());
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
    public Result modifyPass(@SessionAttribute(value = "sId", required = false)Integer sId,Seller seller) throws Exception{
        seller.setsId(sId);
        int result = sellerService.modifySellerPassword(seller);
        if(result==0)
            return ResultUtil.success();
        else if (result==1)
            return ResultUtil.error(ResultEnum.USER_LOCK);
        else if (result == 2)
            return ResultUtil.error(ResultEnum.USER_PHONE_FAIL);
        else
            return ResultUtil.error(ResultEnum.USER_RSVISE_FAIL);
    }

    /**
     * 根据商家sId查找商家
     * @param sId
     * @return
     */
    @GetMapping("/seller/find")
    public Result find(@SessionAttribute(value = "sId", required = false)Integer sId){
        Seller seller = sellerService.findSellerBySid(sId);
        if (seller!=null)
            return ResultUtil.success(seller);
        return ResultUtil.error(ResultEnum.USER_GET_FAIL);
    }

    /**
     * 上传头像
     * @param Photos
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "uploadPhoto")
    public String uploadPhoto(MultipartFile Photos, HttpSession session) throws IOException {
        System.out.println("coming");
        Date date = new Date();
        Random random = new Random();
        String fileName = date.getYear() + "" + date.getMonth() + "" + date.getDate();
        fileName += random.nextInt()*10;
        fileName += ".jpg";
        String path = "D:\\workplace2018\\WeTao\\src\\main\\webapp\\static\\images\\seller\\";
        try {
            File file=new File(path,fileName);
            Photos.transferTo(file);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
