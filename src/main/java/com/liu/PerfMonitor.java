package com.liu;

public class PerfMonitor {
	private static ThreadLocal<MethodTime> local = new ThreadLocal<MethodTime>();

	public static void begin(String serviceName) {
		System.out.println("begin PerfMonitor");
		MethodTime methodTime = new MethodTime(serviceName);
		local.set(methodTime);
	}

	public static void stop() {
		System.out.println("stop PerfMonitor");
		MethodTime methodTime = local.get();
		methodTime.printPerformance();
	}
}
