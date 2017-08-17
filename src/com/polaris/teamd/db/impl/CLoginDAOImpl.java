package com.polaris.teamd.db.impl;

import java.sql.Connection;

import com.polaris.teamd.bean.CLogin;
import com.polaris.teamd.db.CActionQueryExecutor;
import com.polaris.teamd.db.CActionQueryExecutorImpl;
import com.polaris.teamd.db.CCondition;
import com.polaris.teamd.db.CLoginDAO;
import com.polaris.teamd.db.CQuery;
import com.polaris.teamd.db.CQueryGenerator;
import com.polaris.teamd.db.CQueryImpl;
import com.polaris.teamd.db.CSelectQueryExecutor;
import com.polaris.teamd.db.CSelectQueryExecutorImpl;
import com.polaris.teamd.db.DBConnectionManager;

public class CLoginDAOImpl implements CLoginDAO {
	Connection connection;
	CQuery cQuery;
	CQueryGenerator cQueryGenerator;
	int check;
	{
		cQuery = new CQueryImpl();
		connection = DBConnectionManager.getConnection();
		check = 0;
	}

	@Override
	public boolean createLogin(CLogin cLogin) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			cQuery = cQueryGenerator.generateQuery("insert", cLogin, connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteLogin(CLogin cLogin) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("loginId",
					String.valueOf(cLogin.getLoginId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("delete", cLogin, connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateLogin(CLogin cLogin) {
		try {
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("loginId",
					String.valueOf(cLogin.getLoginId()), "=");
			cQuery.addCriteria(cCondition);
			cQuery = cQueryGenerator.generateQuery("update", cLogin, connection);
			CActionQueryExecutor cActionQueryExecutor = new CActionQueryExecutorImpl();
			cActionQueryExecutor.setConnection(connection);
			check = (Integer) cActionQueryExecutor.execute(cQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check > 0)
			return true;
		else
			return false;
	}

	@Override
	public CLogin findLogin(CLogin cLogin) {

		try {
			cQuery=new CQueryImpl();
			cQueryGenerator = new CQueryGenerator(cQuery);
			CCondition cCondition = new CCondition("loginId",
					String.valueOf(cLogin.getLoginId()), "=");
			cQuery.addCriteria(cCondition);
			CCondition cCondition1 = new CCondition("password",
					String.valueOf(cLogin.getPassword()), "=");
			cQuery.addAndCriteria(cCondition1);
			cQuery = cQueryGenerator.generateQuery("select", cLogin, connection);
			CSelectQueryExecutor<CLogin> cSelectQueryExecutor = new CSelectQueryExecutorImpl<CLogin>();
			cSelectQueryExecutor.setConnection(connection);
			return cSelectQueryExecutor.executeSingleResult(cQuery,
					CLogin.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
