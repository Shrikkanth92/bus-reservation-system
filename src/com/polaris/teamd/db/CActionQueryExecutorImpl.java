package com.polaris.teamd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CActionQueryExecutorImpl implements CActionQueryExecutor {
	Connection connection;
	
	@Override
	public void setConnection(Connection connection) {
		this.connection=connection;
	}

	@Override
	public void releaseConnection() {

	}

	@Override
	public Number execute(CQuery cQuery) throws Exception {
		String statementKey=cQuery.getStatementKey();
		PreparedStatement statement=JDBCStatementCache.statementCache.get(statementKey);
		return statement.executeUpdate();
	}

}
