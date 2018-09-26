package com.weitao.service.serviceImpl;

import com.weitao.bean.Items;
import com.weitao.dao.ItemsMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.exception.UserException;
import com.weitao.service.ItemsService;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    /*插入商品*/
    @Override
    public boolean insertItems(Items items) throws Exception {
        ItemsVo itemsVo = new ItemsVo();
        //将items表的属性copy过来
        BeanUtils.copyProperties(items, itemsVo);
        itemsVo.setiSale(0);
        System.out.println(itemsVo.getiExsit() + "111");
        if (itemsVo.getiExsit() <= 0)/*如果库存大于0就物品的状态为0，否则为1*/
            throw new UserException(ResultEnum.ITEMS_EXSIT);
        else
            itemsVo.setiStatus((byte) 0);
        itemsVo.setiDate(new Date());
        System.out.println(itemsVo.getiName() + "====");
        int insert = itemsMapper.insert(itemsVo);
        if (insert == 1) { //插入成功返回的是1
            return true;
        }
        return false;
    }

    /*根据父类，子类，商品名查询，可按照价格销售量上架时间升序*/
    @Override
    public List<ItemsVo> selectItemsUp(String caFather, String iName, String caId, String type) throws Exception {
        ItemsVo itemsVo=new ItemsVo();
        System.out.println(caId+"===========");
        if(!caId.equals("")&&caId!= null){/*如果下拉框有值，则搜索框为空*/
            iName="";
            System.out.println("=========================");
        }
        return itemsMapper.selectItemsUp(caFather, iName, caId, type);
    }

    /*根据父类，子类，商品名查询，可按照价格销售量上架时间降序*/
    @Override
    public List<ItemsVo> selectItemsDown(String caFather, String iName, String caId, String type) throws Exception {
        System.out.println(caId+"===========");
        System.out.println(caFather+"========");
        System.out.println(iName+"======");
        if(!caId.equals("")&&caId!= null){
            iName="";
            System.out.println("=========================");
        }
        System.out.println(iName+"++++++");
        return itemsMapper.selectItemsDown(caFather,iName,caId,type);
    }

    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    @Override
    public List<ItemsVo> selectItemsAll(String search) {
        return itemsMapper.selectItemsAll(search);
    }
    /*商品页面展示，只显示销售量最高的九件商品 */
    @Override
    public List<Items> selectItems() {
        return itemsMapper.selectItems();
    }

    /*商品页面展示，只显示最新上架的最高的九件商品 */
    @Override
    public List<Items> selectItems1() {
        return itemsMapper.selectItems1();
    }

    /*显示商品信息*/
    @Override
    public List<Items> selectOneItems(Integer iId) {
        return itemsMapper.selectByPrimaryKey(iId);
    }

}