package com.polaris.teamd.db;

import java.util.ArrayList;
import java.util.Date;

public interface CQuery {

	void setId(int id);
	void setQuery(String query);
	String getQuery();
	Date getGeneratedTime();
	Date getExecutedTime();
	void addCriteria(CCondition cCondition);
	void addAndCriteria(CCondition cCondition);
	void addOrCriteria(CCondition cCondition);
	void setQueryType(String queryType);
	void setOrderby(CSortDetails sortDetails);
	ArrayList<CCondition> getCriteria();
	ArrayList<CSortDetails> getOrderBy();
	String getStatementKey();
	void setStatementKey(String statementKey);
}
