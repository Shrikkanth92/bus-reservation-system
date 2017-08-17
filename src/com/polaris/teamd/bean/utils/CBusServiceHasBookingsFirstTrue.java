package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceHasBookingsFirstTrue implements Comparator {
	/**
	 * This function compares two bookings availability status of the BusService
	 * object and arranges them in true followed by false order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService b1 = (CBusService) o1;
		CBusService b2 = (CBusService) o2;
		if (b1.isHasBookings() == b2.isHasBookings())
			return 0;
		if (b2.isHasBookings())
			return 1;
		return -1;
	}

}
