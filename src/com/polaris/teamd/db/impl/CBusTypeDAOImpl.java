package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBusType;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CBusTypeDAO;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CBusTypeDAOImpl implements CBusTypeDAO {
	private Connection connection;
	private CQueryGenerator cQueryGenerator;
	private CQuery cQuery;
	int check;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
		check = 0;
	}


	@Override
	public boolean add(CBusType busType) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("insert", busType, connection);
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
	public boolean modify(CBusType busType) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("id",
					String.valueOf(busType.getId()), "=");
			System.out.println(busType.getId());
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", busType, connection);
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
	public boolean delete(CBusType busType) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("id",
					String.valueOf(busType.getId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", busType, connection);
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

}
