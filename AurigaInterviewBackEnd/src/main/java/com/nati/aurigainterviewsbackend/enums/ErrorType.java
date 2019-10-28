package com.nati.aurigainterviewsbackend.enums;


public enum ErrorType {
	
	WE_ARE_SORY_THERE_IS_A_GENERAL_ERROR(701);
	
	private int errorNumber;
	
	private ErrorType (int errorNumber) {
		this.errorNumber = errorNumber;
	}
	
	public int getErrorNumber() {
		return errorNumber;
	}
	
	public static ErrorType fromString (final String s) {
		return ErrorType.valueOf(s);
	}

}
