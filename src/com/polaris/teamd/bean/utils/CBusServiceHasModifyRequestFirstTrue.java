package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceHasModifyRequestFirstTrue implements Comparator {
	/**
	 * This function compares two modify request of the BusService object and
	 * arranges them in true followed by false order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService b1 = (CBusService) o1;
		CBusService b2 = (CBusService) o2;
		if (b1.isHasModifyRequest() == b2.isHasModifyRequest())
			return 0;
		if (b2.isHasModifyRequest())
			return 1;
		return -1;
	}

}
