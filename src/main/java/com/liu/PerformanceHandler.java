package com.liu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
	private Object target;

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerfMonitor.begin(target.getClass().getName() + ":" + method.getName());
		Object obj = method.invoke(target, args);
		PerfMonitor.stop();
		return obj;
	}

}
