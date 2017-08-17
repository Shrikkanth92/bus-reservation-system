package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author nireesha
 *
 */
public class CTripCancelledSeatCountDescendingOrder implements Comparator{
/**
 * This method compares two cancelled seat count values of CTrip Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CTrip no1=(CTrip) o1;
		CTrip no2=(CTrip) o2;
		if (no1.getCancelledSeatCount()<no2.getCancelledSeatCount())
			return 1 ;
		if (no1.getCancelledSeatCount()>no2.getCancelledSeatCount())
			return -1 ;
		return 0;
	}

}
