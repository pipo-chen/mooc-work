package com.study.model;

import org.springframework.beans.factory.annotation.Value;

public class User {

//	@Value("") 等价于 <property name = "age" value ="20"/>
	private String name;

	private int age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private static User user = null;
	public static User getInstance() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void init() {
		System.out.println("我在 User 中执行初始化方法");
	}
	public void destory() {
		System.out.println("我在 User 中执行销毁方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
