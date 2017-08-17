package com.polaris.teamd.db;

import java.sql.Connection;
import java.util.Collection;

public interface CSelectQueryExecutor<E> {

	void setConnection(Connection connection);

	void releaseConnection();

	E executeSingleResult(CQuery cQuery, Class class1) throws Exception;

	Collection<E> executeMultipleResults(CQuery cQuery, Class class1) throws Exception;
	
	Collection<E> executeMultipleResults(CQuery cQuery, Class class1,int startIndex, int endIndex) throws Exception;
}

