package com.mmall.dao;

import com.mmall.pojo.Shopping;
import com.mmall.pojo.ShoppingExample;

public interface ShoppingMapper {
    int deleteByExample(ShoppingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
}