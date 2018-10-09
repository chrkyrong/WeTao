package com.weitao.controller;

import com.weitao.bean.User;
import com.weitao.exception.ResultEnum;
import com.weitao.service.UserService;
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
 * Created by lzr on 2018/9/11.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user")
    public Result add (User user) throws Exception {
        User user1=userService.register(user);

        if(user1!=null)
            return ResultUtil.success(user1);
        else
            return ResultUtil.error(ResultEnum.USER_REGISTER_FAIL);
    }

    /**
     * 用户登陆
     * @param httpSession
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user/login")
    public Result result(HttpSession httpSession,User user) throws Exception{
        if(userService.login(user)) {
            //保存用户信息
            httpSession.setAttribute("uId",user.getuId());
            return ResultUtil.success();
            //重定向到主页界面
        }
        else
            return ResultUtil.error(ResultEnum.USER_LOGIN_FAIL);
    }

    /**
     * 用户退出
     * @param httpSession
     */
    @GetMapping("/user/logout")
    public void logout(HttpSession httpSession)
    {
        httpSession.invalidate();
        //重定向到主页界面
    }

    /**
     * 查询用户信息
     * @param uId
     * @return
     */
    @GetMapping("/user")
    public Result get(@SessionAttribute("uId") Integer uId)
    {
       User user=userService.look(uId);
       if(user!=null)
           return ResultUtil.success(user);
       else
           return ResultUtil.error(ResultEnum.USER_GET_FAIL);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/user")
    public Result put(User user)
    {
        if(userService.revise(user))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USER_RSVISE_FAIL);
    }

    /**
     * 找回用户密码
     * @param user
     * @return
     */
    @PutMapping("/user/password")
    public Result putPassword(User user)
    {
        if(userService.revisePassword(user))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.USER_REVISE_PASSWROD_FAIL);
    }
    /*加载图片*/
    @RequestMapping(value = "upFile1")
    public String upFile1(MultipartFile photo) throws IOException {
        Date date = new Date();
        Random random = new Random();
        String fileName = date.getYear() + "" + date.getMonth() + "" + date.getDate();
        fileName += random.nextInt()*10;
        fileName += ".jpg";
        String path = "D:\\WeTao\\src\\main\\webapp\\static\\images\\user\\";
        try {
            System.out.println("sadasdasdasdasdasda");
            File file=new File(path,fileName);
            System.out.println("=====================================");
            /**/
            photo.transferTo(file);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
