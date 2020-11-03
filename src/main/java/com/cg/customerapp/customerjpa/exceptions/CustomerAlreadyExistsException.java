package com.cg.customerapp.customerjpa.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {

	public CustomerAlreadyExistsException() {

	}

	public CustomerAlreadyExistsException(String msg) {
		super(msg);
	}
}
