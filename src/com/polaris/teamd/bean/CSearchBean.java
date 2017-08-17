package com.polaris.teamd.bean;

import java.util.Date;

public class CSearchBean {
	private String fromLocation = new String();
	private String toLocation = new String();
	private Date dateOfJourney = new Date();
	private String operatorName = new String();
	private String serviceType = new String();
	private String passengerName = new String();
	private long PNRNumber;
	private String timingRange = new String();

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public long getPNRNumber() {
		return PNRNumber;
	}

	public void setPNRNumber(long pNRNumber) {
		PNRNumber = pNRNumber;
	}

	public String getTimingRange() {
		return timingRange;
	}

	public void setTimingRange(String timingRange) {
		this.timingRange = timingRange;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "CSearchBean [fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", dateOfJourney=" + dateOfJourney
				+ ", operatorName=" + operatorName + ", serviceType="
				+ serviceType + "]";
	}

}
