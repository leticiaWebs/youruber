package com.youruber.youruber.entities.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4285766557842589336L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	

}
