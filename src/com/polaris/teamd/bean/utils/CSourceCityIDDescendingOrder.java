package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CSourceCity;
/**
 * 
 * @author nireesha
 *
 */
public class CSourceCityIDDescendingOrder implements Comparator{
/**
 * This method compares two city ID values of CSourceCity Class and sorts in descending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CSourceCity cityId = (CSourceCity) o1;
		CSourceCity cityId1 = (CSourceCity) o2;
		if(cityId.getCityId() > cityId1.getCityId()){
			return -1;
		}
		if(cityId.getCityId() > cityId1.getCityId()){
			return 1;
		}
		return 0;
	}

}
