package com.bti.inventory.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleInventoryException(InventoryException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),exception.getErrorCode());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);	}
	

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
		LOGGER.error("Validation failure  {}", exception);
		BindingResult bindingResult = exception.getBindingResult();
		List<ApiFieldError> apiFieldErrors = bindingResult
				.getFieldErrors().stream().map(fieldError -> new ApiFieldError(fieldError.getField(),
						fieldError.getCode(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		List<GlobalError> globalErrors = bindingResult.getGlobalErrors().stream()
				.map(globalError -> new GlobalError(globalError.getObjectName(), globalError.getDefaultMessage()))
				.collect(Collectors.toList());

		ErrorResponse errorResponse = new ErrorResponse(apiFieldErrors, globalErrors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
