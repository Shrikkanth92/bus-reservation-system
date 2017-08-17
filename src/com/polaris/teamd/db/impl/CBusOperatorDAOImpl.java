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
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CBusOperatorDAO;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CBusOperatorDAOImpl implements CBusOperatorDAO {

	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	int check;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
		check = 0;
	}

	@Override
	public boolean cSaveBusOperator(CBusOperator busOperator) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("insert", busOperator,connection);
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
	public boolean cDeleteBusOperator(CBusOperator busOperator) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("operatorId",
					String.valueOf(busOperator.getOperatorId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", busOperator,connection);
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
	public CBusOperator cFindBusOperator(CBusOperator busOperator) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("operatorId",
					String.valueOf(busOperator.getOperatorId()), "=");
			cQuery.addCriteria(cCondition);
			CCondition cCondition1 = new CCondition("softDelete",
					String.valueOf(0), "=");
			cQuery.addAndCriteria(cCondition1);
			cQuery = cQueryGenerator.generateQuery("select", busOperator,connection);
			CSelectQueryExecutor<CBusOperator> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusOperator>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeSingleResult(cQuery,
					CBusOperator.class);

		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public boolean cUpdateBusOperator(CBusOperator busOperator) {

		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("operatorId",
					String.valueOf(busOperator.getOperatorId()), "=");
			System.out.println(busOperator.getOperatorId());
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", busOperator,connection);
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
	public Collection<CBusOperator> cGetAllBusOperators() {
		try {
			CBusOperator cBusOperator = new CBusOperator();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusOperator,connection);
			CSelectQueryExecutor<CBusOperator> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusOperator>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusOperator.class);
		} catch (Exception e) {
			CException cException = new CException(CExceptionTypes.SEVERE,
					new Date(), this.getClass(), e);
			CExceptionHandler cExceptionHandler = new CExceptionHandler();
			cExceptionHandler.handleException(cException);
		}
		return null;
	}

	@Override
	public Collection<CBusOperator> cGetAllBusOperators(Comparator object) {

		try {
			CBusOperator cBusOperator = new CBusOperator();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusOperator,connection);
			CSelectQueryExecutor<CBusOperator> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusOperator>();
			cSelectQueryExecutor.setConnection(connection);
			Collection<CBusOperator> operators = new ArrayList<CBusOperator>();
			operators = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusOperator.class);
			ArrayList<CBusOperator> list = new ArrayList<CBusOperator>(
					operators);
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
	public Collection<CBusOperator> cGetAllBusOperators(int startRowIndex,
			int endRowIndex) throws Exception {
		try {
			CBusOperator cBusOperator = new CBusOperator();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusOperator, connection);
			CSelectQueryExecutor<CBusOperator> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusOperator>();
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
	public Collection<CBusOperator> cGetAllBusOperators(int startRowIndex,
			int endRowIndex, Comparator object) throws Exception {

		try {
			CBusOperator cBusOperator = new CBusOperator();
			cQueryGenerator = new CQueryGenerator(cQuery);
			cQuery = cQueryGenerator.generateQuery("select", cBusOperator, connection);
			CSelectQueryExecutor<CBusOperator> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CBusOperator>();
			cSelectQueryExecutor.setConnection(connection);
			Collection<CBusOperator> operators = new ArrayList<CBusOperator>();
			operators = cSelectQueryExecutor.executeMultipleResults(cQuery,
					CBusOperator.class, startRowIndex, endRowIndex);
			ArrayList<CBusOperator> list = new ArrayList<CBusOperator>(
					operators);
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
	public Collection<CBusService> cGetServicesForOperators(
			CBusOperator busOperator) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("busOperator.operatorId",
					String.valueOf(busOperator.getOperatorId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", new CBusService(), connection);
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
	public Collection<CBusService> cGetServicesForOperators(
			CBusOperator busOperator, Comparator object) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("busOperator.operatorId",
					String.valueOf(busOperator.getOperatorId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("select", new CBusService(), connection);
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

}
