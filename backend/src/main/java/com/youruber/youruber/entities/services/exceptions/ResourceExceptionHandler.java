package com.youruber.youruber.entities.services.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.youruber.youruber.resources.exceptions.DataBaseException;
import com.youruber.youruber.resources.exceptions.StandardError;
import com.youruber.youruber.resources.exceptions.UnprocessableEntityException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
	   StandardError err = new StandardError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(HttpStatus.NOT_FOUND.value());
	   err.setError("Resource not found");
	   err.setMessage(e.getMessage());
       err.setPath(request.getRequestURI());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
	   HttpStatus status = HttpStatus.BAD_REQUEST;
	   StandardError err = new StandardError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(status.value());
	   err.setError("Database exception");
	   err.setMessage(e.getMessage());
       err.setPath(request.getRequestURI());
       return ResponseEntity.status(status).body(err);
	}
	
	 @ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<StandardError> unprocessableEntity(UnprocessableEntityException e, HttpServletRequest request){
	   HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
	   StandardError err = new StandardError();
	   err.setTimestamp(Instant.now());
	   err.setStatus(status.value());
	   err.setError("Unprocessable Entity exception");
	   err.setMessage(e.getMessage());
       err.setPath(request.getRequestURI());
       return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	
}
