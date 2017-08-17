package com.polaris.teamd.bean;

/***
 * 
 * @author Team D
 * 
 *         This is a bean class which has the properties of CBoarding Point
 *         Class
 * 
 */

public class CBoardingPoint {
	private int id;
	private String name = new String();
	private String landMark = new String();

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	/**
	 * 
	 * <b>This is a default constructor for the Class Boarding Point</b>
	 */
	public CBoardingPoint() {
		super();
	}

	/**
	 * 
	 * <b>This is a parameterised Constructor</b>
	 * 
	 * @param id
	 *            - This parameter holds the ID of the Boarding Point
	 * @param name
	 *            - This parameter holds the Boarding Point Name
	 */

	public CBoardingPoint(int id, String name, String landMark) {
		super();
		this.id = id;
		this.name = name;
		this.landMark = landMark;
	}

	/**
	 * This function compares the Boarding point IDs of two boarding points and
	 * returns boolean value true if they are equal and false if they are not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CBoardingPoint other = (CBoardingPoint) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * 
	 * @return <i> This method returns int variable id </i>
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return <i>This method returns name</i>
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the hashcode of the object
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * 
	 * @param id
	 *            <i> - This function is used to set the parameter id </i>
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 *            <i>- This function is to set the String parameter name </i>
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This function returns the Boarding Point Values
	 */
	@Override
	public String toString() {
		return "BoardingPoint [id=" + id + ", name=" + name + "]";
	}

}
