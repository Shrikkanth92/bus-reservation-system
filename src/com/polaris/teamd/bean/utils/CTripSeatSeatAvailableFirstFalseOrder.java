package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author nireesha
 *
 */
public class CTripSeatSeatAvailableFirstFalseOrder implements Comparator {
/**
 * This method compares the availability of seats in CTripSeat Class and sorts in false first order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CTripSeat b1=(CTripSeat)o1;
		CTripSeat b2=(CTripSeat)o2;
		if (b1.isSeatAvailable() == b2.isSeatAvailable()) {
			return 0;
		}
		if(b1.isSeatAvailable())
		return 1;
		
		return -1;

	}
	

}
