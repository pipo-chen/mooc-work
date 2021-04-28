package com.study.model;

public class Order {
	private int id;
	private int order_id;

	public Order() {
	}

	public Order(int id, int order_id) {
		this.id = id;
		this.order_id = order_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
}
