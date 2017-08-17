package com.polaris.teamd.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Gowtham
 * 
 */
public class UIDateUtil {
	/**
	 * This function converts the string into date
	 * 
	 * @param data
	 *            - This parameter takes the string for the date conversion
	 * @param format
	 *            - This parameter takes the format for the date conversion
	 * @return- This function returns the date
	 */
	public static Date convertStringToDate(String data, String format) {
		SimpleDateFormat format1 = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = format1.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * This function converts the date into string
	 * 
	 * @param date
	 *            - This parameter takes the date for the string conversion
	 * @param format
	 *            - This parameter takes the format of the string that has to be
	 *            converted
	 * @return- This function returns the string
	 */
	public static String convertDateToString(Date date, String format) {
		SimpleDateFormat format1 = new SimpleDateFormat(format);
		String str = format1.format(date);
		return str;
	}
}
