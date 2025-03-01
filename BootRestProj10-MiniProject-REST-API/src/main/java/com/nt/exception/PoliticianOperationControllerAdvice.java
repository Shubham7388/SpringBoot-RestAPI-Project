package com.nt.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.entity.Politician;

@RestControllerAdvice
public class PoliticianOperationControllerAdvice {

	@ExceptionHandler(PoliticianNotFoundException.class)
	public ResponseEntity<String> handlePoliticianNotFoundException(PoliticianNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception e) {
		return new ResponseEntity<String>("Internal Server Problem:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
