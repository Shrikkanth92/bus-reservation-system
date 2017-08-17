package com.polaris.teamd.app;

import javax.swing.JOptionPane;

import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.logging.CConsoleLogger;
import com.polaris.teamd.logging.CLogger;

/**
 * 
 * @author Gowtham
 * 
 */
public class CExceptionHandler {
	CLogger cLogger = new CConsoleLogger();

	/**
	 * This is a default constructor
	 */
	public CExceptionHandler() {
		super();
	}

	/**
	 * This is a parameterized constructor
	 * 
	 * @param cLogger
	 */
	public CExceptionHandler(CLogger cLogger) {
		super();
		this.cLogger = cLogger;
	}

	public CLogger getcLogger() {
		return cLogger;
	}

	public void setcLogger(CLogger cLogger) {
		this.cLogger = cLogger;
	}

	/**
	 * This function calls the exception message printing function based on the
	 * CLogger object
	 * 
	 * @param cException
	 * @return
	 */
	public CException handleException(CException cException) {
		cLogger.log(cException);
		showUI(cException);
		return cException;
	}

	/**
	 * This function is used to display the error message in the user interface
	 * 
	 * @param cException
	 */
	void showUI(CException cException) {
		JOptionPane.showInputDialog(getcLogger(),
				"Are you sure you want to continue?");
	}
}
