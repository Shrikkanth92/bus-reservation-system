package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author nireesha
 *
 */
public class CTripSeatSeatBookingCompletedFirstTrueOrder implements Comparator {
/**
 *  This method compares the completed bookings of CTripSeat Class and sorts in true first order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CTripSeat b1=(CTripSeat)o1;
		CTripSeat b2=(CTripSeat)o2;
		if (b1.isBookingCompleted() == b2.isBookingCompleted()) {
			return 0;
		}
		if(b2.isBookingCompleted())
		return 1;
		
		return -1;

	}

}
