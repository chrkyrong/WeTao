package com.weitao.service.serviceImpl;

import com.weitao.bean.Items;
import com.weitao.dao.DataMapper;
import com.weitao.vo.DataVo;
import com.weitao.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Items> selectSale(Integer sellerId){
        return dataMapper.selectBySeller(sellerId);
    }
}
