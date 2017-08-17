package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
/**
 * 
 * @author nireesha
 *
 *This interface contains methods which can be performed on the Bus Operator Class

 */
public interface CBusOperatorDAO {
	boolean cSaveBusOperator(CBusOperator object) throws Exception;
	boolean cDeleteBusOperator(CBusOperator object) throws Exception;
	CBusOperator cFindBusOperator(CBusOperator object) throws Exception;
	boolean cUpdateBusOperator(CBusOperator object) throws Exception;
	
	Collection<CBusOperator> cGetAllBusOperators() throws Exception;
	Collection<CBusOperator> cGetAllBusOperators(Comparator object) throws Exception;
	Collection<CBusOperator> cGetAllBusOperators(int startRowIndex, int endRowIndex) throws Exception;
	Collection<CBusOperator> cGetAllBusOperators(int startRowIndex, int endRowIndex, Comparator object1) throws Exception;
	Collection<CBusService> cGetServicesForOperators(CBusOperator object) throws Exception;
	Collection<CBusService> cGetServicesForOperators(CBusOperator object, Comparator object2) throws Exception;
	
	
	
	
	

}
