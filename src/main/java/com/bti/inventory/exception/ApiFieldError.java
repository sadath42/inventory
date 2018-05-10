package com.bti.inventory.exception;

public class ApiFieldError {
	private String field;
	private String code;
	private Object rejectedValue;
	private String defaultMessage;

	public ApiFieldError(String field2, String code2, Object rejectedValue2, String message) {
		field = field2;
		code = code2;
		rejectedValue = rejectedValue2;
		defaultMessage = message;
	}

	public ApiFieldError() {
	}

	public ApiFieldError(String objectName, String defaultMessage2) {
		field = objectName;
		defaultMessage = defaultMessage2;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
