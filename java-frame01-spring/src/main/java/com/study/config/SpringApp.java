package com.study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.study")
@PropertySource("classpath:jdbc.properties")

//替换掉 <context:component-scan base-package="com.study"/>

public class SpringApp {
}
