package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

public interface IShippingService {

	public ServerResponse add(Integer userId, Shipping shipping);

	public ServerResponse delete(Integer userId, Integer shippingId);

	public ServerResponse update(Integer userId, Shipping shipping);

	public ServerResponse<Shipping> select(Integer userId, Integer shippingId);

	public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
