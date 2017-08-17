package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author gowtham
 *
 *This interface contains methods which can be performed on the Trip Class
 */
public interface CTripDAO {
	boolean cCreateTrip(CBusService busService, Date date) throws Exception;

	boolean cCreateTrip(CBusService busService, Date fromdate, Date toDate)
			throws Exception;

	boolean cUpdateTrip(CBusService busService) throws Exception;

	boolean cDeleteTrip(CBusService busService) throws Exception;

	Collection<CTrip> cGetTripsForDate(CBusService busService, Date date) throws Exception;
	
	Collection<CTrip> cGetTripsForDate(CBusService busService, Date date,
			Comparator obj) throws Exception;
	
	Collection<CTrip> cGetAllTrips();
	
	
	CTrip cFindTrip(CTrip trip) throws Exception;

	CTrip cFindTrip(CBusService busService, Date date) throws Exception;
	
}
