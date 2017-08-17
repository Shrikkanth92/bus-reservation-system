package com.polaris.teamd.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CTripSeat;
import com.polaris.teamd.bean.CWeekDays;
import com.polaris.teamd.bean.utils.CBusOperatorContactPersonAscending;
import com.polaris.teamd.bean.utils.CBusOperatorContactPersonDescending;
import com.polaris.teamd.bean.utils.CBusOperatorEmailIdAscending;
import com.polaris.teamd.bean.utils.CBusOperatorEmailIdDescending;
import com.polaris.teamd.bean.utils.CBusOperatorHasServiceFirstFalse;
import com.polaris.teamd.bean.utils.CBusOperatorHasServiceFirstTrue;
import com.polaris.teamd.bean.utils.CBusOperatorOfficeAddressAscending;
import com.polaris.teamd.bean.utils.CBusOperatorOfficeAddressDescending;
import com.polaris.teamd.bean.utils.CBusOperatorOperatorIdAscending;
import com.polaris.teamd.bean.utils.CBusOperatorOperatorIdDescending;
import com.polaris.teamd.bean.utils.CBusOperatorOperatorNameAscending;
import com.polaris.teamd.bean.utils.CBusOperatorOperatorNameDescending;
import com.polaris.teamd.bean.utils.CBusOperatorPhoneNumber1Ascending;
import com.polaris.teamd.bean.utils.CBusOperatorPhoneNumber1Descending;
import com.polaris.teamd.bean.utils.CBusOperatorPhoneNumber2Ascending;
import com.polaris.teamd.bean.utils.CBusOperatorPhoneNumber2Descending;
import com.polaris.teamd.bean.utils.CBusServiceAdultFareAscending;
import com.polaris.teamd.bean.utils.CBusServiceAdultFareDescending;
import com.polaris.teamd.bean.utils.CBusServiceArrivalTimeAscending;
import com.polaris.teamd.bean.utils.CBusServiceArrivalTimeDescending;
import com.polaris.teamd.bean.utils.CBusServiceBookingsUntilDateAscending;
import com.polaris.teamd.bean.utils.CBusServiceBookingsUntilDateDescending;
import com.polaris.teamd.bean.utils.CBusServiceChildFareAscending;
import com.polaris.teamd.bean.utils.CBusServiceChildFareDescending;
import com.polaris.teamd.bean.utils.CBusServiceDepartureTimeAscending;
import com.polaris.teamd.bean.utils.CBusServiceDepartureTimeDescending;
import com.polaris.teamd.bean.utils.CBusServiceHasBookingsFirstFalse;
import com.polaris.teamd.bean.utils.CBusServiceHasBookingsFirstTrue;
import com.polaris.teamd.bean.utils.CBusServiceHasDeleteRequestFirstFalse;
import com.polaris.teamd.bean.utils.CBusServiceHasDeleteRequestFirstTrue;
import com.polaris.teamd.bean.utils.CBusServiceHasModifyRequestFirstFalse;
import com.polaris.teamd.bean.utils.CBusServiceHasModifyRequestFirstTrue;
import com.polaris.teamd.bean.utils.CBusServiceIsIntermediateBookingAllowedFirstFalse;
import com.polaris.teamd.bean.utils.CBusServiceIsIntermediateBookingAllowedFirstTrue;
import com.polaris.teamd.bean.utils.CBusServiceServiceIdAscending;
import com.polaris.teamd.bean.utils.CBusServiceServiceIdDescending;
import com.polaris.teamd.bean.utils.CBusServiceServiceTypeAscending;
import com.polaris.teamd.bean.utils.CBusServiceServiceTypeDescending;
import com.polaris.teamd.bean.utils.CReservationAdultCountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationAdultCountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookedByAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookedByDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookedSeatsCountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookedSeatsCountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookingTimeAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationBookingTimeDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationChildCountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationChildCountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationFemaleCountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationFemaleCountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationIDNumberAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationIDNumberDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationIDTypeAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationIDTypeDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationMaleCountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationMaleCountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationPNRAmountAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationPNRAmountDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationPNRNumberAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationPNRNumberDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationPassengerNameAscendingOrder;
import com.polaris.teamd.bean.utils.CReservationPassengerNameDescendingOrder;
import com.polaris.teamd.bean.utils.CReservationPhoneNo1AscendingOrder;
import com.polaris.teamd.bean.utils.CReservationPhoneNo1DescendingOrder;
import com.polaris.teamd.bean.utils.CReservationPhoneNo2AscendingOrder;
import com.polaris.teamd.bean.utils.CReservationPhoneNo2DescendingOrder;
import com.polaris.teamd.db.impl.CBusOperatorDAOImpl;
import com.polaris.teamd.db.impl.CBusServiceDAOImpl;
import com.polaris.teamd.db.impl.CReservationDAOImpl;

