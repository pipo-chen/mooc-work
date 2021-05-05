package com.mmall.dao;

import com.mmall.pojo.Product;
import com.mmall.pojo.ProductExample;

public interface ProductMapper {
    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}