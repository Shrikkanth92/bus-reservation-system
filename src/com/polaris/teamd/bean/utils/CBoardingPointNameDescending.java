package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBoardingPoint;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBoardingPointNameDescending implements Comparator {
	/**
	 * This function compares two boarding point names of the object and
	 * arranges them in descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBoardingPoint bp1 = (CBoardingPoint) o1;
		CBoardingPoint bp2 = (CBoardingPoint) o2;
		return bp2.getName().compareTo(bp1.getName());
	}

}
