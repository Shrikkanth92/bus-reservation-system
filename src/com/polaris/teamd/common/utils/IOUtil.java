package com.polaris.teamd.common.utils;

import java.io.File;

/**
 * 
 * @author
 * 
 *         This class is used for Opening and Closing Files
 */
public class IOUtil {

	/**
	 * This function is used to get the required File
	 * 
	 * @param fileName
	 * @return <i>file object is returned </i>
	 */
	public static File getFile(String fileName) {
		File file = new File(fileName);
		return file;
	}

	/**
	 * This function is used to close a file
	 * 
	 * @param file
	 */
	public static void closeFile(File file) {

	}
}