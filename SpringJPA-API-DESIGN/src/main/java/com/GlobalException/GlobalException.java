package com.GlobalException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Entity.Respose;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler
	public ResponseEntity<Respose> handleGlobalException(Exception exc)
	{
		Respose response = new Respose();
		response.setCode(HttpStatus.BAD_REQUEST.toString());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		   
		response.setDate(dtf.format(now));
		response.setMessage("Please enter Only Integer value in the Pathvariable");
		return new ResponseEntity<Respose>(response,HttpStatus.BAD_REQUEST);
	}
	
}
