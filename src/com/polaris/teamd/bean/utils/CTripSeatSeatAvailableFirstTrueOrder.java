package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author nireesha
 *
 */
public class CTripSeatSeatAvailableFirstTrueOrder implements Comparator {
/**
 * This method compares the availability of seats in CTripSeat Class and sorts in first true order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CTripSeat b1 = (CTripSeat) o1;
		CTripSeat b2 = (CTripSeat) o2;
		if (b1.isSeatAvailable() == b2.isSeatAvailable()) {
			return 0;
		}
		if (b2.isSeatAvailable())
			return 1;

		return -1;
	}

}
