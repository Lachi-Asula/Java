package com.ssn.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class SsnException {

	private String message;
	private String detailes;
	private Date timestamp;
	private HttpStatus status;
	
	public SsnException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SsnException(String message, String detailes, Date timestamp, HttpStatus status) {
		super();
		this.message = message;
		this.detailes = detailes;
		this.timestamp = timestamp;
		this.status = status;
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

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
