package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusServiceArrivalTimeDescending implements Comparator {
	/**
	 * This function compares two arrival times of the BusService object and
	 * arranges them in descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusService serv1 = (CBusService) o1;
		CBusService serv2 = (CBusService) o2;
		return serv2.getArrivalTime().compareTo(serv1.getArrivalTime());
	}
}
