package com.unicorn.mall.user.service;

import com.unicorn.mall.user.entity.AdminUser;


public interface AdminUserService {
	/**
	 * 登录数据层面校验
	 * @param userName 登录名
	 * @param password 密码
	 * @return 该用户信息 如果登录错误，返回空
	 */
	public AdminUser login(String userName, String password);
}
