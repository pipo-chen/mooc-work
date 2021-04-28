package com.study.service.imp;

import com.study.dao.imp.UserDaoImp;
import com.study.service.StaffService;
import org.springframework.stereotype.Service;

@Service("staffService")
public class StaffServiceImp implements StaffService {
	public String save() {
		return "Staff 运行开始...";
	}

	public void setUserDao(UserDaoImp userDao) {
	}
}
