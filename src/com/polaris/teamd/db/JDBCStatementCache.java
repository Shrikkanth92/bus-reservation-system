package com.polaris.teamd.db;

import java.sql.PreparedStatement;
import java.util.HashMap;

public class JDBCStatementCache {
	static HashMap<String, PreparedStatement> statementCache;
	static {
		statementCache=new HashMap<String, PreparedStatement>();
	}
	
	public static void put(String queryKeyName,PreparedStatement preparedStatement){
		statementCache.put(queryKeyName, preparedStatement);
	}
}
