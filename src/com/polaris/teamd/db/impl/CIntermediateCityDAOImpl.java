package com.polaris.teamd.db.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CIntermediateCityDAO;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CIntermediateCityDAOImpl implements CIntermediateCityDAO {
	Connection connection;
	CQueryGenerator cQueryGenerator;
	CQuery cQuery;
	int check;
	{
		check=0;
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
	}


	@Override
	public boolean cSaveIntermediateCity(CIntermediateCity intermediateCity)
		{
		try{
		cQueryGenerator = new CQueryGenerator(cQuery);
		cQuery = cQueryGenerator.generateQuery("insert", intermediateCity, connection);
		CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
		cActionQueryExecutor.setConnection(connection);
		check=(Integer) cActionQueryExecutor.execute(cQuery);
		}
		catch(Exception e){
			CException exception=new CException(CExceptionTypes.SEVERE, new Date(),this.getClass(),e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cDeleteIntermediateCity(CIntermediateCity intermediateCity){
		try{
			
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("serviceId",
				String.valueOf(intermediateCity.getId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("delete", intermediateCity, connection);
		CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
		cActionQueryExecutor.setConnection(connection);
		check=(Integer) cActionQueryExecutor.execute(cQuery);
		}
		catch(Exception e){
			CException exception=new CException(CExceptionTypes.SEVERE, new Date(),this.getClass(),e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean cUpdateIntermediateCity(CIntermediateCity intermediateCity)
			 {
		try{
			
		
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("id",
				String.valueOf(intermediateCity.getId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("update", intermediateCity, connection);
		CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
		cActionQueryExecutor.setConnection(connection);
		check=(Integer) cActionQueryExecutor.execute(cQuery);
		}
		catch(Exception e){
			CException exception=new CException(CExceptionTypes.SEVERE, new Date(),this.getClass(),e);
			new CExceptionHandler().handleException(exception);
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public Collection<CIntermediateCity> cGetIntermediateCities(
			CBusService busService){
		try{
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("busService.serviceId",
				String.valueOf(busService.getServiceId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CIntermediateCity(), connection);
		
		CSelectQueryExecutor<CIntermediateCity> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CIntermediateCity>();

		cSelectQueryExecutor.setConnection(connection);
		return cSelectQueryExecutor.executeMultipleResults(cQuery,
				CIntermediateCity.class);
		}
		catch(Exception e){
			CException exception=new CException(CExceptionTypes.SEVERE, new Date(),this.getClass(),e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
	}

	@Override
	public Collection<CIntermediateCity> cGetIntermediateCities(
			CBusService busService, Comparator object)  {
		try{
		cQueryGenerator = new CQueryGenerator(cQuery);
		CCondition cCondition = new CCondition("busService.serviceId",
				String.valueOf(busService.getServiceId()), "=");
		cQuery.addCriteria(cCondition);
		cQuery = cQueryGenerator.generateQuery("select", new CIntermediateCity(), connection);
		
		CSelectQueryExecutor<CIntermediateCity> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CIntermediateCity>();

		cSelectQueryExecutor.setConnection(connection);
		Collection<CIntermediateCity> cities=new ArrayList<CIntermediateCity>();
		cities=cSelectQueryExecutor.executeMultipleResults(cQuery,
				CIntermediateCity.class);
		ArrayList<CIntermediateCity> list=new ArrayList<CIntermediateCity>(cities);
		return list;
		}
		catch(Exception e){
			CException exception=new CException(CExceptionTypes.SEVERE, new Date(),this.getClass(),e);
			new CExceptionHandler().handleException(exception);
		}
		return null;
		
		
	}

}
