package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceServiceIdAscending implements Comparator {
	/**
	 * This function compares two service id values of the BusService object and
	 * arranges them in ascending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService op1 = (CBusService) o1;
		CBusService op2 = (CBusService) o2;
		if (op1.getServiceId() < op2.getServiceId())
			return -1;
		if (op1.getServiceId() > op2.getServiceId())
			return 1;
		return 0;
	}

}