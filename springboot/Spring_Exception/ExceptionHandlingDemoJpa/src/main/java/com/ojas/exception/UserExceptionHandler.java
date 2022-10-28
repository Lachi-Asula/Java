package com.ojas.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(UserNotFoundException userEx, WebRequest request){
		UserException ue = new UserException(userEx.getMessage(), request.getDescription(false), new Date());
		
		return new ResponseEntity<Object>(ue, HttpStatus.NOT_FOUND);
	}
}
