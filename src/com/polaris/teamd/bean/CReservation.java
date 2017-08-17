package com.polaris.teamd.bean;

import java.util.Date;

public class CReservation {
	private long PNRNumber;
	private CTrip trip = new CTrip();
	private String passengerName = new String(), phoneNumber1 = new String(),
			phoneNumber2 = new String();
	private int bookedSeatsCount;
	private CTripSeat reservedSeats ;
	private CBoardingPoint boardingPoint = new CBoardingPoint();
	private int adultCount, childCount, maleCount, femaleCount;
	private String passengerIdType = new String(),
			passengerIdNumber = new String();
	private double PNRAmount;
	private Date bookingTime = new Date();
	private String bookedBy = new String();

	public CReservation() {
		super();
	}

	public CReservation(long PNRNumber, CTrip trip, String passengerName,
			String phoneNumber1, String phoneNumber2, int bookedSeatsCount,
			CTripSeat tripSeats, CBoardingPoint boardingPoint, int adultCount,
			int childCount, int maleCount, int femaleCount,
			String passengerIdType, String passengerIdNumber, double PNRAmount,
			Date bookingTime, String bookedBy) {
		super();
		this.PNRNumber = PNRNumber;
		this.trip = trip;
		this.passengerName = passengerName;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.bookedSeatsCount = bookedSeatsCount;
		this.reservedSeats = tripSeats;
		this.boardingPoint = boardingPoint;
		this.adultCount = adultCount;
		this.childCount = childCount;
		this.maleCount = maleCount;
		this.femaleCount = femaleCount;
		this.passengerIdType = passengerIdType;
		this.passengerIdNumber = passengerIdNumber;
		this.PNRAmount = PNRAmount;
		this.bookingTime = bookingTime;
		this.bookedBy = bookedBy;
	}

	public long getPNRNumber() {
		return PNRNumber;
	}

	public void setPNRNumber(long PNRNumber) {
		this.PNRNumber = PNRNumber;
	}

	public CTrip getTrip() {
		return trip;
	}

	public void setTrip(CTrip trip) {
		this.trip = trip;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public int getBookedSeatsCount() {
		return bookedSeatsCount;
	}

	public void setBookedSeatsCount(int bookedSeatsCount) {
		this.bookedSeatsCount = bookedSeatsCount;
	}

	public CTripSeat getTripSeats() {
		return reservedSeats;
	}

	public void setTripSeats(CTripSeat tripSeats) {
		this.reservedSeats = tripSeats;
	}

	public CBoardingPoint getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(CBoardingPoint boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getMaleCount() {
		return maleCount;
	}

	public void setMaleCount(int maleCount) {
		this.maleCount = maleCount;
	}

	public int getFemaleCount() {
		return femaleCount;
	}

	public void setFemaleCount(int femaleCount) {
		this.femaleCount = femaleCount;
	}

	public String getPassengerIdType() {
		return passengerIdType;
	}

	public void setPassengerIdType(String passengerIdType) {
		this.passengerIdType = passengerIdType;
	}

	public String getPassengerIdNumber() {
		return passengerIdNumber;
	}

	public void setPassengerIdNumber(String passengerIdNumber) {
		this.passengerIdNumber = passengerIdNumber;
	}

	public double getPNRAmount() {
		return PNRAmount;
	}

	public void setPNRAmount(double PNRAmount) {
		this.PNRAmount = PNRAmount;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (PNRNumber ^ (PNRNumber >>> 32));
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
		CReservation other = (CReservation) obj;
		if (PNRNumber != other.PNRNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [PNRNumber=" + PNRNumber + ", trip=" + trip
				+ ", passengerName=" + passengerName + ", phoneNumber1="
				+ phoneNumber1 + ", phoneNumber2=" + phoneNumber2
				+ ", bookedSeatsCount=" + bookedSeatsCount + ", boardingPoint="
				+ boardingPoint + ", adultCount=" + adultCount
				+ ", childCount=" + childCount + ", maleCount=" + maleCount
				+ ", femaleCount=" + femaleCount + ", passengerIdType="
				+ passengerIdType + ", passengerIdNumber=" + passengerIdNumber
				+ ", PNRAmount=" + PNRAmount + ", bookingTime=" + bookingTime
				+ ", bookedBy=" + bookedBy + "]";
	}

}
