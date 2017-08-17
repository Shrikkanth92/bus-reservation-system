package com.polaris.teamd.db.exception;

import java.util.Date;

import com.polaris.teamd.common.exception.CException;

/**
 * 
 * @author Gowtham
 * 
 */
public class CDBConnectionException extends CException {
	String hostName, ipAddress, username, password;

	/**
	 * This is a default constructor
	 */
	public CDBConnectionException() {
		super();
	}

	/**
	 * This is a parameterised constructor
	 */
	public CDBConnectionException(String hostName, String ipAddress,
			String username, String password) {
		super();
		this.hostName = hostName;
		this.ipAddress = ipAddress;
		this.username = username;
		this.password = password;
	}

	public CDBConnectionException(int exceptionLevel, Date exceptionTime,
			Class exceptionSource, Throwable exceptionObject) {
		super(exceptionLevel, exceptionTime, exceptionSource, exceptionObject);

	}

	public CDBConnectionException(String message, Throwable cause) {
		super(message, cause);

	}

	public CDBConnectionException(String message) {
		super(message);

	}

	public CDBConnectionException(Throwable cause) {
		super(cause);

	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This function returns the to string output of the CDBConnectionException
	 */
	@Override
	public String toString() {
		return super.toString() + "CDBConnectionException [hostName="
				+ hostName + ", ipAddress=" + ipAddress + ", username="
				+ username + ", password=" + password + "]";
	}

	/**
	 * This function returns the message about the CDBConnectionException
	 */
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
