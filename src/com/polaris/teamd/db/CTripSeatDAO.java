package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CTripSeat;
/**
 * 
 * @author gowtham
 *
 *This interface contains methods which can be performed on the TripSeat Class
 */
public interface CTripSeatDAO {
	Collection<CTripSeat> cGetAllSeats(CTrip trip) throws Exception;
	
	Collection<CTripSeat> cGetAllSeats(CTrip trip, Comparator obj)
			throws Exception;

	Collection<CTripSeat> cGetAllSeats(CBusService busService, Date date) throws Exception;
	
	Collection<CTripSeat> cGetAllSeats(CBusService busService, Date date,
			Comparator obj) throws Exception;

	CTripSeat cFindTripSeats(CTrip trip, int seatNumber) throws Exception;

	boolean cUpdateTripSeats(CTripSeat cTripSeat);
}
