package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceHasDeleteRequestFirstFalse implements Comparator {
	/**
	 * This function compares two delete request of the BusService object and
	 * arranges them in false followed by true order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService b1 = (CBusService) o1;
		CBusService b2 = (CBusService) o2;
		if (b1.isHasDeleteRequest() == b2.isHasDeleteRequest())
			return 0;
		if (b1.isHasDeleteRequest())
			return 1;
		return -1;
	}

}
