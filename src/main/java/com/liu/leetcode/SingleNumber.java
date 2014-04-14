package com.liu.leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new SingleNumber().singleNumber(new int[] { 1 }));
	}
}
