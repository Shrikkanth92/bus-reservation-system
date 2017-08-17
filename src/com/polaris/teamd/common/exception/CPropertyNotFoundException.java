package com.polaris.teamd.common.exception;

import java.util.Date;

/**
 * 
 * @author Gowtham
 * 
 */
public class CPropertyNotFoundException extends CException {
	String missingProperty;

	/**
	 * This is a default constructor
	 */
	public CPropertyNotFoundException() {
		super();
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param missingProperty
	 */
	public CPropertyNotFoundException(String missingProperty) {
		super();
		this.missingProperty = missingProperty;
	}

	public CPropertyNotFoundException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super(exceptionLevel, exceptionTime, exceptionSource, exceptionObject);
	}

	public CPropertyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CPropertyNotFoundException(Throwable cause) {
		super(cause);
	}

	public String getMissingProperty() {
		return missingProperty;
	}

	public void setMissingProperty(String missingProperty) {
		this.missingProperty = missingProperty;
	}

	/**
	 * This function returns the to string output of the
	 * CPropertyNotFoundException
	 */
	@Override
	public String toString() {
		return super.toString()
				+ "CPropertyNotFoundException [missingProperty="
				+ missingProperty + "]";
	}

	/**
	 * This function returns the message about the CPropertyNotFoundException
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
