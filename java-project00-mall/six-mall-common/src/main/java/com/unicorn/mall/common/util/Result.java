package com.unicorn.mall.common.util;

import java.io.Serializable;

/**
 * 这个类就是后端接口返回数据的格式
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int resultCode; //200 - normal 500 - exception
	private String message; // info
	private T data; // other data

	public Result() {
	}

	public Result(int resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
