package com.study.dawn.handler;

import com.study.dawn.common.ErrorInfo;
import com.study.dawn.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorInfo> handleNotFound(HttpServletRequest request, NotFoundException e) throws Exception{

        ErrorInfo error = new ErrorInfo();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setMessage(e.getMessage());

        ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
