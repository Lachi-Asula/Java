package com.education.utils.exception;

import com.education.dao.UserStatusDao;
import com.education.dto.Constants;
import com.education.dto.ExceptionResponseDto;
import com.education.dto.GenerateTokenResDto;
import com.education.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class UserDefinedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<GenerateTokenResDto> handleUserNotFoundException(UsernameNotFoundException usernameNotFoundException, WebRequest request){
        GenerateTokenResDto generateTokenResDto = null;
        generateTokenResDto = GenerateTokenResDto.builder()
                .timeStamp(SpringUtils.getTimeStamp())
                .statusCode(Constants.statusCode_Failure)
                .errorMsg(usernameNotFoundException.getMessage())
                .build();
        return new ResponseEntity<>(generateTokenResDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<ExceptionResponseDto> handleAllExceptions(Exception ex, WebRequest req, String data) {
        ExceptionResponseDto exceptionResponse = ExceptionResponseDto.builder()
                .statusCode(Constants.statusCode_Failure)
                .message(ex.getMessage())
                .timestamp(new Date())
                .details(req.getDescription(false))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
