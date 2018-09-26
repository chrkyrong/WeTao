package com.weitao.controller;

import com.weitao.bean.Evaluate;
import com.weitao.bean.Order;
import com.weitao.bean.Order_detail;
import com.weitao.dao.OrderMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.service.EvaluateService;
import com.weitao.service.Order_detailService;
import com.weitao.service.serviceImpl.EvaluateServiceImpl;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.EvaluateVo;
import com.weitao.vo.EvaluateVo2;
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
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    EvaluateService evaluateService;

    @Autowired
    Order_detailService order_detailService;

    //    添加评论
    @RequestMapping(value = "/insertEvaluate", method = RequestMethod.POST)
    public Result insertEvaluate(Model model, HttpServletRequest request, Evaluate evaluate, MultipartFile e_Photos) throws Exception {
//        获得图片初始的名字
        evaluate.setePhotos(e_Photos.getOriginalFilename());
//        获得页面中的订单id
        Integer orderId = Integer.parseInt(request.getParameter("order_id"));
        if (evaluateService.insertEvaluate(evaluate, orderId))
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.EVALUATE_FAIL);

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
            System.out.println("图片已经写入文件夹");
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

    //    前端传来itemsId，根据itemsId查询该商品的所有评论
    @GetMapping("/selectEvaluate")
    public Result selectEvaluate(HttpServletRequest request, Integer iId) throws Exception {
        System.out.println(iId);
        List<EvaluateVo> evaluateVoList = evaluateService.selectEvaluate(iId);
        if (evaluateVoList != null)
            return ResultUtil.success(evaluateVoList);
        else
            return ResultUtil.error(ResultEnum.EVALUATE_SELECT_FAIL);
    }

    //    前端传来sellerId，根据sellerId查询该商家所拥有状态为0的商店，查询出所有评论
    @GetMapping("/sellerEvaluation")
    public Result sellerEvaluation(HttpServletRequest request, Integer sellerId) throws Exception {
//        输出商家id
        System.out.println("sellerId" + sellerId);
        List<EvaluateVo2> evaluateVo2List = evaluateService.sellerEvaluation(sellerId);
        if (evaluateVo2List != null)
            return ResultUtil.success(evaluateVo2List);
        else {
            return ResultUtil.error(ResultEnum.EVALUATE_NOT_FOUND_EVALUATION);
        }
    }


    @RequestMapping(value = "/searchEvaluation", method = RequestMethod.POST)
    public Result searchEvaluation(Model model, HttpServletRequest request, String condition, String search, String date, String sellerId) throws Exception {
//        获得表单中的卖家id
        sellerId = request.getParameter("sellerId");
//        获得表单中的搜索框内容
        search = request.getParameter("search");
        System.out.println(search);
//        获得表单中的下拉框中的条件
        condition = request.getParameter("condition");
        System.out.println(condition);
//        获得表单中的时间查询条件
        date = request.getParameter("date");
        System.out.println(date);
//        返回查找的对象
        List<EvaluateVo2> evaluateVo2List = evaluateService.searchEvaluation(Integer.parseInt(sellerId), search, condition, date);
        for (EvaluateVo2 oo : evaluateVo2List) {
            System.out.println(oo);
        }

        if (evaluateVo2List != null)
            return ResultUtil.success(evaluateVo2List);
        else
            return ResultUtil.error(ResultEnum.EVALUATE_NOT_FOUND_EVALUATION);
    }

    @RequestMapping(value = "/formTest", method = RequestMethod.POST)
    public Result formTest(Model model, HttpServletRequest request, String search, String condition, String date, String sellerId) throws Exception {
        System.out.println(sellerId);
        sellerId = request.getParameter("sellerId");
        search = request.getParameter("search");
        condition = request.getParameter("condition");
        date = request.getParameter("date");
        List<EvaluateVo2> evaluateVo2List = evaluateService.searchEvaluation(Integer.parseInt(sellerId), condition, search, date);
        if (evaluateVo2List != null)
            return ResultUtil.success(evaluateVo2List);
        else
            return ResultUtil.error(ResultEnum.EVALUATE_NOT_FOUND_EVALUATION);
    }
}
