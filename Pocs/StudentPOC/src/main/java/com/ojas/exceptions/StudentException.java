package com.ojas.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class StudentException {
	
	private String message;
	private String detailes;
	private Date timestamp;
	private HttpStatus httpStatus;
	
	public StudentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentException(String message, String detailes, Date timestamp, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.detailes = detailes;
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailes() {
		return detailes;
	}

	public void setDetailes(String detailes) {
		this.detailes = detailes;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
