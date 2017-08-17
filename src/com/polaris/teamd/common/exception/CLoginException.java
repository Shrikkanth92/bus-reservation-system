package com.polaris.teamd.common.exception;

import java.util.Date;

import com.polaris.teamd.common.exception.CException;

public class CLoginException extends CException {
	
	public CLoginException() {
		super();
		
	}

	public CLoginException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super(exceptionLevel, exceptionTime, exceptionSource, exceptionObject);
		
	}

	public CLoginException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CLoginException(String message) {
		super(message);
		
	}

	public CLoginException(Throwable cause) {
		super(cause);
		
	}

	@Override
	public String getMessage() {
		return "Incorrect Username or Password Has Been Entered 3 times ";
	}

	
}
