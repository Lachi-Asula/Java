package com.ojas.exception;

public class AlbumNotFoundException extends RuntimeException{

	public AlbumNotFoundException(String msg) {
		super(msg);
	}
}
