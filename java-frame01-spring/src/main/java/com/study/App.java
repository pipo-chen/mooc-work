package com.study;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.config.SpringApp;
import com.study.service.StaffService;
import com.study.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class App {

	public static void main(String[] args) {

//		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//期望当前容器去加载xml
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApp.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.save();

	}
}
