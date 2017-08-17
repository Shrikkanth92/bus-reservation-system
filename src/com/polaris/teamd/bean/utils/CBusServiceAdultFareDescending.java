package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceAdultFareDescending implements Comparator {
	/**
	 * This function compares two adult fares of the BusService object and
	 * arranges them in descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService b1 = (CBusService) o1;
		CBusService b2 = (CBusService) o2;
		if (b1.getAdultFare() < b2.getAdultFare())
			return 1;
		if (b1.getAdultFare() > b2.getAdultFare())
			return -1;
		return 0;
	}

}
