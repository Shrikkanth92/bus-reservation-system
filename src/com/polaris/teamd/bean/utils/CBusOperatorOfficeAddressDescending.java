package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
/**
 * 
 * @author Gowtham
 * 
 */
public class CBusOperatorOfficeAddressDescending implements Comparator {
	/**
	 * This function compares two addresses of the object and arranges them in
	 * descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusOperator op1 = (CBusOperator) o1;
		CBusOperator op2 = (CBusOperator) o2;
		return op2.getOfficeAddress().compareTo(op1.getOfficeAddress());
	}
}