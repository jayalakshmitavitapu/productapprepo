package com.productapp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.productapp.exceptions.ProductIdNotFoundExeption;
import com.productapp.exceptions.ProductsNotAvailableException;
import com.productapp.model.CustomResponse;
import com.productapp.model.ExceptionResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {
	@ExceptionHandler(ProductIdNotFoundExeption.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ProductIdNotFoundExeption ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("404");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProductsNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> noProductsAvailableException(ProductsNotAvailableException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("601");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ExceptionHandler(ConversionNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleConversionNotSupportedException(ConversionNotSupportedException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("500");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMediaTypeNotSupportedException(
			HttpMediaTypeNotSupportedException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("415");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMediaTypeNotAcceptableException(
			HttpMediaTypeNotAcceptableException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("406");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("405");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("404");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ExceptionResponse> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("400");
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}