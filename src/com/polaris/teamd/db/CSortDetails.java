package com.polaris.teamd.db;

public class CSortDetails {
	private int sortPrefix = 0;
	private String propertyName;
	private int sortType;

	public CSortDetails() {
		super();
	}

	public CSortDetails(String propertyName, int sortType) {
		super();
		this.propertyName = propertyName;
		this.sortType = sortType;
	}

	public int getSortPrefix() {
		return sortPrefix;
	}

	public void setSortPrefix(int sortPrefix) {
		this.sortPrefix = sortPrefix;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	@Override
	public String toString() {
		return "SortDetails [sortPrefix=" + sortPrefix + ", propertyName="
				+ propertyName + ", sortType=" + sortType + "]";
	}
}
