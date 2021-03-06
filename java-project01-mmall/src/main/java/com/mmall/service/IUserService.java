package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import net.sf.jsqlparser.schema.Server;

public interface IUserService {

	ServerResponse<User> login(String username, String password);

	ServerResponse<String> register(User user);

	ServerResponse<String> checkVaild(String str, String type);

	ServerResponse selectQuestion(String username);

	ServerResponse<String> checkAnswer(String username, String question, String answer);

	ServerResponse<String> forgetResetPassword(String username, String password, String forgetToken);

	ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

	ServerResponse<User> updateInformation(User user);

	ServerResponse<User> getInformation(Integer userId);

	//backend
	ServerResponse checkAdminRole(User user);
}
