package com.mmall.dao;

import com.mmall.pojo.PayInfo;
import com.mmall.pojo.PayInfoExample;

public interface PayInfoMapper {
    int deleteByExample(PayInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);
}