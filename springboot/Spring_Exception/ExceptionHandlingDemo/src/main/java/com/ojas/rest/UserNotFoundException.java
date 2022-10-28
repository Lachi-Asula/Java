package com.ojas.rest;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String str) {
		super(str);
	}
}
