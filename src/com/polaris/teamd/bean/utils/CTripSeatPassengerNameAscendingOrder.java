package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author nireesha
 *
 */
public class CTripSeatPassengerNameAscendingOrder implements Comparator{
	/**
	 * This method compares two Passenger names of CTripSeat Class and sorts in Ascending order
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CTripSeat b1=(CTripSeat)o1;
		CTripSeat b2=(CTripSeat)o2;
		return b1.getPassengerName().compareToIgnoreCase(b2.getPassengerName());
	}
	

}
