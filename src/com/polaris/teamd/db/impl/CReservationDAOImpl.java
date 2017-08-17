package com.polaris.teamd.db.impl;

import java.awt.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CReservationDAO;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CReservationDAOImpl implements CReservationDAO {
	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}

	@Override
	public boolean saveReservation(CReservation reservation) throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		cQuery = cQueryGenerator.generateQuery("insert", reservation, connection);
		return false;
	}

	@Override
	public boolean updateReservation(CReservation reservation) throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		cQuery = cQueryGenerator.generateQuery("update", reservation, connection);
		CCondition cCondition = new CCondition("PNRNumber",
				String.valueOf(reservation.getPNRNumber()), "=");
		cQuery.addCriteria(cCondition);
		CSelectQueryExecutor<CReservation> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CReservation>();
		cSelectQueryExecutor.setConnection(connection);
		return false;
	}

	@Override
	public boolean deleteReservation(CReservation reservation) throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		cQuery = cQueryGenerator.generateQuery("delete", reservation, connection);
		CCondition cCondition = new CCondition("PNRNumber",
				String.valueOf(reservation.getPNRNumber()), "=");
		cQuery.addCriteria(cCondition);
		CSelectQueryExecutor<CReservation> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CReservation>();
		cSelectQueryExecutor.setConnection(connection);
		return false;
	}

	@Override
	public Collection<CReservation> getAllReservation(CTrip cTrip)
			throws Exception {
		
		
		CReservation cReservation=new CReservation();
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("trip.tripId",
				String.valueOf(cTrip.getTripId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CReservation(), connection);
		
		CSelectQueryExecutor<CReservation> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CReservation>();
		Collection<CReservation> reservations=new ArrayList<CReservation>();
		try {
			reservations=cSelectQueryExecutor.executeMultipleResults(cQuery,
					CReservation.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cSelectQueryExecutor.setConnection(connection);
		return reservations	;
	}

	@Override
	public Collection<CReservation> getAllReservation(CTrip cTrip,
			Comparator object) throws Exception {
		CReservation cReservation=new CReservation();
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("trip.tripId",
				String.valueOf(cTrip.getTripId()), "=");

		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CReservation(), connection);
		
		CSelectQueryExecutor<CReservation> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CReservation>();
		Collection<CReservation> reservations=new ArrayList<CReservation>();
		ArrayList<CReservation> list=new ArrayList<CReservation>(reservations);
		try {
			reservations=cSelectQueryExecutor.executeMultipleResults(cQuery,
					CReservation.class);
			Collections.sort(list, object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cSelectQueryExecutor.setConnection(connection);
		return reservations	;
	}

	
	
	
	
	
	
	
	
	@Override
	public Collection<CReservation> getAllReservation(CBusService busService)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusService busService,
			Comparator object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusOperator busOperator)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusOperator busOperator,
			Comparator object) throws Exception {
		return null;
	}

	@Override
	public CReservation findReservation(int PNR) throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("PNRNumber",
				String.valueOf(PNR), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", PNR, connection);
		return null;
	}

	@Override
	public CReservation findReservation(CReservation cReservation)
			throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("PNRNumber",
				String.valueOf(cReservation.getPNRNumber()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", cReservation, connection);
		return null;
	}

}
