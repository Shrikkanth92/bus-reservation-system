package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author nireesha
 *
 *This interface contains methods which can be performed on the Bus Service Class

 */
public interface CBusServiceDAO {
	
	boolean cSaveBusService(CBusService object) throws Exception;
	boolean cDeleteBusService(CBusService object) throws Exception;
	CBusService cFindBusService(CBusService object) throws Exception;
	boolean cUpdateBusService(CBusService object) throws Exception;
	
	Collection<CBusService> cGetAllBusServices() throws Exception;
	Collection<CBusService> cGetAllBusServices(Comparator object) throws Exception;
	Collection<CBusService> cGetAllBusServices(int startRowIndex, int endRowIndex) throws Exception;
	Collection<CBusService> cGetAllBusServices(int startRowIndex, int endRowIndex, Comparator object) throws Exception;
	Collection<CTrip> cGetTripsForServices(CBusService object) throws Exception;
	Collection<CTrip> cGetTripsForServices(CBusService object, Comparator object1) throws Exception;

	
	


}
