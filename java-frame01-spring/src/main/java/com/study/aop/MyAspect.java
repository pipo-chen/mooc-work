package com.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	long start = 0;
	//前置方法
	public void before() {
		System.out.println("执行之前先....");
		start = System.currentTimeMillis();
	}

	//后置方法
	public void after() {
		System.out.println("目标执行完毕....");
		long end = System.currentTimeMillis();
		System.out.println("当前执行时间:"+(end - start));
	}

	// 环绕方法
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("方法执行前");
		Object obj = pjp.proceed();
		System.out.println("方法执行后");
		return obj;
	}
}
