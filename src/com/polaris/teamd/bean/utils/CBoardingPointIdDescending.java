package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBoardingPointIdDescending implements Comparator {

	/**
	 * This function compares two boarding point id values of the object and
	 * arranges them in descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBoardingPoint bp1 = (CBoardingPoint) o1;
		CBoardingPoint bp2 = (CBoardingPoint) o2;
		if (bp1.getId() < bp2.getId())
			return 1;
		if (bp1.getId() > bp2.getId())
			return -1;
		return 0;
	}
}
