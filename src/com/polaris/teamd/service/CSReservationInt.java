package com.polaris.teamd.service;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CTrip;

public interface CSReservationInt {
	void addReservation(CReservation reservation);

	void updateReservation(CReservation reservation);

	void deleteReservation(CReservation reservation);

	CReservation findReservation(CReservation reservation);
	
	Collection<CReservation> getAllReservation(CTrip cTrip,
			String orderField, int orderType);
	
	Collection<CReservation> getAllReservation(CBusService busService);
	
	Collection<CReservation> getAllReservation1();
	
	Collection<CReservation> getAllReservation(CBusService busService,
			String orderField, int orderType);
	
	Collection<CReservation> getAllReservation(CBusOperator busOperator);
	
	
	Collection<CReservation> getAllReservation(CBusOperator busOperator,
			String orderField, int orderType);
	
	CReservation findReservation(int PNR);
			
	Collection<CReservation> getReservationsByRange(int startIndex,
			int lastIndex);

	Collection<CReservation> getAllReservations(CTrip cTrip);

	Collection<CReservation> getAllReservations(String orderField, int orderType);

}
