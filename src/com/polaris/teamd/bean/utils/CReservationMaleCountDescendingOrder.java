package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationMaleCountDescendingOrder implements Comparator{
/**
 * This method compares two male count values of CReservation Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation no1= (CReservation) o1;
		CReservation no2= (CReservation) o2;
		
		if (no1.getMaleCount()<no2.getMaleCount())
			return 1 ;
		if (no1.getMaleCount()>no2.getMaleCount())
			return -1 ;
		return 0;
	}

}
