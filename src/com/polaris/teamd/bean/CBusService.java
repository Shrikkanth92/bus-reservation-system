package com.polaris.teamd.bean;

import java.util.ArrayList;
import java.util.Date;

public class CBusService {
	private int serviceId;
	private CBusOperator busOperator = new CBusOperator();
	private int serviceType;
	private CSourceCity startLocation = new CSourceCity();
	private String endLocation = new String();
	private Date departureTime = new Date(), arrivalTime = new Date();
	private boolean isIntermediateBookingAllowed;
	private double adultFare, childFare;
	private ArrayList<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
	private ArrayList<CIntermediateCity> intermediateCities = new ArrayList<CIntermediateCity>();
	private boolean hasBookings;
	private Date bookingsUntilDate = new Date();
	private boolean hasDeleteRequest, hasModifyRequest;
	private CWeekDays weekDays = new CWeekDays();

	public CBusService() {
		super();

	}

	
	public CBusService(int serviceId, CBusOperator busOperator,
			int serviceType, CSourceCity startLocation, String endLocation,
			Date departureTime, Date arrivalTime,
			boolean isIntermediateBookingAllowed, double adultFare,
			double childFare, ArrayList<CBoardingPoint> boardingPoints,
			ArrayList<CIntermediateCity> intermediateCities,
			boolean hasBookings, Date bookingsUntilDate,
			boolean hasDeleteRequest, boolean hasModifyRequest,
			CWeekDays weekDays) {
		super();
		this.serviceId = serviceId;
		this.busOperator = busOperator;
		this.serviceType = serviceType;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.isIntermediateBookingAllowed = isIntermediateBookingAllowed;
		this.adultFare = adultFare;
		this.childFare = childFare;
		this.boardingPoints = boardingPoints;
		this.intermediateCities = intermediateCities;
		this.hasBookings = hasBookings;
		this.bookingsUntilDate = bookingsUntilDate;
		this.hasDeleteRequest = hasDeleteRequest;
		this.hasModifyRequest = hasModifyRequest;
		this.weekDays = weekDays;
	}


	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public CBusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(CBusOperator busOperator) {
		this.busOperator = busOperator;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public CSourceCity getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(CSourceCity startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public CWeekDays getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(CWeekDays weekDays) {
		this.weekDays = weekDays;
	}

	public boolean isIntermediateBookingAllowed() {
		return isIntermediateBookingAllowed;
	}

	public void setIntermediateBookingAllowed(
			boolean isIntermediateBookingAllowed) {
		this.isIntermediateBookingAllowed = isIntermediateBookingAllowed;
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

	public ArrayList<CBoardingPoint> getBoardingPoints() {
		return boardingPoints;
	}

	public void setBoardingPoints(ArrayList<CBoardingPoint> boardingPoints) {
		this.boardingPoints = boardingPoints;
	}

	public ArrayList<CIntermediateCity> getIntermediateCities() {
		return intermediateCities;
	}

	public void setIntermediateCities(
			ArrayList<CIntermediateCity> intermediateCities) {
		this.intermediateCities = intermediateCities;
	}

	public boolean isHasBookings() {
		return hasBookings;
	}

	public void setHasBookings(boolean hasBookings) {
		this.hasBookings = hasBookings;
	}

	public Date getBookingsUntilDate() {
		return bookingsUntilDate;
	}

	public void setBookingsUntilDate(Date bookingsUntilDate) {
		this.bookingsUntilDate = bookingsUntilDate;
	}

	public boolean isHasDeleteRequest() {
		return hasDeleteRequest;
	}

	public void setHasDeleteRequest(boolean hasDeleteRequest) {
		this.hasDeleteRequest = hasDeleteRequest;
	}

	public boolean isHasModifyRequest() {
		return hasModifyRequest;
	}

	public void setHasModifyRequest(boolean hasModifyRequest) {
		this.hasModifyRequest = hasModifyRequest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serviceId;
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
		CBusService other = (CBusService) obj;
		if (serviceId != other.serviceId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusService [serviceId=" + serviceId + ", busOperator="
				+ busOperator + ", serviceType=" + serviceType
				+ ", startLocation=" + startLocation + ", endLocation="
				+ endLocation + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime
				+ ", isIntermediateBookingAllowed="
				+ isIntermediateBookingAllowed + ", adultFare=" + adultFare
				+ ", childFare=" + childFare + ", boardingPoints="
				+ boardingPoints + ", intermediateCities=" + intermediateCities
				+ ", hasBookings=" + hasBookings + ", bookingsUntilDate="
				+ bookingsUntilDate + ", hasDeleteRequest=" + hasDeleteRequest
				+ ", hasModifyRequest=" + hasModifyRequest + "]";
	}

}