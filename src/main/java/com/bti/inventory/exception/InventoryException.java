package com.bti.inventory.exception;

import com.bti.inventory.status.ErrorCodes;

public class InventoryException extends RuntimeException {
	
	private final ErrorCodes errorCode;

	public InventoryException(ErrorCodes errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}
	

	public InventoryException(ErrorCodes errorCode,String message, Throwable throwable) {
		super(message,throwable);
		this.errorCode = errorCode;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

}
