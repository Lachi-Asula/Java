package com.ssn.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SsnExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SsnNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(SsnNotFoundException ssn, WebRequest request){
		SsnException sse = new SsnException(ssn.getMessage(),request.getDescription(false),new Date(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Object>(sse, HttpStatus.NOT_FOUND);
	}
}
