package com.liu.annotation;

import java.lang.reflect.Method;

/**
 * 运行@Test注解的测试的工具类
 * @author 刘桐伟
 * @date 2013年8月12日
 */
public class RunTest {
	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class) || m.isAnnotationPresent(ExceptionTest.class)) {
				m.setAccessible(true);
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (Throwable e) {
					Throwable obj = e.getCause();
					if (m.getAnnotation(ExceptionTest.class) != null) {
						Class<? extends Exception>[] classes = m.getAnnotation(ExceptionTest.class).value();
						for (Class<? extends Exception> class1 : classes) {
							if (class1.isInstance(obj)) {
								System.out.println("ErrorTest success. "+obj);
								break;
							}
						}
					}
				}
			}
		}
		System.out.format("Test run info: passed %d , failure %d", passed, tests - passed);
	}
}
