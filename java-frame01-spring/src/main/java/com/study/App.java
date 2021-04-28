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

		/**
		 * 现在的方式
		 * 1. 加载 xml 文件
		 * 2. 解析 bean
		 * 3. 通过反射 去获取 object
		 * 4. 容器里面存储 getBean() 可以获取定义的对象实例
		 * 5. 放入准备好的 hashmap 中
		 */
//		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//期望当前容器去加载xml
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApp.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		StaffService staffService = (StaffService) applicationContext.getBean("staffService");
		userService.save();
		staffService.save();
		DruidDataSource dataSource = (DruidDataSource)applicationContext.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
