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
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSourceCity;
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
import com.polaris.teamd.db.CSourceCityDAO;
import com.polaris.teamd.db.DBConnectionManager;

public class CSourceCityDAOImpl implements CSourceCityDAO {
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
	public boolean saveCity(CSourceCity sourceCity) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);

			ArrayList<CBoardingPoint> boardings = sourceCity
					.getBoardingPointList();
			int index = 0;
			for (CBoardingPoint boarding : boardings) {
				System.out.println(boarding);
				sourceCity.setBoardingPoint(boardings.get(index++));
				cQuery = cQueryGenerator.generateQuery("insert", sourceCity, connection);
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
	public boolean updateCity(CSourceCity sourceCity) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("cityId",
					String.valueOf(sourceCity.getCityId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", sourceCity, connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
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
	public boolean deleteCity(CSourceCity sourceCity) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("cityName",
					String.valueOf(sourceCity.getCityName()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", sourceCity, connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
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
	public Collection<CSourceCity> getAllSourceCity() {
		try {
			CSourceCity cSourceCity = new CSourceCity();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cSourceCity, connection);
			CSelectQueryExecutor<CSourceCity> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CSourceCity>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CSourceCity.class);
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CSourceCity> getAllSourceCity(Comparator object) {

		try {
			CSourceCity cSourceCity = new CSourceCity();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cSourceCity, connection);
			CSelectQueryExecutor<CSourceCity> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CSourceCity>();
			Collection<CSourceCity> sourceCities = new ArrayList<CSourceCity>();
			sourceCities = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CSourceCity.class);
			cSelectQueryExecutor.setConnection(connection);
			ArrayList<CSourceCity> list = new ArrayList<CSourceCity>(
					sourceCities);
			Collections.sort(list, object);
			return list;
		} catch (Exception e) {
			CException exception = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			new CExceptionHandler().handleException(exception);
		}
		return null;

	}

}
