package com.polaris.teamd.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.polaris.teamd.common.exception.CException;

/**
 * 
 * @author Gowtham
 * 
 */
public class CFileLogger extends CLogger {

	File file;
	String error;

	/**
	 * This is a default constructor
	 */
	public CFileLogger() {
		super();
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param file
	 */
	public CFileLogger(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * This fuction writes the exception message into a file
	 * 
	 * @param file
	 *            - This parameter takes the file to write the message
	 */
	void createFile(File file) {

		FileWriter fstream;
		try {
			fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(error);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This function creates an error message and pass it to create a file
	 */
	@Override
	public CException log(CException cException) {
		if (cException.getExceptionLevel() == 1)
			error = ("error:\n[SEVERE] [" + cException.getExceptionTime()
					+ "] [" + cException.getExceptionSource() + "] ["
					+ cException.getMessage() + "]\n");
		else
			error = ("error:\n[WARNING] [" + cException.getExceptionTime()
					+ "] [" + cException.getExceptionSource() + "] ["
					+ cException.getMessage() + "]\n");
		createFile(file);
		return cException;
	}

}
