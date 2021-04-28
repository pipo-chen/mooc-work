package com.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
	long start = 0;
	//前置方法
	@Before("execution(* com.study..*.sa*(..))")
	public void before() {
		System.out.println("执行之前先....");
		start = System.currentTimeMillis();
	}


	@After("execution(* com.study..*.sa*(..))")
	public void after() {
		System.out.println("目标执行完毕....");
		long end = System.currentTimeMillis();
		System.out.println("当前执行时间:"+(end - start));
	}

	@Around("execution(* com.study..*.sa*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("方法执行前");
		Object obj = pjp.proceed();
		System.out.println("方法执行后");
		return obj;
	}
}
