package com.polaris.teamd.common.exception;

import java.util.Date;

/**
 * 
 * @author Gowtham
 * 
 */
public class CException extends Exception {
	int exceptionLevel;
	Date exceptionTime;
	Class exceptionSource;
	Throwable exceptionObject;

	/**
	 * This is a default constructor
	 */
	public CException() {
		super();

	}

	public CException(String message, Throwable cause) {
		super(message, cause);

	}

	public CException(String message) {
		super(message);

	}

	public CException(Throwable cause) {
		super(cause);

	}

	/**
	 * This is a parameterized constructor
	 */
	public CException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super();
		this.exceptionLevel = exceptionLevel;
		this.exceptionTime = exceptionTime;
		this.exceptionSource = exceptionSource;
		this.exceptionObject = exceptionObject;
	}

	public int getExceptionLevel() {
		return exceptionLevel;
	}

	public void setExceptionLevel(int exceptionLevel) {
		this.exceptionLevel = exceptionLevel;
	}

	public Date getExceptionTime() {
		return exceptionTime;
	}

	public void setExceptionTime(Date exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

	public Class getExceptionSource() {
		return exceptionSource;
	}

	public void setExceptionSource(Class exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

	public Throwable getExceptionObject() {
		return exceptionObject;
	}

	public void setExceptionObject(Throwable exceptionObject) {
		this.exceptionObject = exceptionObject;
	}

	/**
	 * This function returns the to string output of the CException
	 */
	@Override
	public String toString() {
		return "CException [exceptionLevel=" + exceptionLevel
				+ ", exceptionTime=" + exceptionTime + ", exceptionSource="
				+ exceptionSource + ", exceptionObject=" + exceptionObject
				+ "]";
	}

	/**
	 * This function returns the message about the CException
	 */
	public String getMessage() {
		return exceptionObject.getMessage();
	}

}
