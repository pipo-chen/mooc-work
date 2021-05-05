package com.mmall.dao;

import com.mmall.pojo.Order;
import com.mmall.pojo.OrderExample;

public interface OrderMapper {
    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}