package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceArrivalTimeAscending implements Comparator {
	/**
	 * This function compares two arrival times of the BusService object and
	 * arranges them in ascending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService serv1 = (CBusService) o1;
		CBusService serv2 = (CBusService) o2;
		return serv1.getArrivalTime().compareTo(serv2.getArrivalTime());
	}
}
