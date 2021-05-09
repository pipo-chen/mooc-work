package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

public interface IProductService {

	public ServerResponse saveOrUpdateProduct(Product product);

	public ServerResponse<String> setSaleStatus(Integer productId, Integer status);

	public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

	public ServerResponse getProductList(int pageNum, int pageSize);

	public ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

	//前端
	public ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

	public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize,String orderBy);
}
