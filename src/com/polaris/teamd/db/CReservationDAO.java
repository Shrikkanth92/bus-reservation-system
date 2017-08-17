package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author gowtham
 *
 *This interface contains methods which can be performed on the Reservation Class

 */
public interface CReservationDAO {

	boolean saveReservation(CReservation cReservation) throws Exception;

	boolean updateReservation(CReservation cReservation) throws Exception;

	boolean deleteReservation(CReservation cReservation) throws Exception;

	Collection<CReservation> getAllReservation(CTrip cTrip) throws Exception;

	Collection<CReservation> getAllReservation(CTrip cTrip,
			Comparator comparator) throws Exception;

	Collection<CReservation> getAllReservation(CBusService busService)
			throws Exception;

	Collection<CReservation> getAllReservation(CBusService busService,
			Comparator comparator) throws Exception;

	Collection<CReservation> getAllReservation(CBusOperator busOperator)
			throws Exception;

	Collection<CReservation> getAllReservation(CBusOperator busOperator,
			Comparator comparator) throws Exception;

	CReservation findReservation(int PNR)
			throws Exception;

	CReservation findReservation(CReservation cReservation) throws Exception;
}
