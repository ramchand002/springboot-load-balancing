package com.pool.customer.exception.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<CustomErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
		     String errorMessage = ex.getBindingResult().getFieldErrors().stream()
	                .findFirst()
	                .map(FieldError::getDefaultMessage)
	                .orElse("Validation error occurred");
	        CustomErrorResponse errorResponse = new CustomErrorResponse(
	                HttpStatus.BAD_REQUEST.value(),
	                errorMessage,
	                request.getRequestURI(),
	                UUID.randomUUID().toString()
	        );
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }

	
}
