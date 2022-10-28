package com.ojas.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class UserException {

	private String message;
	private String detailes;
	private Date timeStamp;
	private HttpStatus status;
	
	public UserException(String message, String detailes, Date timeStamp, HttpStatus status) {
		super();
		this.message = message;
		this.detailes = detailes;
		this.timeStamp = timeStamp;
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

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
