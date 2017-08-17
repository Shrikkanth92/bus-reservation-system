package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha.patnam
 *
 */
public class CReservationBookedByAscendingOrder implements Comparator{
/**
 * This method compares two booked Staff name values of CReservation Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		
		CReservation name1= (CReservation) o1;
		CReservation name2= (CReservation) o2;
		return name1.getBookedBy().compareTo(name2.getBookedBy());
	}

}
