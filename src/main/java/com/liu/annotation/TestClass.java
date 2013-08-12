package com.liu.annotation;

public class TestClass {
	@Test
	private static void m1() {
		System.out.println("Test m1");
	}

	@Test
	public void m2() {

	}

	@ExceptionTest(value =
	{ RuntimeException.class, NullPointerException.class })
	public static void m3() {
		throw new RuntimeException("Test m3");
	}

	public void m5() {

	}
}
