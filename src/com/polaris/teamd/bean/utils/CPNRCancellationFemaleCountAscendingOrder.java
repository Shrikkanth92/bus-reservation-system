package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CPNRCancellation;
/**
 * 
 * @author nireesha
 *
 */
public class CPNRCancellationFemaleCountAscendingOrder implements Comparator{
/**
 * This method compares two Cancelled female values of CPNR Cancellation Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CPNRCancellation no1=(CPNRCancellation) o1;
		CPNRCancellation no2=(CPNRCancellation) o2;
		if (no1.getCancelledFemaleCount()<no2.getCancelledFemaleCount())
			return -1 ;
		if (no1.getCancelledFemaleCount()>no2.getCancelledFemaleCount())
			return 1 ;
		
		return 0;
	}

}
