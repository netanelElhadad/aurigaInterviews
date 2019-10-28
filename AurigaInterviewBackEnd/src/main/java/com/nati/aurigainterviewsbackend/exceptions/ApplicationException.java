package com.nati.aurigainterviewsbackend.exceptions;

import com.nati.aurigainterviewsbackend.enums.ErrorType;



public class ApplicationException extends Exception {
	

private ErrorType errorType;
	
	// "message, e" i don't wrote as "instance variables" because i send them to Exception/RuntimeException class
	// to take care of those variables.
	// but "errorType" dosn't exists in Exception class so i need to handle it here.
	public ApplicationException(String message, Throwable e, ErrorType errorType) {
		super(message, e);
		this.errorType = errorType;
	}

	public ApplicationException(String message, ErrorType errorType) {
		super(message);
		this.errorType = errorType;
	}
	
	public ApplicationException(String message, Throwable e) {
		super(message, e);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ErrorType getErrorType() {
		return errorType;
	}

}
