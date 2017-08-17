package com.polaris.teamd.bean.utils;

import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;

/**
 * 
 * @author Gowtham
 * 
 */
public class CBusOperatorOperatorIdDescending implements Comparator {
	/**
	 * This function compares two id values of the object and arranges them in
	 * descending order
	 * 
	 * Returns an int value like 1,-1 and 0
	 */
	@Override
	public int compare(Object o1, Object o2) {
		CBusOperator op1 = (CBusOperator) o1;
		CBusOperator op2 = (CBusOperator) o2;
		if (op1.getOperatorId() < op2.getOperatorId())
			return 1;
		if (op1.getOperatorId() > op2.getOperatorId())
			return -1;
		return 0;
	}
}
