package com.polaris.teamd.common.utils;

import java.util.Date;

/**
 * 
 * @author Gowtham
 * 
 */
public class DBDateUtil {
	/**
	 * This function converts the sql date to util date
	 * 
	 * @param sqlDate
	 *            - sqlDate parameter takes the date in the sql format
	 * @return- This function returns the util date
	 */
	public static Date convertAsUtilDate(java.sql.Date sqlDate) {
		Date date = new Date(sqlDate.getTime());
		return date;
	}

	/**
	 * This function converts the util date to sql date
	 * 
	 * @param date
	 *            - date parameter takes the date in the util format
	 * @return- This function returns the sql date
	 */
	public static java.sql.Date convertAsSqlDate(Date date) {

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
