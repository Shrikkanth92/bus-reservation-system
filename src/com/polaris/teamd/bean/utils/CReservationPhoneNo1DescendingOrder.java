package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationPhoneNo1DescendingOrder implements Comparator {
/**
 * This method compares two phone number values of CReservation Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation no1= (CReservation) o1;
		CReservation no2= (CReservation) o2;
		
		return no2.getPhoneNumber1().compareTo(no1.getPhoneNumber1());
	}

}
