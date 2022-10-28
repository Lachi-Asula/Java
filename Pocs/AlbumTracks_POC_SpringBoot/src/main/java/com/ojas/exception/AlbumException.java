package com.ojas.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumException {

	private String message;
	private String detailes;
	private Date timestamp;
	private HttpStatus status;
	
}
