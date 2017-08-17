package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.Collection;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CWeekDays;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.CWeekDAO;
import com.polaris.teamd.db.DBConnectionManager;

public class CWeekDAOImpl implements CWeekDAO {
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
	public boolean saveWeekDays(CBusService busService) {
		try {
			CWeekDays cWeekDays=busService.getWeekDays();
			cWeekDays.setBusService(busService);
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("insert", cWeekDays, connection);
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
	public boolean deleteWeekDays(CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", busService, connection);
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
	public boolean updateWeekDays(CBusService busService) {
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
	public CWeekDays findWeekDays(CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", busService, connection);
			CSelectQueryExecutor<CBusService> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusService>();
			cSelectQueryExecutor.setConnection(connection);
			return (CWeekDays) cSelectQueryExecutor.executeMultipleResults(cQuery,
					CWeekDays.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection getAllWeekDays() {
		CBusService busService=new CBusService();
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", new CWeekDays(), connection);
			CSelectQueryExecutor<CTrip> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CTrip>();
			CCondition cCondition = new CCondition("busService.serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery, CWeekDays.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

}
