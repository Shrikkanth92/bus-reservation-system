package com.polaris.teamd.common.exception;

import java.util.Date;

/**
 * 
 * @author Gowtham
 * 
 */
public class CResourceNotFoundException extends CException {
	String missingResource;

	/**
	 * This is a default constructor
	 */
	public CResourceNotFoundException() {
		super();
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param missingResource
	 */
	public CResourceNotFoundException(String missingResource) {
		super();
		this.missingResource = missingResource;
	}

	public CResourceNotFoundException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super(exceptionLevel, exceptionTime, exceptionSource, exceptionObject);
	}

	public CResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public String getMissingResource() {
		return missingResource;
	}

	public void setMissingResource(String missingResource) {
		this.missingResource = missingResource;
	}

	/**
	 * This function returns the to string output of the
	 * CResourceNotFoundException
	 */
	@Override
	public String toString() {
		return super.toString()
				+ "CResourceNotFoundException [missingProperty="
				+ missingResource + "]";
	}

	/**
	 * This function returns the message about the CResourceNotFoundException
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
