package com.weitao.controller;

import com.weitao.bean.Evaluate;
import com.weitao.exception.ResultEnum;
import com.weitao.service.EvaluateService;
import com.weitao.service.serviceImpl.EvaluateServiceImpl;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.EvaluateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author:Cc
 * @Date:2018/9/17
 * @program: weitao
 * @description: ${description}
 * @create: 2018-09-17 19:32
 */
@RestController
public class EvaluateController {

    @Autowired
    EvaluateService evaluateService;

    //    添加评论
    @RequestMapping(value = "/insertEvaluate", method = RequestMethod.POST)
    public Result insertEvaluate(Model model, HttpServletRequest request, Evaluate evaluate, MultipartFile e_Photos) throws Exception {
//        获得图片初始的名字
        evaluate.setePhotos(e_Photos.getOriginalFilename());
        evaluate.setUserId(1000000);
        evaluate.setOrderId(3000002);
        evaluate.setStoreId(7000001);
        evaluate.setItemsId(8000003);
        if (evaluateService.insertEvaluate(evaluate)) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(ResultEnum.EVALUATE_FAIL);
        }
    }

    //    文件上传
    @RequestMapping(value = "upFile1")
    public String upFile1(MultipartFile e_Photos, HttpSession session) throws IOException {
        System.out.println("==0============0==");
        //获取上传的文件名
        String originalFilename = e_Photos.getOriginalFilename();
        /* 存储文件路径*/

        String path = "E:\\mavenProject\\WeTao\\src\\main\\webapp\\static\\images\\";
        String root_path = session.getServletContext().getRealPath("images");// 获取自定义缓存文件夹路径
        File file = new File(root_path);
        /*如果文件夹不存在，则创建*/
        if (!file.exists()) {
            file.mkdir();
        }
        /*构建图片url路径，显示图片需要*/
        String url_root = session.getServletContext().getContextPath();

        String file_url = url_root + "/images/" + originalFilename;
        System.out.println(file_url + "======");
            /* 将图片写入 */
        try {
            System.out.println("2322");
            File file1 = new File(path, e_Photos.getOriginalFilename());
            e_Photos.transferTo(file1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(originalFilename + "666");
        return file_url;
    }

    @GetMapping("/selectEvaluate/{iId}")
    public Result selectEvaluate(HttpServletRequest request, @PathVariable("iId")Integer iId) throws Exception {
        System.out.println(iId);
        List<EvaluateVo> evaluateVoList = evaluateService.selectEvaluate(iId);
        if (evaluateVoList != null)
            return ResultUtil.success(evaluateVoList);
        else
            return ResultUtil.error(ResultEnum.EVALUATE_SELECT_FAIL);
    }
}
