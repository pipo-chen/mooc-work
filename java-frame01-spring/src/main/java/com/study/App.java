package com.study;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.model.User;
import com.study.service.StaffService;
import com.study.service.UserService;
import com.study.service.imp.UserServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.ConnectionPoolDataSource;

public class App {

	public static void main(String[] args) {
		/**
		 * 原先方式
		 * UserService user = new UserServiceImp();
		 * user.save();
		 */

		/**
		 * 现在的方式
		 * 1. 加载 xml 文件
		 * 2. 解析 bean
		 * 3. 通过反射 去获取 object
		 * 4. 容器里面存储 getBean() 可以获取定义的对象实例
		 * 5. 放入准备好的 hashmap 中
		 */
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//期望当前容器去加载xml
		UserService userService = (UserService) applicationContext.getBean("userService");
		StaffService staffService = (StaffService) applicationContext.getBean("staffService");
		userService.save();
		staffService.save();

		/**
		 * 原型对象和单例对象的创建次数区别
		 */
		System.out.println(applicationContext.getBean("userService"));
		System.out.println(applicationContext.getBean("userService"));
		System.out.println(applicationContext.getBean("userService"));
		System.out.println(applicationContext.getBean("staffService"));
		System.out.println(applicationContext.getBean("staffService"));
		System.out.println(applicationContext.getBean("staffService"));

		/**
		 * 有参数的情况 & 生命周期默认调用函数
		 */
		User user = (User)applicationContext.getBean("user");
		System.out.println("当前对象的 age:"+user.getAge()+" name:"+user.getName());
		applicationContext.close();

		/**
		 * 获取数据库链接
		 * ConnectionPoolDataSource dataSource = (ConnectionPoolDataSource) applicationContext.getBean("dataSource");
		 *
		 */

		ComboPooledDataSource dataSource = (ComboPooledDataSource) applicationContext.getBean("dataSource");
		System.out.println(dataSource);

	}
}
