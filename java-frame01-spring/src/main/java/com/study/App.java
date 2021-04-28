package com.study;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.config.SpringApp;
import com.study.model.Order;
import com.study.service.OrderService;
import com.study.service.StaffService;
import com.study.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//期望当前容器去加载xml
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApp.class);

		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		List<Order> list= orderService.getOrder();
		for (Order order : list) {
			System.out.println("order_id:" + order.getOrder_id()+"id:"+order.getId());
		}

	}
}
