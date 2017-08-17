package com.polaris.teamd.bean;

public class CTripSeat {
	private CTrip trip = new CTrip();
	private int seatNumber;
	private String passengerName = new String(),
			seatOccupationGender = new String();
	private boolean isSeatAvailable, isBookingCompleted;
	private CReservation reservation = new CReservation();

	public CTripSeat() {
		super();
	}

	public CTripSeat(int seatNumber, String passengerName,
			String seatOccupationGender, boolean isSeatAvailable,
			boolean isBookingCompleted) {
		super();
		// this.trip = trip;
		this.seatNumber = seatNumber;
		this.passengerName = passengerName;
		this.seatOccupationGender = seatOccupationGender;
		this.isSeatAvailable = isSeatAvailable;

		this.isBookingCompleted = isBookingCompleted;
		// this.reservation = reservation;
	}

	public CTrip getTrip() {
		return trip;
	}

	public void setTrip(CTrip trip) {
		this.trip = trip;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSeatOccupationGender() {
		return seatOccupationGender;
	}

	public void setSeatOccupationGender(String seatOccupationGender) {
		this.seatOccupationGender = seatOccupationGender;
	}

	public boolean isSeatAvailable() {
		return isSeatAvailable;
	}

	public void setSeatAvailable(boolean isSeatAvailable) {
		this.isSeatAvailable = isSeatAvailable;
	}

	public boolean isBookingCompleted() {
		return isBookingCompleted;
	}

	public void setBookingCompleted(boolean isBookingCompleted) {
		this.isBookingCompleted = isBookingCompleted;
	}

	public CReservation getReservation() {
		return reservation;
	}

	public void setReservation(CReservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "TripSeat [ seatNumber=" + seatNumber + ", passengerName="
				+ passengerName + ", seatOccupationGender="
				+ seatOccupationGender + ", isSeatAvailable=" + isSeatAvailable
				+ ",isBookingCompleted=" + isBookingCompleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seatNumber;
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
		CTripSeat other = (CTripSeat) obj;
		if (seatNumber != other.seatNumber)
			return false;
		return true;
	}

}
