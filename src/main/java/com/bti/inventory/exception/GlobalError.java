package com.bti.inventory.exception;

public class GlobalError {
	private String objectName;

	private String message;

	public GlobalError(String objectName2, String defaultMessage) {
		objectName = objectName2;
		message = defaultMessage;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
