package com.bti.inventory.exception;

import java.util.List;

import com.bti.inventory.status.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse {

	private ErrorCodes errorCode;

	private String message;

	private List<ApiFieldError> apiFieldErrors;

	private List<GlobalError> globalErrors;

	public ErrorCodes getCodes() {
		return errorCode;
	}

	public void setCodes(ErrorCodes codes) {
		this.errorCode = codes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse(List<ApiFieldError> apiFieldErrors2, List<GlobalError> globalErrors2) {
		apiFieldErrors = apiFieldErrors2;
		globalErrors = globalErrors2;
	}

	public ErrorResponse() {
	}

	public ErrorResponse(String message2, ErrorCodes errorCode2) {
		message = message2;
		errorCode = errorCode2;
	}

	public List<ApiFieldError> getApiFieldErrors() {
		return apiFieldErrors;
	}

	public void setApiFieldErrors(List<ApiFieldError> apiFieldErrors) {
		this.apiFieldErrors = apiFieldErrors;
	}

	public List<GlobalError> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<GlobalError> globalErrors) {
		this.globalErrors = globalErrors;
	}

}
