package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CPNRCancellation;
/**
 * 
 * @author nireesha
 *
 */
public class CPNRCancellationCancelTimeDescendingOrder implements Comparator {
/**
 * This method compares two Cancellation Time values of CPNR Cancellation Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CPNRCancellation no1 = (CPNRCancellation) o1;
		CPNRCancellation no2 = (CPNRCancellation) o2;
		return no2.getCancellationTime().compareTo(no1.getCancellationTime());

	}

}
