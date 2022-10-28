package com.ojas.exception;

import java.util.Date;

public class UserException {
	
	private String message;
	private String detailes;
	private Date timeStamp;
	
	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message, String detailes, Date timeStamp) {
		super();
		this.message = message;
		this.detailes = detailes;
		this.timeStamp = timeStamp;
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
	
}
