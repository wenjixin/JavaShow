package com.liu.designpattern.chainofresponsibility;

public class Client {
	public static void main(String[] args) {
		ServiceRequest request = new ServiceRequest(ServiceLevel.DEBUG);
		Filter filter = new AuthFillter().setNext(new EndFilter());
		filter.filter(request);
		request.setLevel(ServiceLevel.INFO);
		filter.filter(request);
	}
}
