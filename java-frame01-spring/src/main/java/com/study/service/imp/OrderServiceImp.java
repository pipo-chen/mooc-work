package com.study.service.imp;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.model.Order;
import com.study.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImp implements OrderService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int saveOrder() {
		return jdbcTemplate.update("insert into t_order value (?,?)",9,900);
	}

	public int updateOrder() {
		return jdbcTemplate.update("update t_order set order_id=? where id= ?",8000,5);
	}

	public int delOrder() {
		return jdbcTemplate.update("delete from t_order where id = ?",1);
	}

	public List<Order> getOrder() {
		List<Order> rs = jdbcTemplate.query("select id, order_id from t_order", new BeanPropertyRowMapper<Order>(Order.class));
		return rs;
	}


}
