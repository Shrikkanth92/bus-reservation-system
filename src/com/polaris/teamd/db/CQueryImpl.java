package com.polaris.teamd.db;

import java.util.ArrayList;
import java.util.Date;

public class CQueryImpl implements CQuery {
	private int id;
	private String query, queryType;
	private boolean criteriaFlag, orderByFlag;
	private Date generatedTime, executedTime;
	private ArrayList<CCondition> criteria = new ArrayList<CCondition>();
	private ArrayList<CSortDetails> orderBy = new ArrayList<CSortDetails>();
	private String statementKey; 

	
	public String getStatementKey() {
		return statementKey;
	}

	public void setStatementKey(String statementKey) {
		this.statementKey = statementKey;
	}

	public ArrayList<CCondition> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<CCondition> criteria) {
		this.criteria = criteria;
	}

	public ArrayList<CSortDetails> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(ArrayList<CSortDetails> orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setQuery(String query) {
		this.query = query;
		setGeneratedTime(new Date());
	}

	@Override
	public String getQuery() {
		return this.query;
	}

	@Override
	public Date getGeneratedTime() {

		return this.generatedTime;
	}

	@Override
	public Date getExecutedTime() {

		return this.executedTime;
	}

	public void setGeneratedTime(Date generatedTime) {
		this.generatedTime = generatedTime;
	}

	public void setExecutedTime(Date executedTime) {
		this.executedTime = executedTime;
	}

	@Override
	public void addCriteria(CCondition cCondition) {
		if (criteriaFlag == false) {
			cCondition.setCriteriaPrefix(1);
			criteria.add(cCondition);
			criteriaFlag = true;
		}
	}

	@Override
	public void addAndCriteria(CCondition cCondition) {
		if (criteriaFlag == true) {
			cCondition.setCriteriaPrefix(2);
			criteria.add(cCondition);
		} else
			addCriteria(cCondition);
	}

	@Override
	public void addOrCriteria(CCondition cCondition) {
		if (criteriaFlag == true) {
			cCondition.setCriteriaPrefix(3);
			criteria.add(cCondition);
		} else
			addCriteria(cCondition);
	}

	@Override
	public void setOrderby(CSortDetails sortDetails) {
		if (orderByFlag == false) {
			sortDetails.setSortPrefix(1);
			orderBy.add(0, sortDetails);
			orderByFlag=true;
		} else
			orderBy.add(sortDetails);
	}

	@Override
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getQueryType() {
		return queryType;
	}

	@Override
	public String toString() {
		return "CQueryImpl [query=" + query + ", queryType=" + queryType
				+ ", generatedTime=" + generatedTime + ", executedTime="
				+ executedTime + ", criteria=" + criteria + ", orderBy="
				+ orderBy + "]";
	}

}
