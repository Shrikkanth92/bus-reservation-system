package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CReservation;
/**
 * 
 * @author nireesha
 *
 */
public class CReservationIDNumberAscendingOrder implements Comparator{
/**
 * This method compares two passenger ID no values of CReservation Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CReservation name1= (CReservation) o1;
		CReservation name2= (CReservation) o2;
		return name1.getPassengerIdNumber().compareTo(name2.getPassengerIdNumber());
	}

}
