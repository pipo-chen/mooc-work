package com.study.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class KaneClass {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(KaneClass.class);
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("before..");
				Object result = methodProxy.invokeSuper(o, objects);
				System.out.println("after");
				return null;
			}
		});

		KaneClass kaneClass = (KaneClass)enhancer.create();
		kaneClass.test();
	}

	public void test() {
		System.out.println("test...");
	}

}
