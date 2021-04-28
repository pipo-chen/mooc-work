package com.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceBySpring {

	@Value("${jdbc.driver}")
	String driverName;

	@Value("${jdbc.url}")
	String url;

	@Value("${jdbc.username}")
	String username;

	@Value("${jdbc.password}")
	String password;

	@Bean
	public DruidDataSource dataSource () {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
