package com.liu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 
 * @see <a herf="http://oj.leetcode.com/problems/reverse-words-in-a-string">reverse-words-in-a-string</a>
 * @author ¡ıÕ©Œ∞
 * @date 2014-3-21
 */
public class ReverseWord {
	public static String reverseWords(String s) {
		List<String> words = new ArrayList<String>();
		StringBuilder word = new StringBuilder("");
		boolean isWord = true;
		char space = ' ';
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (isWord) {
				if (temp == space) {
					isWord = false;
					if (word.toString().equals("")) {
						continue;
					}
					words.add(word.toString());
					word.setLength(0);
				} else {
					word.append(temp);
				}
			} else {
				if (temp != space) {
					word.append(temp);
					isWord = true;
				}
			}
		}
		if (word.length() > 0) {
			words.add(word.toString());
		}
		if (words.size() == 0) {
			return "";
		}
		StringBuilder last = new StringBuilder();
		for (int i = words.size() - 1; i > 0; i--) {
			last.append(words.get(i)).append(space);
		}
		last.append(words.get(0));
		return last.toString();
	}

	public static String reverseWords2(String s) {
		if (s == null || s.trim().isEmpty())
			return "";
		Deque<String> deque = new ArrayDeque<String>();
		StringBuilder builder = new StringBuilder();
		boolean first = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				first = true;
				builder.append(c);
			} else {
				if (first) {
					deque.push(builder.toString());
					builder.setLength(0);
					first = false;
				}
			}
		}
		if (builder.length() > 0) {
			deque.push(builder.toString());
		}
		builder.setLength(0);
		while (!deque.isEmpty()) {
			builder.append(deque.pop()).append(" ");
		}
		return builder.toString().substring(0, builder.length() - 1);
	}

	public static void main(String[] args) {
		String s = " the sky blue ";
		String s1 = "    a    ";
		System.out.println(reverseWords2(s));
		System.out.println(reverseWords2(s1));
	}
}
