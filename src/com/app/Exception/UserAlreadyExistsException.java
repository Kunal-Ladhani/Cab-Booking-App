package com.app.Exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException() {
		super();
	}
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
}
