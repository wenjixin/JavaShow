package com.liu.generic;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class 的泛型
 * 
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

	static Annotation getAnnotation(AnnotatedElement annotatedElement,
			String annotationTypeName) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return annotatedElement.getAnnotation(annotationType
				.asSubclass(Annotation.class));
	}

	public static void main(String[] args) {
		ClassGeneric classGeneric = new ClassGeneric();
		// HashMap hashMap = new HashMap();
		HashMap<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
		classGeneric.putFavorite(HashMap.class, hashMap2);
		// HashMap<Integer,Integer>.class is a syntax error
		// classGeneric.putFavorite(HashMap<Integer,Integer>.class, hashMap);
		CollectionA<Number> collectionA = new CollectionA<Number>();
		collectionA.push(new Integer(0));
		Iterable<Integer> iterable = new Iterable<Integer>() {

			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		collectionA.pushAll(iterable);
		Object a = collectionA.pop();
		Collection<Object> collection = new Collection<Object>() {

			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			public Iterator<Object> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean add(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean addAll(Collection<? extends Object> c) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			public void clear() {
				// TODO Auto-generated method stub

			}
		};

		collectionA.popAll(collection);
	}

}

class CollectionA<E> {
	public void push(E e) {

	}

	public E pop() {
		return null;
	}

	public boolean isEmpty() {
		return true;
	}

	public void pushAll(Iterable<? extends E> src) {
		for (E e : src) {
			push(e);
		}
	}

	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
}
