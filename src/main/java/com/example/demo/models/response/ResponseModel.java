package com.example.demo.models.response;

public class ResponseModel {

	private boolean successfully;
	private String message;
	
		
	public ResponseModel(boolean successfully, String message) {
		this.successfully = successfully;
		this.message = message;
	}
	public boolean isSuccessfully() {
		return successfully;
	}
	public void setSuccessfully(boolean successfully) {
		this.successfully = successfully;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
