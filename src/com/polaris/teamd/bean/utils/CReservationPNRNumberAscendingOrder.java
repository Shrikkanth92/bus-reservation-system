package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationPNRNumberAscendingOrder implements Comparator {
/**
 * This method compares two PNR number values of CReservation Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation no1= (CReservation) o1;
		CReservation no2= (CReservation) o2;
		
		if (no1.getPNRNumber()<no2.getPNRNumber())
			return -1 ;
		if (no1.getPNRNumber()>no2.getPNRNumber())
			return 1 ;
		return 0;
	}

}
