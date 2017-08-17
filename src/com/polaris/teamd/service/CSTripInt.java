package com.polaris.teamd.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;

public interface CSTripInt {
	void cCreateTrip(CBusService busService, Date date) ;

	void cCreateTrip(CBusService busService, Date fromdate, Date toDate);

	void cUpdateTrip(CBusService busService);

	void cDeleteTrip(CBusService busService);

	Collection<CTrip> cGetTripsForDate(CBusService busService, Date date);
	
	Collection<CTrip> cGetAllTrips();
	
	Collection<CTrip> cGetAllTrips1();
	
	CTrip cFindTrip(CTrip trip);

	CTrip cFindTrip(CBusService busService, Date date) ;

	Collection<CTrip> cGetTripsForDate(CBusService busService, Date date,
			String orderField, int orderType);
}
