package com.polaris.teamd.service;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;

public interface CSBusServiceInt {

	void addService(CBusService service);

	void updateService(CBusService service);

	void deleteService(CBusService service);

	CBusService findService(CBusService service);

	Collection<CBusService> getAllServices();

	Collection<CBusService> getAllServices1();

	
	Collection<CBusService> cGetAllBusServices(int startRowIndex, int endRowIndex, String orderField, int orderType);
	
	Collection<CBusService> getServicesByRange(int startIndex, int lastIndex);

	Collection<CBusService> getAllServices(String orderField, int orderType);

	Collection<CTrip> cGetTripsForServices(CBusService object) ;

	Collection<CTrip> cGetTripsForServices(CBusService object,
			String orderField, int orderType) ;

}
