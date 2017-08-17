package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceBookingsUntilDateAscending implements Comparator {
	/**
	 * This function compares two booking limitation date of the object and
	 * arranges them in ascending order
	 * 
	 * Returns an int value like 1,-1,0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService b1 = (CBusService) o1;
		CBusService b2 = (CBusService) o2;
		return b1.getBookingsUntilDate().compareTo(b2.getBookingsUntilDate());

	}

}
