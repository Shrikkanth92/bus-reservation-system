package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author nireesha
 *
 */
public class CTripIsTripActiveFalseOrder implements Comparator{
/**
 * This method compares two values in Active status of CTrip Class and sorts in false order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CTrip no1=(CTrip) o1;
		CTrip no2=(CTrip) o2;
		
		if (no1.isTripActive() == no2.isTripActive()) {
			return 0;
		}
		if(no2.isTripActive())
		return 1;
		
		return -1;
	}

}
