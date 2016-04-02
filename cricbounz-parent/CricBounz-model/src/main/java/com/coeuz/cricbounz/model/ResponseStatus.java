package com.coeuz.cricbounz.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseStatus {
	
	private String responseStatus;
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private String errorMessage;

}
