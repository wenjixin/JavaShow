package com.liu.leetcode;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		if (n <= 1) {
			return 1;
		}
		return num(1, n);
	}

	public static int num(int start, int end) {
		if (start >= end) {
			return 1;
		}
		int num = 0;
		for (int i = start; i <= end; i++) {
			num = num + num(start, i - 1) * num(i + 1, end);
		}
		return num;
	}

	public static int numTreesNooRecursion(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(3));
		System.out.println(numTrees(10));
		System.out.println(numTreesNooRecursion(1));
		System.out.println(numTreesNooRecursion(3));
		System.out.println(numTreesNooRecursion(10));
	}
}
