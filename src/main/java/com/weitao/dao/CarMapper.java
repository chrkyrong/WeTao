package com.weitao.dao;

import com.weitao.bean.Car;

public interface CarMapper {
    int insert(Car record);

    int insertSelective(Car record);
}