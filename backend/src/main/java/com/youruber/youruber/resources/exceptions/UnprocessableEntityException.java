package com.youruber.youruber.resources.exceptions;

public class UnprocessableEntityException extends RuntimeException {

	private static final long serialVersionUID = 4285766557842589336L;

	
	public UnprocessableEntityException(String msg) {
		super(msg);
	}
	
	
}
