package com.study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.study")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy

public class SpringApp {
}
