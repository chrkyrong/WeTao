package com.weitao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weitao.bean.Category;
import com.weitao.bean.Items;
import com.weitao.bean.Store;
import com.weitao.exception.ResultEnum;
import com.weitao.service.CategoryService;
import com.weitao.service.ItemsService;
import com.weitao.service.StoreService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ycp on 2018/9/5.
 */
@RestController
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private CategoryService categoryService;

    /*插入商品*/
    @RequestMapping(value = "/insertItems", method = RequestMethod.POST)
    public Result insertItems(Model model, HttpServletRequest request,
                              Items items, MultipartFile i_Photos) throws Exception {
            System.out.println(items.getiName()+"-----");
            System.out.println("ycp==="+i_Photos.getOriginalFilename());
            items.setiPhotos(i_Photos.getOriginalFilename());//获得图片的初始名字
            if (itemsService.insertItems(items))//返回值
                return ResultUtil.success();
            else
                return ResultUtil.error(ResultEnum.ITEMS_INSERT_FAIL);
        }

    /*下拉框显示卖家有多少店铺*/
    @RequestMapping(value = "/findStore")
    public List<Store> findStore(@SessionAttribute(value = "sId", required = false) int sellerId,
                                         @RequestParam(value = "stStatus", defaultValue = "0") int stStatus) {
        Store store=new Store();
        store.setSellerId(sellerId);
        store.setStStatus((byte) stStatus);
        List<Store> stores=storeService.seleteStore(store);
        /*Map<String, List<Store>> map = new HashMap<String, List<Store>>(); //不要传Object  //是这里的问题，应该返回店铺集合，不是一个一个放进去
        map.put("stores",stores);*/
        System.out.println("==数据长度；====="+stores.size()+"   数据;   "+stores);
        return  stores;
    }

    /*下拉框显示父类下有多少子类*/
    @RequestMapping(value = "findCafather")
    public List<Category> findCafather(HttpServletRequest request, String cafather){
        /*cafather=request.getParameter("cafather");*/
        System.out.println(cafather);
        List<Category> categories=categoryService.selectCafather(cafather);
     /*   System.out.println(categories);*/
        return categories;
    }

    /*加载图片*/
    @RequestMapping(value = "upFile")
    public String upFile(MultipartFile i_Photos, HttpSession session,HttpServletRequest request) throws IOException {
        System.out.println("==6==============6");
        /*如果上传的文件为文字名*/
        request.setCharacterEncoding("UTF-8");
        //获取上传的文件名
        String originalFilename = i_Photos.getOriginalFilename();
        /* 存储文件路径*/
        String path = "E:\\ideaa\\WeTao\\src\\main\\webapp\\static\\images\\";
        String root_path = session.getServletContext().getRealPath("images");// 获取自定义缓存文件夹路径
        File file=new File(root_path);
        /*如果文件夹不存在，则创建*/
        if(!file.exists()){
            file.mkdir();
        }
        /*构建图片url路径，显示图片需要*/
        String url_root=session.getServletContext().getContextPath();
        String file_url = url_root + "/static/images/" + originalFilename;

        System.out.println(file_url+"aaaaaaa");

        System.out.println(file_url+"ycp==============");
            /* 将图片写入 */
            try {
                File file1=new File(path,i_Photos.getOriginalFilename());
                i_Photos.transferTo(file1);
            }catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(originalFilename+"8888");
        return file_url;
    }
