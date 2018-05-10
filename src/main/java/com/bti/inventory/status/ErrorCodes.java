package com.bti.inventory.status;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
	AUTHENTICATION_MISMATCH("INV001");

	private String errorCode;

	private ErrorCodes(String errCode) {
		errorCode = errCode;
	}

	@JsonValue
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + errorCode;
	}

}
