package com.liu;

/**
 * cpu���������Ч�ʵ�Ӱ��
 * @author ��ͩΰ
 * @date 2013��7��30��
 */
public class CpuCache {
	public static void main(String[] args) {
		loopCounts();
	}

	/**
	 * loopѭ��ִ��ʱ�䳤����������ڴ���ʴ��������ģ������������ĳ˷����������
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
