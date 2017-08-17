package com.polaris.teamd.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
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
import com.polaris.teamd.bean.utils.CTripBookedSeatCountAscendingOrder;
import com.polaris.teamd.bean.utils.CTripBookedSeatCountDescendingOrder;
import com.polaris.teamd.bean.utils.CTripBookingsCountAscendingOrder;
import com.polaris.teamd.bean.utils.CTripBookingsCountDescendingOrder;
import com.polaris.teamd.bean.utils.CTripCancelledBookingCountAscendingOrder;
import com.polaris.teamd.bean.utils.CTripCancelledBookingCountDescendingOrder;
import com.polaris.teamd.bean.utils.CTripCancelledSeatCountAscendingOrder;
import com.polaris.teamd.bean.utils.CTripCancelledSeatCountDescendingOrder;
import com.polaris.teamd.bean.utils.CTripIsTripActiveFalseOrder;
import com.polaris.teamd.bean.utils.CTripIsTripActiveTrueOrder;
import com.polaris.teamd.db.CTripDAO;
import com.polaris.teamd.db.impl.CTripDAOImpl;

public class CSTripImpl implements CSTripInt {
	private boolean status;
	private int start, end, pageSize, currentPage, orderType;
	private CTrip trip;
	private String orderField;
	private Collection<CTrip> cTrips;
	
	
	@Override
	public void cCreateTrip(CBusService busService, Date date) {
		CTripDAOImpl impl=new CTripDAOImpl();
		try {
			status=impl.cCreateTrip(busService, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void cCreateTrip(CBusService busService, Date fromdate, Date toDate) {
		CTripDAOImpl impl=new CTripDAOImpl();
		try {
			status=impl.cCreateTrip(busService, fromdate, toDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void cUpdateTrip(CBusService busService) {
		CTripDAOImpl impl=new CTripDAOImpl();
		try {
			status=impl.cUpdateTrip(busService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cDeleteTrip(CBusService busService) {
		CTripDAOImpl impl=new CTripDAOImpl();
	try {
		status=	impl.cDeleteTrip(busService);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public Collection<CTrip> cGetTripsForDate(CBusService busService, Date date) {
		CTripDAOImpl impl=new CTripDAOImpl();
		Collection <CTrip> tripList=new ArrayList<CTrip>();
		try {
			tripList=impl.cGetTripsForDate(busService, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tripList;
	}

	@Override
	public Collection<CTrip> cGetTripsForDate(CBusService busService,
			Date date,String orderField,int orderType) {
		CTripDAOImpl impl=new CTripDAOImpl();
		Collection <CTrip> tripList=new ArrayList<CTrip>();
		Comparator<CBusOperator> comparator=null;
		this.orderField = orderField;
		this.orderType = orderType;

		if (this.orderField.equalsIgnoreCase("Booked seat count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CTripBookedSeatCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CTripBookedSeatCountDescendingOrder();
		}
		
		if (this.orderField.equalsIgnoreCase("bookings count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new  CTripBookingsCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CTripBookingsCountDescendingOrder();
		}
		
		if (this.orderField.equalsIgnoreCase("cancelled booking count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CTripCancelledBookingCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CTripCancelledBookingCountDescendingOrder();
		}
		
		if (this.orderField.equalsIgnoreCase("cancelled seat count")) {
			if (this.orderType == OrderingType.ASCENDING)
				comparator = new CTripCancelledSeatCountAscendingOrder();
			if (this.orderType == OrderingType.DESCENDING)
				comparator = new CTripCancelledSeatCountDescendingOrder();
		}
		
		if(this.orderField.equalsIgnoreCase("is trip active"))
		{
			if(this.orderType==OrderingType.ASCENDING)
				comparator = new CTripIsTripActiveFalseOrder();
			if(this.orderType==OrderingType.DESCENDING)
				comparator = new CTripIsTripActiveTrueOrder();
		}
		
		
		try {
			tripList=impl.cGetTripsForDate(busService, date,comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tripList;
	}

	@Override
	public CTrip cFindTrip(CTrip trip) {
		CTripDAOImpl impl=new CTripDAOImpl();
		try {
			trip=impl.cFindTrip(trip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trip;
	}

	@Override
	public CTrip cFindTrip(CBusService busService, Date date) {
		CTripDAOImpl impl=new CTripDAOImpl();
		try {
			trip=impl.cFindTrip(busService, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trip;
	}

	@Override
	public Collection<CTrip> cGetAllTrips() {
		CTripDAO impl  = new CTripDAOImpl(); 
		Collection<CTrip> cTrips = new ArrayList<CTrip>();
		cTrips = impl.cGetAllTrips();
		return cTrips;
	}

	@Override
	public Collection<CTrip> cGetAllTrips1() {
		Collection<CTrip> trips = new ArrayList<CTrip>();
		ArrayList<CBoardingPoint> boardingPoints=new ArrayList<CBoardingPoint>();
		boardingPoints.add(new CBoardingPoint(11, "perambur","near perambur"));
		ArrayList<CIntermediateCity> intermediateCities=new ArrayList<CIntermediateCity>();
		intermediateCities.add(new CIntermediateCity());
		intermediateCities.add(new CIntermediateCity());
		CBusOperator busOperator1 = new CBusOperator(115, "Multiway Travels",
				"105,2nd street,Vadepalani,Chennai", "9834758960",
				"8096203798", "multi@gmail.com", "mohit", true);
		CWeekDays cWeekDays=new CWeekDays(true, false, true, false, true, true, true);
		CSourceCity sourceCity=new CSourceCity(121, "Chennai", boardingPoints);
		CTripSeat tripSeat = new CTripSeat(10, "hari", "M", false, true);
		ArrayList<CTripSeat> tripSeats = new ArrayList<CTripSeat>();
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		tripSeats.add(tripSeat);
		CBusService busService = new CBusService(10012, busOperator1, 1, sourceCity, "Hyderabad", new Date(), new Date(), true, 500.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays);
		trips.add(new CTrip(10001,busService,new Date(),tripSeats,50,30,40,5,10,20000,true));
		trips.add(new CTrip(10001,busService,new Date(),tripSeats,50,30,40,5,10,20000,true));
		trips.add(new CTrip(10001,busService,new Date(),tripSeats,50,30,40,5,10,20000,true));
		trips.add(new CTrip(10001,busService,new Date(),tripSeats,50,30,40,5,10,20000,true));
		trips.add(new CTrip(10001,busService,new Date(),tripSeats,50,30,40,5,10,20000,true));
		
		return trips;
	}

}
