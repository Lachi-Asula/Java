package com.ojas.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AlbumExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AlbumNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(AlbumNotFoundException ex, WebRequest req){
		
		AlbumException albumEx = new AlbumException(ex.getMessage(), req.getDescription(false), new Date(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(albumEx, HttpStatus.NOT_FOUND);
	}
}
