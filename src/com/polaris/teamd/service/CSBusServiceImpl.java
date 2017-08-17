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
import com.polaris.teamd.bean.CWeekDays;
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
import com.polaris.teamd.common.utils.UIDateUtil;
import com.polaris.teamd.db.impl.CBusServiceDAOImpl;

public class CSBusServiceImpl implements CSBusServiceInt {

	private boolean status;
	private int start, end, pageSize, currentPage, orderType;
	private CBusService busService;
	private String orderField;
	private String selectedCity;
	private Collection<CBusService> collection=new ArrayList<CBusService>();

	public void filterFrom(String fromCity) {
		selectedCity = fromCity;
		collection.add((CBusService) getAllServices());
		Iterator<CBusService> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getStartLocation().getCityName().equals(fromCity))
				iterator.remove();
		}
		
	}
	
	public void filterTo(String toCity) {
		selectedCity = toCity;
		collection.add((CBusService) getAllServices());
		Iterator<CBusService> iterator = collection.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getEndLocation().equalsIgnoreCase(toCity))
				iterator.remove();
		}
		
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

	public CBusService getBusService() {
		return busService;
	}

	public void setBusService(CBusService busService) {
		this.busService = busService;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	@Override
	public void addService(CBusService service) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		try {
			status = impl.cSaveBusService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateService(CBusService service) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		try {
			status = impl.cUpdateBusService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CBusService findService(CBusService service) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		try {
			busService = impl.cFindBusService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busService;
	}

	@Override
	public Collection<CBusService> getAllServices() {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CBusService> busServices = new ArrayList<CBusService>();
		try {
			busServices = impl.cGetAllBusServices();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return busServices;
	}

	@Override
	public Collection<CBusService> getAllServices(String orderField,
			int orderType) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CBusService> busServices = new ArrayList<CBusService>();
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
			busServices = impl.cGetAllBusServices(comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return busServices;
	}

	@Override
	public Collection<CBusService> getServicesByRange(int startIndex,
			int lastIndex) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CBusService> busServices = new ArrayList<CBusService>();
		busServices = impl.cGetAllBusServices(startIndex, lastIndex);
		return busServices;
	}

	@Override
	public void deleteService(CBusService service) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		try {
			status = impl.cDeleteBusService(service);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Collection<CTrip> cGetTripsForServices(CBusService service) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CTrip> busServicesList = new ArrayList<CTrip>();
		try {
			busServicesList = impl.cGetTripsForServices(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busServicesList;
	}

	@Override
	public Collection<CTrip> cGetTripsForServices(CBusService service,
			String orderField, int orderType) {

		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CTrip> busServicesList = new ArrayList<CTrip>();
		Comparator comparator = null;
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
			busServicesList = impl.cGetTripsForServices(service, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busServicesList;

	}

	@Override
	public Collection<CBusService> cGetAllBusServices(int startRowIndex,
			int endRowIndex, String orderField, int orderType) {
		CBusServiceDAOImpl impl = new CBusServiceDAOImpl();
		Collection<CBusService> busServices = new ArrayList<CBusService>();
		Comparator<CBusService> comparator=null;
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
		busServices = impl.cGetAllBusServices(startRowIndex, endRowIndex, comparator);
		return busServices;
	}

	@Override
	public Collection<CBusService> getAllServices1() {
		Collection<CBusService> busServices = new ArrayList<CBusService>();
		Collection<CBusOperator> busOperators = new ArrayList<CBusOperator>();	
		busOperators.add(new CBusOperator(101,"Raja Travels","vadapalani,chennai","9893432345","7283492323","asdakld@gmail.com","rahul",true));		
		CBusOperator busOperator1 = new CBusOperator(115, "Multiway Travels",
				"105,2nd street,Vadepalani,Chennai", "9834758960",
				"8096203798", "multi@gmail.com", "mohit", true);
		ArrayList<CBoardingPoint> boardingPoints=new ArrayList<CBoardingPoint>();
		boardingPoints.add(new CBoardingPoint(11, "perambur","near perambur"));
		ArrayList<CIntermediateCity> intermediateCities=new ArrayList<CIntermediateCity>();
		intermediateCities.add(new CIntermediateCity());
		intermediateCities.add(new CIntermediateCity());
		CWeekDays cWeekDays=new CWeekDays(true, false, true, false, true, true, true);
		CSourceCity sourceCity=new CSourceCity(121, "Chennai", boardingPoints);
		busServices.add(new CBusService(10012, busOperator1, 1, sourceCity, "Hyderabad", new Date(), new Date(), true, 500.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays));
		busServices.add(new CBusService(10013, busOperator1, 1, sourceCity, "Kanyakumari", new Date(), new Date(), true, 900.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays));
		busServices.add(new CBusService(10014, busOperator1, 1, sourceCity, "madurai", new Date(), new Date(), true, 900.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays));
		busServices.add(new CBusService(10015, busOperator1, 1, sourceCity, "bangalore", new Date(), new Date(), true, 900.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays));
		busServices.add(new CBusService(10016, busOperator1, 1, sourceCity, "Kerala", new Date(), new Date(), true, 900.0, 200.0, boardingPoints, intermediateCities, true, new Date(), false, false,cWeekDays));
		
		return busServices;
	}

	

}
