package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CIntermediateCity;

/**
 * 
 * @author Gowtham
 * 
 */
public class CIntermediateCityArrivalTimeAscending implements Comparator {
	/**
	 * This function compares two arrival times of the IntermediateCity object
	 * and arranges them in ascending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CIntermediateCity iCity1 = (CIntermediateCity) o1;
		CIntermediateCity iCity2 = (CIntermediateCity) o2;
		return iCity1.getArrivalTime().compareTo(iCity2.getArrivalTime());
	}
}