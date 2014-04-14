package com.liu.designpattern.chainofresponsibility;

public class EndFilter extends FilterHandler {

	@Override
	public void filter(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("the next list end");
		// getNext().filter(request);
	}

}
