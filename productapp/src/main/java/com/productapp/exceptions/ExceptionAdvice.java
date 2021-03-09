package com.productapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.model.ExceptionResponse;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	    @ExceptionHandler(ProductNotFoundExeption.class)
	    public ResponseEntity<Object> handleExceptions( ProductNotFoundExeption exception) {
	        ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("Not Found");
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	        return entity;
}
}
