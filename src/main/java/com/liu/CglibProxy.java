package com.liu;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class claszz) {
		enhancer.setSuperclass(claszz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		PerfMonitor.begin(arg0.getClass().getName() + ":" + arg1.getName());
		Object obj = arg3.invokeSuper(arg0, arg2);
		PerfMonitor.stop();
		return obj;
	}

}
