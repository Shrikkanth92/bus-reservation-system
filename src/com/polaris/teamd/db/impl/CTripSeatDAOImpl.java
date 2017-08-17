package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CTripSeat;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.CTripSeatDAO;
import com.polaris.teamd.db.DBConnectionManager;

public class CTripSeatDAOImpl implements CTripSeatDAO {
	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}

	@Override
	public Collection<CTripSeat> cGetAllSeats(CTrip trip) throws Exception {

		CTripSeat cTripSeat=new CTripSeat();
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("trip.tripId",
				String.valueOf(trip.getTripId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CTripSeat(), connection);
		
		CSelectQueryExecutor<CTripSeat> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTripSeat>();
		Collection<CTripSeat> seats=new ArrayList<CTripSeat>();
		try {
			seats=cSelectQueryExecutor.executeMultipleResults(cQuery,
					CTripSeat.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cSelectQueryExecutor.setConnection(connection);
		return seats	;
	}

	@Override
	public Collection<CTripSeat> cGetAllSeats(CTrip trip, Comparator object)
			throws Exception {

		return null;
	}

	@Override
	public Collection<CTripSeat> cGetAllSeats(CBusService busService, Date date)
			throws Exception {

		return null;
	}

	@Override
	public Collection<CTripSeat> cGetAllSeats(CBusService busService,
			Date date, Comparator object) throws Exception {

		return null;
	}

	@Override
	public CTripSeat cFindTripSeats(CTrip trip, int seatNumber)
			throws Exception {

		return null;
	}

	@Override
	public boolean cUpdateTripSeats(CTripSeat cTripSeat) {
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("seatNumber",
				String.valueOf(cTripSeat.getSeatNumber()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("update", cTripSeat, connection);
		return false;
	}

}
