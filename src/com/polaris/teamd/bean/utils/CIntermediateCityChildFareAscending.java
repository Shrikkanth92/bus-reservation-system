package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CIntermediateCity;

public class CIntermediateCityChildFareAscending implements Comparator {
	/**
	 * This function compares two child fares of the IntermediateCity object and
	 * arranges them in ascending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CIntermediateCity iCity1 = (CIntermediateCity) o1;
		CIntermediateCity iCity2 = (CIntermediateCity) o2;
		if (iCity1.getChildFare() < iCity2.getChildFare())
			return -1;
		if (iCity1.getChildFare() > iCity2.getChildFare())
			return 1;
		return 0;
	}
}