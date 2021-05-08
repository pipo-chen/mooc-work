package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;
import net.sf.jsqlparser.schema.Server;

import java.util.List;

public interface ICategoryService {
	ServerResponse addCategory(String categoryName, Integer parentId);

	ServerResponse updateCategoryName(Integer categoryId, String categoryName);

	ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

	ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}