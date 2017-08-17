package com.polaris.teamd.app;

import java.sql.Statement;
import java.util.HashMap;

public class JDBCCache {

	static HashMap<String, Statement> jdbcStatementCache = new HashMap<String, Statement>();

	static {

	}

	public static void addToCache(String stringKey, Statement statement) {

		jdbcStatementCache.put(stringKey, statement);
	}
}
