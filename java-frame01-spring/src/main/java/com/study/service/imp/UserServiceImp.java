package com.study.service.imp;

import com.study.dao.UserDao;
import com.study.dao.imp.UserDaoImp;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service // 通常是写一些逻辑的，便于管理事务；Controller 层不去写业务逻辑 业务逻辑全部交给 service
public class UserServiceImp implements UserService {

	@Autowired //默认按类型装配
	//	通过名称进行装配
	//	@Qualifier("userDao")
	//	@Resource(name = "userDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public String save() {
		UserDao userDao = new UserDaoImp();
		userDao.save();
		return "";
	}

}
