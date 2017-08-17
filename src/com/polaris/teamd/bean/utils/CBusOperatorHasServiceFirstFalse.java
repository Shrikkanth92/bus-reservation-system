package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusOperatorHasServiceFirstFalse implements Comparator {
	/**
	 * This function compares two service availability status of the BusOperator
	 * object and arranges them in false followed by true order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusOperator op1 = (CBusOperator) o1;
		CBusOperator op2 = (CBusOperator) o2;
		if (op1.isHasService() == op2.isHasService())
			return 0;
		if (op1.isHasService())
			return 1;
		return -1;
	}
}
