package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CBoardingPointDAO;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CBoardingPointDAOImpl implements CBoardingPointDAO {
	CQuery cQuery = new CQueryImpl();
	CQueryGenerator cQueryGenerator;
	Connection connection = DBConnectionManager.getConnection();
	int check;
	{
		check = 0;
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}

	@Override
	public boolean cSaveBoardingPoint(CBoardingPoint boardingPoint) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("insert", boardingPoint,connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check += (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}

		return false;
	}

	@Override
	public boolean cRemoveBoardingPoint(CBoardingPoint boardingPoint) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("Id",
					String.valueOf(boardingPoint.getId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", boardingPoint,connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cModifyBoardingPoint(CBoardingPoint boardingPoint) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("Id",
					String.valueOf(boardingPoint.getId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", boardingPoint,connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints() {
		try {
			CBoardingPoint cBoardingPoint = new CBoardingPoint();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBoardingPoint,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBoardingPoint.class);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints(Comparator object) {

		try {
			CBoardingPoint cBoardingPoint = new CBoardingPoint();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBoardingPoint,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			Collection<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
			boardingPoints = cSelectQueryExecutor.executeMultipleResults(
					cQuery, CBoardingPoint.class);
			cSelectQueryExecutor.setConnection(connection);
			ArrayList<CBoardingPoint> list = new ArrayList<CBoardingPoint>(
					boardingPoints);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;

	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints(
			CSourceCity sourceCity) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("cityName",
					String.valueOf(sourceCity.getCityName()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", sourceCity,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBoardingPoint.class);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints(
			CSourceCity sourceCity, Comparator object) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("cityName",
					String.valueOf(sourceCity.getCityName()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", sourceCity,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			Collection<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
			boardingPoints = cSelectQueryExecutor.executeMultipleResults(
					cQuery, CBoardingPoint.class);
			cSelectQueryExecutor.setConnection(connection);
			ArrayList<CBoardingPoint> list = new ArrayList<CBoardingPoint>(
					boardingPoints);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints(
			CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("ServiceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", busService,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBoardingPoint.class);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CBoardingPoint> cGetAllBoardingPoints(
			CBusService busService, Comparator object) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("serviceId",
					String.valueOf(busService.getServiceId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", busService,connection);
			CSelectQueryExecutor<CBoardingPoint> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBoardingPoint>();
			Collection<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
			boardingPoints = cSelectQueryExecutor.executeMultipleResults(
					cQuery, CBoardingPoint.class);
			cSelectQueryExecutor.setConnection(connection);
			ArrayList<CBoardingPoint> list = new ArrayList<CBoardingPoint>(
					boardingPoints);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public boolean cSaveBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);

			ArrayList<CBoardingPoint> boardings = busService
					.getBoardingPoints();
			int index = 0;
			for (CBoardingPoint boarding : boardings) {
				cQuery = cQueryGenerator
						.generateQuery("insert", cBoardingPoint,connection);
				check += (Integer) cActionQueryExecutor.execute(cQuery);
			}

		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cRemoveBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);

			ArrayList<CBoardingPoint> boardings = busService
					.getBoardingPoints();
			int index = 0;
			for (CBoardingPoint boarding : boardings) {
				System.out.println(boarding);

				CCondition cCondition = new CCondition("serviceId",
						String.valueOf(busService.getServiceId()), "=");
				cQuery.addCriteria(cCondition);
				cQuery = cQueryGenerator.generateQuery("delete", busService,connection);
				check = (Integer) cActionQueryExecutor.execute(cQuery);
			}
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cModifyBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);

			ArrayList<CBoardingPoint> boardings = busService
					.getBoardingPoints();
			int index = 0;
			for (CBoardingPoint boarding : boardings) {
				System.out.println(boarding);

				CCondition cCondition = new CCondition("serviceId",
						String.valueOf(busService.getServiceId()), "=");
				cQuery.addCriteria(cCondition);
				cQuery = cQueryGenerator.generateQuery("update", busService,connection);
				check = (Integer) cActionQueryExecutor.execute(cQuery);
			}
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

}
