package com.study.dao.imp;

import com.study.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {
	public void save() {
		System.out.println("UserDao 正在运行...");
	}
}
