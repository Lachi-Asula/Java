package com.ojas.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(StudentNotFoundException stdex, WebRequest request){
		
		StudentException std = new StudentException(stdex.getMessage(), request.getDescription(false), new Date(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Object>(std, HttpStatus.NOT_FOUND);
	}
}
