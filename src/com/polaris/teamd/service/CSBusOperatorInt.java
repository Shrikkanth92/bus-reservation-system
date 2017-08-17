package com.polaris.teamd.service;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;

public interface CSBusOperatorInt {
	void addOperator(CBusOperator operator);

	void updateOperator(CBusOperator operator);
	
	void deleteOperator(CBusOperator operator);

	CBusOperator findOperator(CBusOperator operator);

	Collection<CBusOperator> getAllOperators();
	
	Collection<CBusOperator> getAllOperators1();
	
	Collection<CBusOperator> getOperatorsByRange(int startIndex, int lastIndex);

	Collection<CBusOperator> getAllOperators(String fieldName, int orderBy);
	
	Collection<CBusService> cGetServicesForOperators(CBusOperator object);
	
	Collection<CBusService> cGetServicesForOperators(CBusOperator object,String fieldName, int orderBy); 

	Collection<CBusOperator> cGetAllBusOperators(int startRowIndex, int endRowIndex,String fieldName, int orderBy );
}
