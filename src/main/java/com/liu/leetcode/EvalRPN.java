package com.liu.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {

	public static int evalRPN(String[] tokens) {
		int result = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				result = deque.pop() + deque.pop();
				deque.push(result);
			} else if (tokens[i].equals("-")) {
				result = -deque.pop() + deque.pop();
				deque.push(result);
			} else if (tokens[i].equals("*")) {
				result = deque.pop() * deque.pop();
				deque.push(result);
			} else if (tokens[i].equals("/")) {
				int a = deque.pop();
				int b = deque.pop();
				result = b / a;
				deque.push(result);
			} else {
				deque.push(Integer.valueOf(tokens[i]));
			}
		}
		if (!deque.isEmpty()) {
			result = deque.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] { "4" }));
		System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
	}
}
