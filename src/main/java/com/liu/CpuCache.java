package com.liu;

/**
 * cpu缓存对运行效率的影响
 * @author 刘桐伟
 * @date 2013年7月30日
 */
public class CpuCache {
	public static void main(String[] args) {
		loopCounts();
	}

	/**
	 * loop循环执行时间长短由数组的内存访问次数决定的，而非整型数的乘法运算次数。
	 */
	public static void loopCounts() {
		int processors = Runtime.getRuntime().availableProcessors();
		int[] arr = new int[64 * 1024 * 1024];
		System.out.println("processors:" + processors + " freeMemory:" + Runtime.getRuntime().freeMemory()
		        + " totalMemory:" + Runtime.getRuntime().totalMemory());
		PerfMonitor.begin("loop1");
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 3;
		}
		PerfMonitor.stop();
		PerfMonitor.begin("loop2");
		for (int i = 0; i < arr.length; i += 16) {
			arr[i] *= 3;
		}
		PerfMonitor.stop();
	}
}
