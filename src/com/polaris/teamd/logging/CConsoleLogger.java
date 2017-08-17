package com.polaris.teamd.logging;

import javax.swing.JOptionPane;

import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CLoginException;

/**
 * 
 * @author Gowtham
 * 
 */
public class CConsoleLogger extends CLogger {
	/**
	 * This function prints the level,time,source and message of the exception
	 */
	@Override
	public CException log(CException cException) {
		if (cException.getExceptionLevel() == 1) {
			if (cException.getClass() == CLoginException.class)
				showUI();
			else {
				System.err.println("error:\n[SEVERE] ["
						+ cException.getExceptionTime() + "] ["
						+ cException.getExceptionSource() + "] ["
						+ cException.getMessage() + "]\n");
				System.exit(0);
			}
		} else
			System.err.println("error:\n[WARNING] ["
					+ cException.getExceptionTime() + "] ["
					+ cException.getExceptionSource() + "] ["
					+ cException.getMessage() + "]\n");
		return cException;
	}

	void showUI() {
		JOptionPane.showMessageDialog(null, "Incorrect Username or Password Has Been Entered 3 times");
		System.exit(0);
	}
}