public class CSReservationImpl implements CSReservationInt {
	private boolean status;
	private int start, end, pageSize, currentPage, orderType;
	private CReservation reservation;
	private String orderField;
	private String selectCity;
	private Collection collection= new ArrayList<CBusService>();
	private String operatorName;
	private Date date;
	private CBusService busService;
	
	
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CBusService getBusService() {
		return busService;
	}
	public void setBusService(CBusService busService) {
		this.busService = busService;
		collection.add(getAllReservation(busService));
	}
	
	public void filterFrom(String fromCity) {
		selectCity = fromCity;
		Iterator<CReservation> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getTrip().getBusService().getStartLocation().getCityName().equals(fromCity))
				iterator.remove();
		}
		
	}
	
	public void filterTo(String toCity) {
		selectCity = toCity;
		
		Iterator<CReservation> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getTrip().getBusService().getEndLocation().equalsIgnoreCase(toCity))
				iterator.remove();
		}
		
	}
	
	public void filterPassengerName(String passengerName) {
			
		Iterator<CReservation> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getPassengerName().equalsIgnoreCase(passengerName))
				iterator.remove();
		}
		
	}
	
	public void filterPassengerName(long PNRNumber) {
		
		Iterator<CReservation> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getPNRNumber()!=PNRNumber)
				iterator.remove();
		}
		
	}
	
	
	public void filterBusOperator(String operatorName) {
		this.operatorName = operatorName;
		
		Iterator<CBusService> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getBusOperator().getOperatorName().equalsIgnoreCase(operatorName))
				iterator.remove();
		}

	}
	
