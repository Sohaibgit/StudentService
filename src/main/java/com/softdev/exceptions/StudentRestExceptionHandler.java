package com.softdev.exceptions;

import com.softdev.entity.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// It will handle a specific exception i.e StudentNotFoundException
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// It will handle generic exception i.e all types of exceptions (Exception)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleExeption(Exception ex) {

		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//		errorResponse.setMessage(ex.getMessage());
		errorResponse.setMessage("Bad Request, Invalid URL Syntax");
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}
}
