package com.polaris.teamd.bean;

import java.util.ArrayList;

/**
 * 
 * @author Team D
 * 
 *         <b>This is a bean class which has the properties of CSourceCity
 *         Class</b>
 */
public class CSourceCity {
	private int cityId;
	private String cityName = new String();
	private CBoardingPoint boardingPoint = new CBoardingPoint();

	private ArrayList<CBoardingPoint> boardingPointList;

	/**
	 * 
	 * <b>This is a default constructor</b>
	 */
	public CSourceCity() {
		super();
	}

	/**
	 * <b>This is a parameterised constructor </b>
	 * 
	 * @param cityId
	 *            - <i>This parameter holds the City ID of the Source City</i>
	 * @param cityName
	 *            - <i>This parameter holds the City Name of the Source City</i>
	 * @param boardingPointList
	 *            - <i>This parameter holds the Boarding Point Lists of the
	 *            Source City from CBoardingPoint Class</i>
	 */
	public CSourceCity(int cityId, String cityName,
			ArrayList<CBoardingPoint> boardingPointList) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.boardingPointList = boardingPointList;
	}

	/**
	 * 
	 * @return <i> City ID is returned </i>
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * This function is used to set the City ID
	 * 
	 * @param cityId
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * 
	 * @return <i> City Name is returned </i>
	 */
	public String getCityName() {
		return cityName;
	}

	public CBoardingPoint getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(CBoardingPoint boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	/**
	 * This function is used to set the City Name
	 * 
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 
	 * @return <i>Boarding Point List Object is returned </i>
	 */
	public ArrayList<CBoardingPoint> getBoardingPointList() {
		return boardingPointList;
	}

	/**
	 * This function is used to set the Boarding Point List Object
	 * 
	 * @param boardingPointList
	 */
	public void setBoardingPointList(ArrayList<CBoardingPoint> boardingPointList) {
		this.boardingPointList = boardingPointList;
	}

	/**
	 * This method returns the hashcode of the object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cityId;
		return result;
	}

	/**
	 * 
	 * This function compares the IDs of two cities and returns boolean value
	 * true if they are equal and false if they are not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSourceCity other = (CSourceCity) obj;
		if (cityId != other.cityId)
			return false;
		return true;
	}

	/**
	 * 
	 * This method returns the values of the Source City
	 */
	@Override
	public String toString() {
		return "SourceCity [cityId=" + cityId + ", cityName=" + cityName
				+ ", boardingPointList=" + boardingPointList + "]";
	}

}