/*根据各种条件查询商品（条件默认为空，即查询所有商品）
* caFather:根据父类查询，caName:根据子类查询
* iName:根据商品名字查询：type:默认为以i_id升序
* */
    @RequestMapping(value = "queryItemsUp")
    public Result queryItemsUp(HttpServletRequest request,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date iDate,
                                    @RequestParam(value = "caFather", defaultValue = "") String caFather,
                                    @RequestParam(value = "iName", defaultValue = "")   String iName,
                                    @RequestParam(value = "caId", defaultValue = "")  String caId ,
                                    @RequestParam(value = "type", defaultValue = "i_id")  String type) throws Exception{
   System.out.println(iName+"sssssss");/*查询输入商品类型*/
    System.out.println(type);/*查詢判斷的類型*/
    System.out.println(caId+"aaaaaa");
    List<ItemsVo> itemsVos=itemsService.selectItemsUp(caFather,iName,caId,type);
  //  System.out.println(itemsVos+"/////");
    return ResultUtil.success(itemsVos);
    }

    /*根据各种条件查询商品（条件默认为空，即查询所有商品）
    * caFather:根据父类查询，caName:根据子类查询
    * iName:根据商品名字查询：type:默认为以i_id升序
    * */
    @RequestMapping(value = "queryItemsDown")
    public Result queryItemsDown(HttpServletRequest request,
                             @RequestParam(value = "caFather", defaultValue = "") String caFather,
                             @RequestParam(value = "iName", defaultValue = "")   String iName,
                             @RequestParam(value = "caId", defaultValue = "")  String caId ,
                             @RequestParam(value = "type", defaultValue = "i_id")  String type) throws Exception{
        System.out.println(iName+"sssssss");
        System.out.println(type);
        List<ItemsVo> itemsVos=itemsService.selectItemsDown(caFather,iName,caId,type);
        return ResultUtil.success(itemsVos);
    }

    /*
    * 主页面搜索框，输入值，可根据父类，子类，商品名模糊查询
    * */
    @RequestMapping(value = "queryItemsSearch")
    public Result queryItemsSearch(HttpServletRequest request,
                                @RequestParam(value = "search",defaultValue = "") String search){
        search=request.getParameter("search");
        System.out.println(search+"-------");
        List<ItemsVo> itemsVos=itemsService.selectItemsAll(search);
        System.out.println(itemsVos);
        return ResultUtil.success(itemsVos);
    }

    /*查找商品，即商品主页显示销售量最高的9件*/
    @RequestMapping(value = "queryItemsAll")
    public Result queryItemsAll(HttpServletRequest request){
        List<Items> items=itemsService.selectItems();
        return ResultUtil.success(items);
    }

    /*查找商品，即商品主页显示最新上架最高的9件*/
    @RequestMapping(value = "queryItemsAllDate")
    public Result queryItemsAllDate(HttpServletRequest request){
        List<Items> items=itemsService.selectItems1();
        return ResultUtil.success(items);
    }

    /*查找商品，即商品主页显示库存最多的五件商品*/
    @RequestMapping(value = "queryItemsAllExsit")
    public Result queryItemsAllExsit(HttpServletRequest request){
        List<Items> items=itemsService.selectItemsExsit();
        return ResultUtil.success(items);
    }
    /*
    * 查詢單個商品的数据，用于单个商品显示
    * */
    @RequestMapping(value = "queryOneItems")
    public Result queryOneItems(HttpServletRequest request, @RequestParam(value = "iId") Integer iId){
        System.out.println(iId+"hhhhh");
        System.out.println(itemsService.selectOneItems(iId));
        return  ResultUtil.success(itemsService.selectOneItems(iId));
    }

    /*根据店铺id查询商品*/
    @GetMapping(value = "selectAll")
    public Result selectAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value="storeId",defaultValue = "1") Integer storeId){
       /*一页显示多少条数据*/
        Integer pageSize=7;
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Items> pageInfo=new PageInfo<>(itemsService.selectAll(storeId));
        return ResultUtil.success(pageInfo);
    }
    /*卖家根据条件查询各店铺下的商品*/
    @RequestMapping(value = "sellerItems")
    public Result sellerItems(HttpServletRequest request,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "storeId",defaultValue = "1") Integer storeId,
                              @RequestParam(value="search") String search,@RequestParam(value = "iStatus",defaultValue = "0") Integer iStatus){

     /*   System.out.println(search+iStatus+"Sssss");*/
        Integer pageSize=7;
     /*   System.out.println(iStatus+"asdhaijskdhakd");*/
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Items> pageInfo=new PageInfo<>(itemsService.sellerItems(storeId,search,iStatus));
        return  ResultUtil.success(pageInfo);
    }


    /*根据商品id上下架产品*/
    @GetMapping(value = "/deleteItems/{iId}")
    public  Result deleteItems(@PathVariable("iId") int iId){

    int count=itemsService.deleteItems(iId);
    System.out.println(count+"---------------------------");
        if (count>0)//返回值
        {
            return ResultUtil.success();
        }
        else {
            return ResultUtil.error(ResultEnum.ITEMS_DELETE_FAIL);
        }
    }
/*修改商品*/
    @RequestMapping(value = "/saveItems", method = RequestMethod.POST)
    public Result saveItems(Model model, HttpServletRequest request,
                              Items items, MultipartFile i_Photos) throws Exception {
        System.out.println(items.getiId()+"-----");
        if (i_Photos.getOriginalFilename().equals("")){
            System.out.println(items.getiPhotos()+"ada");
            items.setiPhotos(items.getiPhotos());
        }
        else {
            items.setiPhotos(i_Photos.getOriginalFilename());//获得图片的初始名字
        }
        if (itemsService.updateItems(items)==1)//返回值
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ITEMS_INSERT_FAIL);
    }

}

