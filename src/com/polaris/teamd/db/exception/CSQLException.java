package com.polaris.teamd.db.exception;

import java.util.Date;

import com.polaris.teamd.common.exception.CException;

/**
 * 
 * @author Gowtham
 * 
 */
public class CSQLException extends CException {
	/**
	 * This is a default constructor
	 */
	public CSQLException() {
		super();
	}

	/**
	 * This is a parameterised constructor
	 */
	public CSQLException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super(exceptionLevel, exceptionTime, exceptionSource, exceptionObject);
	}

	public CSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSQLException(String message) {
		super(message);
	}

	public CSQLException(Throwable cause) {
		super(cause);
	}

	/**
	 * This function returns the to string output of the CSQLException
	 */
	@Override
	public String toString() {
		return super.toString() + "CSQLException []";
	}

	/**
	 * This function returns the message about the CSQLException
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
