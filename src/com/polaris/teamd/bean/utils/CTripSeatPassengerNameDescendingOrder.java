package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author nireesha
 *
 */
public class CTripSeatPassengerNameDescendingOrder implements Comparator{
	/**
	 * This method compares two Passenger names of CTripSeat Class and sorts in descending order
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CTripSeat b1=(CTripSeat)o1;
		CTripSeat b2=(CTripSeat)o2;
		return b2.getPassengerName().compareToIgnoreCase(b1.getPassengerName());
	}

}
