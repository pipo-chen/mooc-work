package com.unicorn.mall.user.mapper;

import com.unicorn.mall.user.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

//mybatis 和 spring 集成之后就可以了

public interface AdminUserMapper {
	/**
	 * 根据这两个条件去数据库中查询
	 * @param username
	 * @param password
	 * @return
	 */
	AdminUser login(@Param("username") String username,@Param("password") String password);

}
