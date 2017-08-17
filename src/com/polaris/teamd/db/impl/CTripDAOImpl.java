package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.CTripDAO;
import com.polaris.teamd.db.DBConnectionManager;

public class CTripDAOImpl implements CTripDAO {
	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}
	@Override
	public boolean cCreateTrip(CBusService busService, Date date)
			throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		cQuery = cQueryGenerator.generateQuery("insert",
				busService, connection);
	return false;
	}

	@Override
	public boolean cCreateTrip(CBusService busService, Date fromdate,
			Date toDate) throws Exception {

		return false;
	}

//	@Override
//	public boolean cUpdateTrip(CBusService busService) throws Exception {
//		cQueryGenerator = new CQueryGenerator(cQuery);
//		CCondition cCondition = new CCondition("operatorId",
//				String.valueOf(trip.getTripId()), "=");
//		cQuery.addCriteria(cCondition);
//		cQuery = cQueryGenerator.generateQuery(CTrip.class, "update",
//				trip);
//		return false;
//	}
//
//	@Override
//	public boolean cDeleteTrip(CBusService busService) throws Exception {
//		cQueryGenerator = new CQueryGenerator(cQuery);
//		CCondition cCondition1 = new CCondition("TripID",
//				String.valueOf(busService.getServiceId()), "=");
//		cQuery.addCriteria(cCondition1);
//		cQuery = cQueryGenerator.generateQuery(CTrip.class, "delete",
//				busService);
//		return false;
//	}

	@Override
	public Collection<CTrip> cGetTripsForDate(CBusService busService, Date date)
			throws Exception {

		CTrip cReservation=new CTrip();
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("busService.serviceId",
				String.valueOf(busService.getServiceId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CTrip(), connection);
		
		CSelectQueryExecutor<CTrip> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTrip>();
		Collection<CTrip> reservations=new ArrayList<CTrip>();
		try {
			reservations=cSelectQueryExecutor.executeMultipleResults(cQuery,
					CTrip.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cSelectQueryExecutor.setConnection(connection);
		return reservations	;
	}

	@Override
	public Collection<CTrip> cGetTripsForDate(CBusService busService,
			Date date, Comparator object) throws Exception {

		return null;
	}

	@Override
	public CTrip cFindTrip(CTrip trip) throws Exception {
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("operatorId",
				String.valueOf(trip.getTripId()), "=");
		cQuery.addCriteria(cCondition);
//		cQuery = cQueryGenerator.generateQuery(CTrip.class, "select",
//				trip);
		return null;
	}

	@Override
	public CTrip cFindTrip(CBusService busService, Date date) throws Exception {

		return null;
	}

	@Override
	public boolean cUpdateTrip(CBusService busService) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cDeleteTrip(CBusService busService) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<CTrip> cGetAllTrips() {
		try {
			CTrip cTrip = new CTrip();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select",cTrip, connection);
			CSelectQueryExecutor<CTrip> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTrip>();

			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CTrip.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

}
