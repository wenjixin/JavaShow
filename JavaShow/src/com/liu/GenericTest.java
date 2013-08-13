package com.liu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * java 泛型(泛型不太好用)
 * 
 * @author 刘桐伟
 * @date 2013-8-10
 * @desc
 */
public class GenericTest {
	public static void GetList(List<Object> lists) {

	}

	/*
	 * public static void printList(List<Object> list) { for (Object elem :
	 * list) System.out.println(elem + " "); System.out.println(); }
	 */

	public static void printList(List<?> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Stack<Number> stack =new Stack<Number>();
		List<Object> list =new ArrayList<Object>();
		Integer c=new Integer(0);
		list.add(c);
		Integer a=new Integer(0);
		stack.push(a);
		Iterable<Integer> iterable =new Iterable<Integer>() {
			
			@Override
			public Iterator<Integer> iterator() {
				return null;
			}
		};
		stack.pushAll(iterable);
	}
}

class Stamp {

}

class Coin {

}

class Stack<E> {
	public Stack() {
	}

	public void push(E e) {
	}

	public E pop() {
		return null;
	}
	
	public boolean isEmpty(){
		return false;
	}
	public void pushAll(Iterable<? extends E> src){
		for (E e : src) {
			push(e);
		}
	}
	
	public void popAll(Collection<? super E> es){
		while(!isEmpty()){
			es.add(pop());
		}
	}
}