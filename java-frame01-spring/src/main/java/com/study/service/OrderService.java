package com.study.service;

import com.study.model.Order;

import java.util.List;

public interface OrderService {

	public int saveOrder();

	public int updateOrder();

	public int delOrder();

	public List<Order> getOrder();



}
