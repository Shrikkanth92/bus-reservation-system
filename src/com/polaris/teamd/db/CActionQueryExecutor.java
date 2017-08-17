package com.polaris.teamd.db;

import java.sql.Connection;

public interface CActionQueryExecutor {
	void setConnection(Connection connection);

	void releaseConnection();

	Number execute(CQuery cQuery) throws Exception;
}
