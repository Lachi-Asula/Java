package com.flames.model;

public class CommonResponse {

	private String responseText;
	private boolean isSuccessful;

	
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	public boolean getIsSuccessful() {
		return isSuccessful;
	}
	
	@Override
	public String toString() {
		return "CommonResponse [responseText=" + responseText + ", isSuccessful=" + isSuccessful + "]";
	}
	public void setIsSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	
	
}
	
