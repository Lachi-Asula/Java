package com.ojas.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProductNotFoundException pex, WebRequest request){
		
		ProductExeption pe = new ProductExeption(pex.getMessage(),request.getDescription(false),new Date(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Object>(pe, HttpStatus.NOT_FOUND);
	}
	
}
