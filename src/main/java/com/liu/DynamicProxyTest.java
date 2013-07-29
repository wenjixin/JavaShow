package com.liu;

import java.io.Serializable;
import java.lang.reflect.Proxy;

/**
 * java动态代理的应用
 * @author 刘桐伟
 * @date 2013年7月29日
 */
public class DynamicProxyTest implements Serializable {

	private static final long serialVersionUID = 1739736988248917158L;

	public static void main(String[] args) {
		UserSomething something = new UserSomethingImpl();
		PerformanceHandler handler = new PerformanceHandler(something);
		UserSomething proxyUserSomething = (UserSomething) Proxy.newProxyInstance(
		        something.getClass().getClassLoader(), something.getClass()
		                .getInterfaces(),
		        handler);
		proxyUserSomething.doTask1();
		proxyUserSomething.doTask2();

		CglibProxy cglibProxy = new CglibProxy();
		UserSomethingImpl impl = (UserSomethingImpl) cglibProxy.getProxy(UserSomethingImpl.class);
		impl.doTask1();
		impl.doTask2();
	}
}
