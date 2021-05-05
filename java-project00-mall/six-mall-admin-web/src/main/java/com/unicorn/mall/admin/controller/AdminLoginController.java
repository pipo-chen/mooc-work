package com.unicorn.mall.admin.controller;

import com.unicorn.mall.common.util.Result;
import com.unicorn.mall.common.util.ResultGenerator;
import com.unicorn.mall.user.entity.AdminUser;
import com.unicorn.mall.user.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController //所有方法的返回值， spring 都会转换成 web 格式
@RequestMapping("/admin")
@Api(tags = "处理用户登录的 controller")
public class AdminLoginController {

	@Autowired
	AdminUserService adminUserService;

	@ApiOperation(value = "用户登录接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "用户名",paramType = "query",required = true),
			@ApiImplicitParam(name = "password", value = "密码",paramType = "query",required = true),
			@ApiImplicitParam(name = "verifyCode", value = "验证码",paramType = "query",required = true,dataType = "String")}
	)
	@PostMapping(value = "/login")
	public Result login(@RequestParam("userName") String userName, @RequestParam("password") String password,
						@RequestParam("verifyCode") String verifyCode, HttpSession session) {

		//判空
		if (StringUtils.isEmpty(verifyCode) || StringUtils.isEmpty(password) || StringUtils.isEmpty(userName)) {
			return ResultGenerator.genFailResult("登录名、密码、验证码不能为空");

		}
		//查询
		AdminUser adminUser = adminUserService.login(userName, password);
		if (adminUser == null) {
			return ResultGenerator.genFailResult("登录失败");
		} else {
			//登录状态保存
			return ResultGenerator.genSuccessResult();
		}
	}
}
