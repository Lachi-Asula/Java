package com.ojas.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ProductExeption {
	
	private String message;
	private String detailes;
	private Date timeStamp;
	private HttpStatus status;
	
	public ProductExeption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductExeption(String message, String detailes, Date timeStamp, HttpStatus status) {
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
	
}
