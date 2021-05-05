package com.unicorn.mall.user.service.imp;
import com.unicorn.mall.user.entity.AdminUser;
import com.unicorn.mall.user.mapper.AdminUserMapper;
import com.unicorn.mall.user.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class AdminUserServiceImp implements AdminUserService {

//	@Autowired(required = false)
//	AdminUserMapper adminUserMapper;

	@Override
	public AdminUser login(String userName, String password) {
		return null;//adminUserMapper.login(userName, password);
	}
}
