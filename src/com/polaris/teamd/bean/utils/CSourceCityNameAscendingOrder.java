package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CSourceCity;
/**
 * 
 * @author nireesha
 *
 */
public class CSourceCityNameAscendingOrder implements Comparator{
/**
 * This method compares two city name values of CSourceCity Class and sorts in ascending order
 */
	@Override
	public int compare(Object o1, Object o2) {
		CSourceCity c1 =(CSourceCity) o1;
		CSourceCity c2 =(CSourceCity) o2;
		return c1.getCityName().compareToIgnoreCase(c2.getCityName());
	}

}
