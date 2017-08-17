package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationPhoneNo1AscendingOrder implements Comparator {
/**
 * This method compares two phone numbers of CReservation Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation no1= (CReservation) o1;
		CReservation no2= (CReservation) o2;
		
		return no1.getPhoneNumber1().compareTo(no2.getPhoneNumber1());
	}

}
