package com.liu.concurrency;

/**
 * java ������������
 * @author ��ͩΰ
 * @date 2013��8��9��
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
