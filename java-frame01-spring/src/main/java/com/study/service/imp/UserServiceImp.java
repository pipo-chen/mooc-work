package com.study.service.imp;

import com.study.dao.UserDao;
import com.study.dao.imp.UserDaoImp;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	public String save() {
		UserDao userDao = new UserDaoImp();
		userDao.save();
		return "";
	}

}
