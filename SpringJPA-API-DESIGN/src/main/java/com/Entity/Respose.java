package com.Entity;

import java.util.Date;

public class Respose {

	private String Message;
	
	private String Code;
	
	private String date;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Respose(String message, String code, String date) {
		
		Message = message;
		Code = code;
		this.date = date;
	}

	public Respose() {
		
	}
	
	
}
