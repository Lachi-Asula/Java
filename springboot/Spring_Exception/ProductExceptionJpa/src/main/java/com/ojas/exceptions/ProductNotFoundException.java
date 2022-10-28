package com.ojas.exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String str) {
		super(str);
	}
}
