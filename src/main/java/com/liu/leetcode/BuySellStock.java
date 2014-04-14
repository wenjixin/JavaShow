package com.liu.leetcode;

public class BuySellStock {
	public static int maxProfit(int[] prices) {
		if (prices.length <= 0) {
			return 0;
		}
		int lowestPrice = prices[0];
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = (prices[i] - lowestPrice) > maxProfit ? (prices[i] - lowestPrice) : maxProfit;
			lowestPrice = prices[i] < lowestPrice ? prices[i] : lowestPrice;
		}
		if (maxProfit < 0) {
			maxProfit = 0;
		}
		return maxProfit;
	}

	public static int maxProfitII(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		final int length = prices.length;
		int i = 0;
		int maxProfit = 0;
		while (i < length - 1) {
			int buy, sell;
			while (i + 1 <= length - 1 && prices[i + 1] <= prices[i]) {
				i++;
			}
			buy = i;
			while (i + 1 <= length - 1 && prices[i + 1] > prices[i]) {
				i++;
			}
			sell = i;
			maxProfit += prices[sell] - prices[buy];
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfitII(new int[] {}));
		System.out.println(maxProfitII(new int[] { 1, 2 ,100,10,2,100}));
		System.out.println(maxProfitII(new int[] { 1, 1, 1, 1, 1 }));
	}
}
