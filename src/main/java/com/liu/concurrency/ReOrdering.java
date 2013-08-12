package com.liu.concurrency;

/**
 * java 的重排序现象
 * @author 刘桐伟
 * @date 2013年8月9日
 */
public class ReOrdering {
	private static boolean start;
	private static int num;

	private static class DoSomething extends Thread {
		@Override
		public void run() {
			while (!start) {
				Thread.yield();
			}
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		// while (true) {
		new DoSomething().start();
		start = true;
		// num = 1000;
		// start = false;
	}
}
