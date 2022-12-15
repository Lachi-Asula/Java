package com.friends.utils.exception;

import com.friends.dto.CommonException;
import com.friends.dto.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Date;

import static com.friends.utils.AdapterUtils.getTimeStamp;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<CommonException> handleUserNotFoundException(UsernameNotFoundException usernameNotFoundException, WebRequest request){
        CommonException commonException = null;
            commonException = CommonException.builder()
                    .timeStamp(getTimeStamp())
                    .statusCode(HttpStatus.NOT_FOUND)
                    .errorCode(Constants.status_Failure)
                    .errorMsg(usernameNotFoundException.getMessage())
                    .build();
            return new ResponseEntity<>(commonException, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(value = ServletException.class)
    public ResponseEntity<CommonException> handleExpiredJWTTokenException(ServletException servletException, WebRequest request){
        CommonException commonException = null;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        commonException = CommonException.builder()
                .timeStamp(getTimeStamp())
                .statusCode(HttpStatus.UNAUTHORIZED)
                .errorCode(Constants.status_Failure)
                .errorMsg(servletException.getMessage())
                .build();
        return new ResponseEntity<>(commonException, httpStatus);
    }

}
