package com.mmall.dao;

import com.mmall.pojo.Cart;
import com.mmall.pojo.CartExample;

public interface CartMapper {
    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}