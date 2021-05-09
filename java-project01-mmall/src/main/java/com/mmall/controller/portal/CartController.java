package com.mmall.controller.portal;


import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Autowired
	private ICartService iCartService;

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse list(HttpSession session) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.list(user.getId());
	}

	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse add(HttpSession session, Integer count, Integer productId) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.add(user.getId(), productId, count);
	}

	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse update(HttpSession session, Integer count, Integer productId) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.update(user.getId(), productId, count);
	}

	@RequestMapping(value = "delete_product.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse deleteProduct(HttpSession session, String productIds) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.deleteProduct(user.getId(), productIds);
	}

	//全选
	@RequestMapping(value = "select_all.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse selectAll(HttpSession session) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnselectAll(user.getId(), Const.Cart.CHECKED);
	}
	//全反选
	@RequestMapping(value = "un_select_all.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse unSelectAll(HttpSession session) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnselectAll(user.getId(), Const.Cart.UN_CHECKED);
	}

	//单独选
	@RequestMapping(value = "select_product.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse selectProduct(HttpSession session, Integer productId) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnselectProduct(user.getId(), Const.Cart.CHECKED, productId);
	}

	//单独反选
	@RequestMapping(value = "un_select_product.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse unSelectProduct(HttpSession session, Integer productId) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnselectProduct(user.getId(), Const.Cart.UN_CHECKED, productId);
	}

	//查询当前用户的购物车中的产品数量，如果一个产品有 10 个 那么数量就是 10
	@RequestMapping(value = "get_cart_product_count.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Integer> getCartProductCount(HttpSession session) {
		User user = (User)session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.getCartProductCount(user.getId());
	}

}
