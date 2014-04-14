package com.liu.designpattern.chainofresponsibility;

public abstract class FilterHandler implements Filter {
	private Filter filter;

	public Filter getNext() {
		return filter;
	}

	public Filter setNext(Filter filter) {
		this.filter = filter;
		return this;
	}
}
