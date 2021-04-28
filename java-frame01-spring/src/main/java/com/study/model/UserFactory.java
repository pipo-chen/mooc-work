package com.study.model;

public class UserFactory {

	private static User user = new User();

	public User createUser() {
		return user;
	}
}
