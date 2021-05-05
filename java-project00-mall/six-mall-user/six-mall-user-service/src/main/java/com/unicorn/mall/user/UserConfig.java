package com.unicorn.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//此类存放实现 User 模块，相关的依赖配置
@Configuration
@MapperScan("com.unicorn.mall.user.mapper")
public class UserConfig {

}
