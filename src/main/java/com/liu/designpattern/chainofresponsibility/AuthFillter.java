package com.liu.designpattern.chainofresponsibility;

public class AuthFillter extends FilterHandler {

	@Override
	public void filter(ServiceRequest request) {
		if (ServiceLevel.DEBUG == request.getLevel()) {
			// handle this request.
			System.out.println("AuthFilter handle this");
		} else {
			if (getNext() != null) {
				getNext().filter(request);
			} else {
				throw new IllegalArgumentException("No handler found for :: " + request.getLevel());
			}
		}
	}

}
