package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CPNRCancellation;
/**
 * 
 * @author nireesha
 *
 */
public class CPNRCancellationCancelDateDescendingOrder implements Comparator {
/**
 * This method compares two Cancellation date values of CPNR Cancellation Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CPNRCancellation date1 = (CPNRCancellation) o1;
		CPNRCancellation no2 = (CPNRCancellation) o2;

		return no2.getCancellationDate().compareTo(date1.getCancellationDate());
	}

}
