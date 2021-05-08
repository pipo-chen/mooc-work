package com.mmall.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Category;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import com.mmall.util.DateTimeUtil;
import com.mmall.util.PropertiesUtil;
import com.mmall.vo.ProductDetailVo;
import com.mmall.vo.ProductListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iProductService")
public class ProductServiceImp implements IProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public ServerResponse saveOrUpdateProduct(Product product) {
		if (product != null) {
			if (StringUtils.isNotBlank(product.getSubImages())) {
				String[] subImageArray = product.getSubImages().split(",");
				if (subImageArray.length > 0) {
					product.setMainImage(subImageArray[0]);
				}
			}
			if (product.getId() != null) {
				int rowCount = productMapper.updateByPrimaryKey(product);
				if (rowCount > 0)
					return ServerResponse.createBySuccess("更新成功");
				else
					return ServerResponse.createByErrorMessage("更新失败");
			} else {
				int rowCount = productMapper.insert(product);
				if (rowCount > 0)
					return ServerResponse.createBySuccess("新增成功");
				else
					return ServerResponse.createByErrorMessage("新增失败");
			}
		}
		return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
	}

	@Override
	public ServerResponse<String> setSaleStatus(Integer productId, Integer status) {
		if (productId == null || status == null) {
			return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), "参数错误");
		}
		Product product = new Product();
		product.setId(productId);
		product.setStatus(status);
		int rowCount = productMapper.updateByPrimaryKeySelective(product);
		if (rowCount > 0)
			return ServerResponse.createBySuccess("修改产品销售状态成功");
		return ServerResponse.createByErrorMessage("修改产品销售状态失败");
	}

	@Override
	public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId) {
		if (productId == null)
			return ServerResponse.createByError(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		Product product = productMapper.selectByPrimaryKey(productId);
		if (product == null)
			return ServerResponse.createByErrorMessage("产品已下架或者删除");
		//VO 对象 - value object
		//复杂：pojo -bo(business object) - vo(view object)

		ProductDetailVo productDetailVo = assembleProductDetailVo(product);
		return ServerResponse.createBySuccess(productDetailVo);
	}

	private ProductDetailVo assembleProductDetailVo(Product product) {
		ProductDetailVo productDetailVo = new ProductDetailVo();
		productDetailVo.setId(product.getId());
		productDetailVo.setSubtitle(product.getSubtitle());
		productDetailVo.setPrice(product.getPrice());
		productDetailVo.setMainImage(product.getMainImage());
		productDetailVo.setSubImages(product.getSubImages());
		productDetailVo.setCategoryId(product.getCategoryId());
		productDetailVo.setDetail(product.getDetail());
		productDetailVo.setName(product.getName());
		productDetailVo.setStatus(product.getStatus());
		productDetailVo.setStock(product.getStock());

		//imageHost
		productDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.mmall.com/"));
		//parentCategoryId
		Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
		if (category == null) {
			productDetailVo.setParentCategoryId(0);
		} else {
			productDetailVo.setParentCategoryId(category.getParentId());
		}
		//createTime
		productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
		//updateTime
		productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));

		return productDetailVo;
	}

	@Override
	public ServerResponse getProductList(int pageNum, int pageSize) {
		//startPage - start
		//填充自己的 sql 查询逻辑
		//page
		PageHelper.startPage(pageNum, pageSize);
		List<Product> productList = productMapper.selectList();
		List<ProductListVo> productListVoList = Lists.newArrayList();

		for(Product productItem: productList) {
			ProductListVo productListVo = assembleProductListVo(productItem);
			productListVoList.add(productListVo);
		}
		PageInfo pageResult = new PageInfo(productList);

		pageResult.setList(productListVoList);
		return ServerResponse.createBySuccess(pageResult);
	}

	private ProductListVo assembleProductListVo(Product product) {
		ProductListVo productListVo = new ProductListVo();
		productListVo.setId(product.getId());
		productListVo.setName(product.getName());
		productListVo.setCategoryId(product.getCategoryId());
		productListVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.mmall.com"));
		productListVo.setMainImage(product.getMainImage());
		productListVo.setPrice(product.getPrice());
		productListVo.setSubtitle(product.getSubtitle());
		productListVo.setStatus(product.getStatus());
		return productListVo;
	}

	@Override
	public ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (StringUtils.isNotBlank(productName)) {
			productName = new StringBuilder().append("%").append(productName).append("%").toString();
		}
		List<Product> productList = productMapper.selectByNameAndProductId(productName, productId);
		List<ProductListVo> productListVoList = Lists.newArrayList();

		for(Product productItem: productList) {
			ProductListVo productListVo = assembleProductListVo(productItem);
			productListVoList.add(productListVo);
		}
		PageInfo pageResult = new PageInfo(productList);
		pageResult.setList(productListVoList);
		return ServerResponse.createBySuccess(pageResult);
	}
}
