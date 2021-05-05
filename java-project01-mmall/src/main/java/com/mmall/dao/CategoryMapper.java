package com.mmall.dao;

import com.mmall.pojo.Category;
import com.mmall.pojo.CategoryExample;

public interface CategoryMapper {
    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}