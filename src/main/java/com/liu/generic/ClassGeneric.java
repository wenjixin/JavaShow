package com.liu.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Class 的泛型
 * @author 刘桐伟
 * @date 2013年8月12日
 */
public class ClassGeneric {
	private final Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		map.put(type, instance);
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(map.get(type));
	}

	static Annotation getAnnotation(AnnotatedElement annotatedElement, String annotationTypeName) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return annotatedElement.getAnnotation(annotationType.asSubclass(Annotation.class));
	}

	public static void main(String[] args) {
		ClassGeneric classGeneric = new ClassGeneric();
		// HashMap hashMap = new HashMap();
		HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
		classGeneric.putFavorite(HashMap.class, hashMap2);
		// HashMap<Integer,Integer>.class is a syntax error
		// classGeneric.putFavorite(HashMap<Integer,Integer>.class, hashMap);
	}
}
