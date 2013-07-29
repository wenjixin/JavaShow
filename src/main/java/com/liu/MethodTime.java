package com.liu;

public class MethodTime {
	private long start;
	private long end;
	private String serviceName;

	public MethodTime(String serviceName) {
		this.serviceName = serviceName;
		this.start = System.currentTimeMillis();
	}

	public void printPerformance() {
		this.end = System.currentTimeMillis();
		System.out.println(serviceName + " cost " + (end - start) + "ms");
	}
}
