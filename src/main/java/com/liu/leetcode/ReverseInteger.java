package com.liu.leetcode;

public class ReverseInteger {
	public static int reverse(int x) {
		int reverseNum = 0;
		while (x != 0) {
			reverseNum = reverseNum * 10 + x % 10;
			x = x / 10;
		}
		return reverseNum;
	}

	public static void main(String[] args) {
		System.out.println(reverse(0));
		System.out.println(reverse(1000000003));
	}
}
