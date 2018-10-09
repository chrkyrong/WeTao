package com.weitao.dao;

import com.weitao.bean.Items;
import com.weitao.vo.DataVo;

import java.util.List;

public interface DataMapper {
    //查找出对应ID的商家销售量前几的商品的商品名和销售量
    List<Items> selectBySeller(Integer sellerId);
}
