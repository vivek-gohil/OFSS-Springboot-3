package com.ofss.main.exception;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<ProblemDetail> handleInvalidAgeException(InvalidAgeException invalidAgeException) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setTitle("Invalid Age");
		problemDetail.setType(URI.create("http://localhost:8080/vote/"));
		problemDetail.setProperty("host", "localhost");
		problemDetail.setProperty("port", "8080");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
	}

}
