package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationBookingTimeDescendingOrder implements Comparator{
/**
 * This method compares two booking time values of CReservation Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation name1= (CReservation) o1;
		CReservation name2= (CReservation) o2;
		return name2.getBookingTime().compareTo(name1.getBookingTime());	}

}
