package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CBusServiceDAO;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CBusServiceDAOImpl implements CBusServiceDAO {
	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	int check;
	{
		check = 0;
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}

	@Override
	public boolean cSaveBusService(CBusService busService) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("insert", busService,connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cDeleteBusService(CBusService busService) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", busService,connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public CBusService cFindBusService(CBusService busService) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			CCondition cCondition1 = new CCondition("softDelete",
					String.valueOf(0), "=");
			cQuery.addAndCriteria(cCondition1);
			cQuery = cQueryGenerator.generateQuery("select", busService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeSingleResult(cQuery,
					CBusService.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public boolean cUpdateBusService(CBusService busService) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", busService, connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public Collection<CBusService> cGetAllBusServices() {

		try {
			CBusService cBusService = new CBusService();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();

			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusService.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection<CBusService> cGetAllBusServices(Comparator object) {

		try {
			CBusService cBusService = new CBusService();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();

			cSelectQueryExecutor.setConnection(connection);
			Collection<CBusService> services;
			services = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusService.class);
			ArrayList<CBusService> list = new ArrayList<CBusService>(services);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection<CBusService> cGetAllBusServices(int startRowIndex,
			int endRowIndex) {
		try {
			CBusService cBusService = new CBusService();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();

			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusOperator.class, startRowIndex, endRowIndex);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection<CBusService> cGetAllBusServices(int startRowIndex,
			int endRowIndex, Comparator object) {
		try {
			CBusService cBusService = new CBusService();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();

			cSelectQueryExecutor.setConnection(connection);
			Collection<CBusService> services;
			services = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusOperator.class, startRowIndex, endRowIndex);
			ArrayList<CBusService> list = new ArrayList<CBusService>(services);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection<CTrip> cGetTripsForServices(CBusService busService) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", new CTrip(), connection);
			CSelectQueryExecutor<CTrip> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTrip>();
			CCondition cCondition = new CCondition("busService.serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
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

	@Override
	public Collection<CTrip> cGetTripsForServices(CBusService busService,
			Comparator object) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", new CTrip(), connection);
			CSelectQueryExecutor<CTrip> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTrip>();
			CCondition cCondition = new CCondition("busService.serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cSelectQueryExecutor.setConnection(connection);
			Collection<CTrip> trips;
			trips = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CTrip.class);
			ArrayList<CTrip> list = new ArrayList<CTrip>(trips);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

}
