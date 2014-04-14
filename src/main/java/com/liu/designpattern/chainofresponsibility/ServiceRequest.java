package com.liu.designpattern.chainofresponsibility;

public class ServiceRequest {
	private ServiceLevel level;

	public ServiceRequest(ServiceLevel level) {
		this.level = level;
	}

	public ServiceRequest setLevel(ServiceLevel level) {
		this.level = level;
		return this;
	}

	public ServiceLevel getLevel() {
		return level;
	}
}
