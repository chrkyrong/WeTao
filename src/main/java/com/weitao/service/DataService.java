package com.weitao.service;

import com.weitao.bean.Items;
import com.weitao.vo.DataVo;

import java.util.List;

public interface DataService {
    List<Items> selectSale(Integer sellerId);
}
