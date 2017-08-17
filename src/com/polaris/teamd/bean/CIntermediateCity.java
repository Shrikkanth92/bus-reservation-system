package com.polaris.teamd.bean;

import java.util.Date;

public class CIntermediateCity {
	private int id;
	private CBusService busService = new CBusService();
	private String cityName = new String();
	private Date arrivalTime = new Date();
	private double adultFare, childFare;
	private boolean hasBookings;

	public CIntermediateCity() {
		super();
	}

	public CIntermediateCity(int id, CBusService busService, String cityName,
			Date arrivalTime, double adultFare, double childFare,
			boolean hasBookings) {
		super();
		this.id = id;
		this.busService = busService;
		this.cityName = cityName;
		this.arrivalTime = arrivalTime;
		this.adultFare = adultFare;
		this.childFare = childFare;
		this.hasBookings = hasBookings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CBusService getBusService() {
		return busService;
	}

	public void setBusService(CBusService busService) {
		this.busService = busService;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getAdultFare() {
		return adultFare;
	}

	public void setAdultFare(double adultFare) {
		this.adultFare = adultFare;
	}

	public double getChildFare() {
		return childFare;
	}

	public void setChildFare(double childFare) {
		this.childFare = childFare;
	}

	public boolean isHasBookings() {
		return hasBookings;
	}

	public void setHasBookings(boolean hasBookings) {
		this.hasBookings = hasBookings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CIntermediateCity other = (CIntermediateCity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IntermediateCity [id=" + id + ", busService=" + busService
				+ ", cityName=" + cityName + ", arrivalTime=" + arrivalTime
				+ ", adultFare=" + adultFare + ", childFare=" + childFare
				+ ", hasBookings=" + hasBookings + "]";
	}

}
