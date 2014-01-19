package com.liu.jvm.oom;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM args: -XX:PermSize=10m -XX:MaxPermsize=10m
 * @author ¡ıÕ©Œ∞
 * @date 2014-1-19
 */
public class JavaMethodAreaOOM {
	public static void main(String[] args) {
		try {
			while (true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMObject.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {

					public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
						// TODO Auto-generated method stub
						return arg3.invoke(arg0, arg2);
					}

				});
				enhancer.create();
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class OOMObject {
	}
}
