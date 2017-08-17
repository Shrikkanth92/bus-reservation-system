package com.polaris.teamd.db;

public class CCondition {
	private int criteriaPrefix;

	private Object propertyName, propertyValue, operator;

	public CCondition() {
		super();
	}

	public CCondition(String propertyName, Object propertyValue, String operator) {
		super();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.operator = operator;
	}

	public int getCriteriaPrefix() {
		return criteriaPrefix;
	}

	public void setCriteriaPrefix(int criteriaPrefix) {
		this.criteriaPrefix = criteriaPrefix;
	}

	public Object getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Object getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "CCondition [criteriaPrefix=" + criteriaPrefix
				+ ", propertyName=" + propertyName + ", propertyValue="
				+ propertyValue + ", operator=" + operator + "]";
	}

}
