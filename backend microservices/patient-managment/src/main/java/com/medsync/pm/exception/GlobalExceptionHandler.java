package com.medsync.pm.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





@ControllerAdvice
public class GlobalExceptionHandler {
	
	 private static final Logger log = LoggerFactory.getLogger(
		      GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> notValidMethodArgumentExHandler(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors()
				.forEach(error -> errors.put(((FieldError) error).getField(), error.getDefaultMessage()));
		return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailAlreadyExist.class)
	public ResponseEntity<Map<String, String>> handelAlreadyExistEmailException(EmailAlreadyExist ex) {
		
		log.warn("email is alredy exist {}", ex.getMessage());
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getLocalizedMessage());
		return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(PatientDoesNotExist.class)
	public ResponseEntity<Map<String, String>> handelWrongUUIDException(PatientDoesNotExist ex) {
		
		log.warn("patient with this UUID does not exist ", ex.getMessage());
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getLocalizedMessage());
		return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
	}
}
