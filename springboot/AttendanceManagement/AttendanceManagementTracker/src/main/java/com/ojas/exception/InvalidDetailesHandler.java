package com.ojas.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidDetailesHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidDetailesException.class)
	public ResponseEntity<Object> handleInvalidData(InvalidDetailesException ex, WebRequest req){
		
		InvalidDetailes id = new InvalidDetailes(ex.getMessage(), req.getDescription(false), new Date(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Object>(id, HttpStatus.BAD_REQUEST);
	}
}
