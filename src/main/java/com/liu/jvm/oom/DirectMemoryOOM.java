package com.liu.jvm.oom;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM args: -Xmx20m -XX:MaxDirectMemorySize=10m
 * @author ��ͩΰ
 * @date 2014-1-19
 */
public class DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}
}
