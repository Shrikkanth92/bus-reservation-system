package com.polaris.teamd.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Team D
 * 
 *         This is a bean class which has the properties of CTrip Class
 */
public class CTrip {
	private int tripId;
	private CBusService busService = new CBusService();
	private Date tripDate = new Date();
	private ArrayList<CTripSeat> tripSeats = new ArrayList<CTripSeat>();
	private int seatCount, bookingsCount, bookedSeatsCount,
			cancelledBookingCount, cancelledSeatCount;
	private double totalBookingAmount;
	private boolean isTripActive;

	/**
	 * 
	 * <b>This is a default constructor</b>
	 */
	public CTrip() {
		super();
	}

	/**
	 * <b>This is a parameterised constructor </b>
	 * 
	 * @param tripId
	 *            - <i>This parameter holds the Trip ID</i>
	 * @param busService
	 *            - <i>This parameter holds the object of the CBusService
	 *            class</i>
	 * @param tripSeat
	 *            - <i>This parameter holds the object of the CTripSeat
	 *            class</i>
	 * @param seatCount
	 *            - <i>This parameter holds the number of seats for the Trip</i>
	 * @param bookingsCount
	 *            - <i>This parameter holds the number of bookings for the
	 *            trip</i>
	 * @param bookedSeatsCount
	 *            - <i>This parameter holds the number of booked seat count for
	 *            the trip</i>
	 * @param cancelledBookingCount
	 *            - <i>This parameter holds the number of cancellations</i>
	 * @param cancelledSeatCount
	 *            - <i>This parameter holds the number of cancelled seats in a
	 *            trip</i>
	 * @param totalBookingAmount
	 *            - <i>This parameter holds the total booking amount for the
	 *            trip</i>
	 * @param isTripActive
	 *            - <i>This parameter holds the value whether the trip is active
	 *            or not</i>
	 */


	/**
	 * 
	 * @return <i> Trip ID object is returned </i>
	 */
	public int getTripId() {
		return tripId;
	}

	public CTrip(int tripId, CBusService busService, Date tripDate,
			ArrayList<CTripSeat> tripSeats, int seatCount, int bookingsCount,
			int bookedSeatsCount, int cancelledBookingCount,
			int cancelledSeatCount, double totalBookingAmount,
			boolean isTripActive) {
		super();
		this.tripId = tripId;
		this.busService = busService;
		this.tripDate = tripDate;
		this.tripSeats = tripSeats;
		this.seatCount = seatCount;
		this.bookingsCount = bookingsCount;
		this.bookedSeatsCount = bookedSeatsCount;
		this.cancelledBookingCount = cancelledBookingCount;
		this.cancelledSeatCount = cancelledSeatCount;
		this.totalBookingAmount = totalBookingAmount;
		this.isTripActive = isTripActive;
	}

	/**
	 * This function is used to set the Trip ID object
	 * 
	 * @param tripId
	 */
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	/**
	 * 
	 * @return <i> Bus Service object is returned </i>
	 */
	public CBusService getBusService() {
		return busService;
	}

	/**
	 * This function is used to set the Bus Service Object
	 * 
	 * @param busService
	 */
	public void setBusService(CBusService busService) {
		this.busService = busService;
	}

	/**
	 * 
	 * @return <i> Trip Seat object is returned </i>
	 */
	

	/**
	 * 
	 * @return <i> Number of Seats count is returned </i>
	 */
	public int getSeatCount() {
		return seatCount;
	}

	public ArrayList<CTripSeat> getTripSeats() {
		return tripSeats;
	}

	public void setTripSeats(ArrayList<CTripSeat> tripSeats) {
		this.tripSeats = tripSeats;
	}

	/**
	 * This function is used to set the Seat count
	 * 
	 * @param seatCount
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	/**
	 * 
	 * @return <i> The number of bookings count is returned </i>
	 */
	public int getBookingsCount() {
		return bookingsCount;
	}

	/**
	 * This function is used to set the Booking Count
	 * 
	 * @param bookingsCount
	 */
	public void setBookingsCount(int bookingsCount) {
		this.bookingsCount = bookingsCount;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	/**
	 * 
	 * @return <i> The number of booked Seat count is returned </i>
	 */
	public int getBookedSeatsCount() {
		return bookedSeatsCount;
	}

	/**
	 * This function is used to set the Booked Seats count
	 * 
	 * @param bookedSeatsCount
	 */
	public void setBookedSeatsCount(int bookedSeatsCount) {
		this.bookedSeatsCount = bookedSeatsCount;
	}

	/**
	 * 
	 * @return <i> The count of the Cancelled bookings is returned </i>
	 */
	public int getCancelledBookingCount() {
		return cancelledBookingCount;
	}

	/**
	 * This function is used to set the number of cancelled bookings
	 * 
	 * @param cancelledBookingCount
	 */
	public void setCancelledBookingCount(int cancelledBookingCount) {
		this.cancelledBookingCount = cancelledBookingCount;
	}

	/**
	 * 
	 * @return <i> The count of the Cancelled Seats is returned </i>
	 */
	public int getCancelledSeatCount() {
		return cancelledSeatCount;
	}

	/**
	 * This function is used to set the cancelled Seat count
	 * 
	 * @param cancelledSeatCount
	 */
	public void setCancelledSeatCount(int cancelledSeatCount) {
		this.cancelledSeatCount = cancelledSeatCount;
	}

	/**
	 * 
	 * @return <i> The value of total Booking Amount is returned </i>
	 */
	public double getTotalBookingAmount() {
		return totalBookingAmount;
	}

	/**
	 * This function is used to set the total booking amount of the reservations
	 * 
	 * @param totalBookingAmount
	 */
	public void setTotalBookingAmount(double totalBookingAmount) {
		this.totalBookingAmount = totalBookingAmount;
	}

	/**
	 * 
	 * @return <i> The boolean value if the trip is active or not returned </i>
	 */
	public boolean isTripActive() {
		return isTripActive;
	}

	/**
	 * This function is used to set the boolean value whether the trip is active
	 * or not
	 * 
	 * @param isTripActive
	 */
	public void setTripActive(boolean isTripActive) {
		this.isTripActive = isTripActive;
	}

	/**
	 * This method returns the hashcode of the object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((busService == null) ? 0 : busService.hashCode());
		result = prime * result + tripId;
		return result;
	}

	/**
	 * 
	 * This function compares the TripIDs of two trips and returns boolean value
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
		CTrip other = (CTrip) obj;
		if (busService == null) {
			if (other.busService != null)
				return false;
		} else if (!busService.equals(other.busService))
			return false;
		if (tripId != other.tripId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CTrip [tripId=" + tripId + ", busService=" + busService
				+ ", tripDate=" + tripDate + ", tripSeats=" + tripSeats
				+ ", seatCount=" + seatCount + ", bookingsCount="
				+ bookingsCount + ", bookedSeatsCount=" + bookedSeatsCount
				+ ", cancelledBookingCount=" + cancelledBookingCount
				+ ", cancelledSeatCount=" + cancelledSeatCount
				+ ", totalBookingAmount=" + totalBookingAmount
				+ ", isTripActive=" + isTripActive + "]";
	}

	/**
	 * This method returns the values of the Trip Class
	 */
	
	
}