//	public void filterBusType(String fromCity, CBusService busService) {
//		selectFromCity = fromCity;
//		collection = new ArrayList<CBusService>();
//		collection.add(getAllReservation(busService));
//		Iterator<CBusService> iterator = collection.iterator();
//		while (iterator.hasNext()) {
//			if (!iterator.next().equals(fromCity))
//				iterator.remove();
//		}
//
//	}
	
	public void filterDate(Date date) {
		this.date = date;
		Iterator<CBusService> iterator = collection.iterator();
		while (iterator.hasNext()) {
			
			if (!iterator.next().equals(date))
				iterator.remove();
		}

	}
	
	
	public String getSelectCity() {
		return selectCity;
	}

	public void setSelectCity(String selectCity) {
		this.selectCity = selectCity;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public CReservation getReservation() {
		return reservation;
	}

	public void setReservation(CReservation reservation) {
		this.reservation = reservation;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	@Override
	public void addReservation(CReservation reservation) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		try {
			status = impl.saveReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateReservation(CReservation reservation) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		try {
			status = impl.updateReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CReservation findReservation(CReservation reservation) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		try {
			this.reservation = impl.findReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.reservation;
	}

	@Override
	public Collection<CReservation> getAllReservations(CTrip cTrip) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservations = new ArrayList<CReservation>();
		try {
			reservations = impl.getAllReservation(cTrip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public Collection<CReservation> getAllReservations(String orderField,
			int orderType) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservation = new ArrayList<CReservation>();
		Comparator<CReservation> comparator = null;
		this.orderField = orderField;
		this.orderType = orderType;
		if (this.orderField.equalsIgnoreCase("adult count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationAdultCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationAdultCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booked by")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookedByAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookedByDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booked seats count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookedSeatsCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookedSeatsCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booking time")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookingTimeAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookingTimeDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("child count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationChildCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationChildCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("female count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationFemaleCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationFemaleCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("id number")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationIDNumberAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationIDNumberDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("id type")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationIDTypeAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationIDTypeDescendingOrder();
		}

		if (this.orderField.equalsIgnoreCase("male count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationMaleCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationMaleCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("passenger name")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPassengerNameAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPassengerNameDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("phone no 1")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPhoneNo1AscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPhoneNo1DescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("phone no 2")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPhoneNo2AscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPhoneNo2DescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("pnr amount")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPNRAmountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPNRAmountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("pnr number")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPNRNumberAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPNRNumberDescendingOrder();
		}
		// comparator=impl.get
		return null;
	}

	@Override
	public Collection<CReservation> getReservationsByRange(int startIndex,
			int lastIndex) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservation = new ArrayList<CReservation>();
		
		return null;
	}

	@Override
	public void deleteReservation(CReservation reservation) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		try {
			status = impl.deleteReservation(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<CReservation> getAllReservation(CTrip cTrip,
			String orderField, int orderType) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservation = new ArrayList<CReservation>();
		Comparator<CReservation> comparator=null;
		if (this.orderField.equalsIgnoreCase("adult count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationAdultCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationAdultCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booked by")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookedByAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookedByDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booked seats count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookedSeatsCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookedSeatsCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("booking time")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationBookingTimeAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationBookingTimeDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("child count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationChildCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationChildCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("female count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationFemaleCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationFemaleCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("id number")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationIDNumberAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationIDNumberDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("id type")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationIDTypeAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationIDTypeDescendingOrder();
		}

		if (this.orderField.equalsIgnoreCase("male count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationMaleCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationMaleCountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("passenger name")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPassengerNameAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPassengerNameDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("phone no 1")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPhoneNo1AscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPhoneNo1DescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("phone no 2")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPhoneNo2AscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPhoneNo2DescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("pnr amount")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPNRAmountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPNRAmountDescendingOrder();
		}
		if (this.orderField.equalsIgnoreCase("pnr number")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CReservationPNRNumberAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CReservationPNRNumberDescendingOrder();
		}
		try {
			reservation = impl.getAllReservation(cTrip, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusService busService) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservationList = new ArrayList<CReservation>();
		try {
			reservationList = impl.getAllReservation(busService);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusService busService,
			String orderField, int orderType) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservationList = new ArrayList<CReservation>();
		Comparator<CBusService> comparator = null;
		this.orderField = orderField;
		this.orderType = orderType;

		if (this.orderField.equalsIgnoreCase("adult fare")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceAdultFareAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceAdultFareDescending();
		}

		if (this.orderField.equalsIgnoreCase("arrival time")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceArrivalTimeAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceArrivalTimeDescending();
		}

		if (this.orderField.equalsIgnoreCase("bookings until date")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceBookingsUntilDateAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceBookingsUntilDateDescending();
		}

		if (this.orderField.equalsIgnoreCase("child fare")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceChildFareAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceChildFareDescending();
		}

		if (this.orderField.equalsIgnoreCase("departure time")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceDepartureTimeAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceDepartureTimeDescending();
		}

		if (this.orderField.equalsIgnoreCase("has bookings")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceHasBookingsFirstFalse();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceHasBookingsFirstTrue();
		}

		if (this.orderField.equalsIgnoreCase("has delete request")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceHasDeleteRequestFirstFalse();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceHasDeleteRequestFirstTrue();
		}

		if (this.orderField.equalsIgnoreCase("has modify request")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceHasModifyRequestFirstFalse();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceHasModifyRequestFirstTrue();
		}

		if (this.orderField.equalsIgnoreCase("is intermediate booking allowed")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceIsIntermediateBookingAllowedFirstFalse();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceIsIntermediateBookingAllowedFirstTrue();
		}

		if (this.orderField.equalsIgnoreCase("service id")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceServiceIdAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceServiceIdDescending();
		}

		if (this.orderField.equalsIgnoreCase("Service type")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusServiceServiceTypeAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusServiceServiceTypeDescending();
		}
		try {
			reservationList = impl.getAllReservation(busService, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservationList;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusOperator busOperator) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservationList = new ArrayList<CReservation>();
		try {
			reservationList = impl.getAllReservation(busOperator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservationList;
	}

	@Override
	public Collection<CReservation> getAllReservation(CBusOperator busOperator,
			String orderField, int orderType) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		Collection<CReservation> reservationList = new ArrayList<CReservation>();
		Comparator<CBusOperator> comparator = null;
		this.orderField = orderField;
		this.orderType = orderType;

		if (this.orderField.equalsIgnoreCase("contact person")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorContactPersonAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorContactPersonDescending();
		}

		if (this.orderField.equalsIgnoreCase("email id")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorEmailIdAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorEmailIdDescending();
		}

		if (this.orderField.equalsIgnoreCase("office address")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorOfficeAddressAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorOfficeAddressDescending();
		}

		if (this.orderField.equalsIgnoreCase("operator id")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorOperatorIdAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorOperatorIdDescending();
		}

		if (this.orderField.equalsIgnoreCase("has service")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorHasServiceFirstFalse();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorHasServiceFirstTrue();
		}

		if (this.orderField.equalsIgnoreCase("operator name")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorOperatorNameAscending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorOperatorNameDescending();
		}

		if (this.orderField.equalsIgnoreCase("Phone number1")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorPhoneNumber1Ascending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorPhoneNumber1Descending();
		}

		if (this.orderField.equalsIgnoreCase("Phone number2")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CBusOperatorPhoneNumber2Ascending();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CBusOperatorPhoneNumber2Descending();
		}
		try {
			reservationList = impl.getAllReservation(busOperator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservationList;

	}

	@Override
	public CReservation findReservation(int PNR) {
		CReservationDAOImpl impl = new CReservationDAOImpl();
		try {
			return impl.findReservation(PNR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Collection<CReservation> getAllReservation1() {
		Collection<CReservation> reservations = new ArrayList<CReservation>();
		CBusOperator busOperator1 = new CBusOperator(115, "Multiway Travels",
				"105,2nd street,Vadepalani,Chennai", "9834758960",
				"8096203798", "multi@gmail.com", "mohit", true);
		ArrayList<CBoardingPoint> boardingPoints=new ArrayList<CBoardingPoint>();
		CBoardingPoint boardingPoint=new CBoardingPoint(11, "perambur","near perambur");
		boardingPoints.add(boardingPoint);
		ArrayList<CIntermediateCity> intermediateCities=new ArrayList<CIntermediateCity>();
		intermediateCities.add(new CIntermediateCity());
		CSourceCity sourceCity=new CSourceCity(121, "Chennai", boardingPoints);
		CWeekDays cWeekDays=new CWeekDays(true, false, true, false, true, true, true);
		
		CBusService service= new CBusService(10012, busOperator1, 1, sourceCity, "Hyderabad", new Date(), new Date(), true, 500.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays);
		
		CTripSeat tripSeat = new CTripSeat(10, "hari", "M", false, true);
		ArrayList<CTripSeat> tripSeats = new ArrayList<CTripSeat>();
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		CTrip cTrip = new CTrip(10101,service,new Date(),tripSeats , 50, 45, 45, 2, 4, 5000.00, true);
		reservations.add(new CReservation(5654645,cTrip , "ASd", "5454545", "54545456", 22, tripSeat, boardingPoint, 10, 12	, 5, 5, "Id", "asd665", 5000, new Date(), "Srikk"));
		reservations.add(new CReservation(5654645,cTrip , "ASd", "5454545", "54545456", 22, tripSeat, boardingPoint, 10, 12	, 5, 5, "Id", "asd665", 5000, new Date(), "Srikk"));
		reservations.add(new CReservation(5654645,cTrip , "ASd", "5454545", "54545456", 22, tripSeat, boardingPoint, 10, 12	, 5, 5, "Id", "asd665", 5000, new Date(), "Srikk"));
		reservations.add(new CReservation(5654645,cTrip , "ASd", "5454545", "54545456", 22, tripSeat, boardingPoint, 10, 12	, 5, 5, "Id", "asd665", 5000, new Date(), "Srikk"));
		reservations.add(new CReservation(5654645,cTrip , "ASd", "5454545", "54545456", 22, tripSeat, boardingPoint, 10, 12	, 5, 5, "Id", "asd665", 5000, new Date(), "Srikk"));
		
		//reservations.add(new CReservation(1920234543, trip, passengerName, phoneNumber1, phoneNumber2, bookedSeatsCount, tripSeats, boardingPoint, adultCount, childCount, maleCount, femaleCount, passengerIdType, passengerIdNumber, PNRAmount, bookingTime, bookedBy))
		return reservations;
	}

}
