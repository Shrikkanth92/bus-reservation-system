package com.polaris.teamd.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
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
import com.polaris.teamd.db.impl.CBusOperatorDAOImpl;

public class CSBusOperatorImpl implements CSBusOperatorInt {
	
	private boolean status;
	private int start, end, pageSize, currentPage, orderType;
	private CBusOperator busOperator;
	private String orderField;
	

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

	public CBusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(CBusOperator busOperator) {
		this.busOperator = busOperator;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	@Override
	public void addOperator(CBusOperator operator) {
		CBusOperatorDAOImpl impl;
		try {
			impl = new CBusOperatorDAOImpl();
			status = impl.cSaveBusOperator(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateOperator(CBusOperator operator) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		try {
			status = impl.cUpdateBusOperator(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public CBusOperator findOperator(CBusOperator operator) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		try {
			busOperator = impl.cFindBusOperator(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busOperator;
	}

	@Override
	public Collection<CBusOperator> getAllOperators() {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusOperator> busOperatorsList = new ArrayList<CBusOperator>();
		try {
			busOperatorsList = impl.cGetAllBusOperators();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busOperatorsList;
	}

	@Override
	public Collection<CBusOperator> getAllOperators(String orderField,
			int orderType) {
		Comparator<CBusOperator> comparator=null;
		this.orderField = orderField;
		this.orderType = orderType;
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusOperator> busOperatorsList = new ArrayList<CBusOperator>();
		
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
		
		if(this.orderField.equalsIgnoreCase("has service"))
		{
			if(this.orderType==OrderingType.ASCENDING)
				comparator = new CBusOperatorHasServiceFirstFalse();
			if(this.orderType==OrderingType.DESCENDING)
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
			busOperatorsList = impl.cGetAllBusOperators(comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return busOperatorsList;
	}

	@Override
	public Collection<CBusOperator> getOperatorsByRange(int startIndex,
			int lastIndex) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusOperator> busOperatorsList = new ArrayList<CBusOperator>();
		try {
			busOperatorsList=impl.cGetAllBusOperators(startIndex, lastIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return busOperatorsList;
	}

	@Override
	public void deleteOperator(CBusOperator operator) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		try {
			status = impl.cDeleteBusOperator(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Collection<CBusService> cGetServicesForOperators(CBusOperator operator) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusService> busOperatorsList = new ArrayList<CBusService>();
		try {
			busOperatorsList = impl.cGetServicesForOperators(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busOperatorsList;
	}

	@Override
	public Collection<CBusService> cGetServicesForOperators(
			CBusOperator operator, String fieldName, int orderBy) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusService> busOperatorsList = new ArrayList<CBusService>();
		Comparator<CBusOperator> comparator=null;
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
		
		if(this.orderField.equalsIgnoreCase("has service"))
		{
			if(this.orderType==OrderingType.ASCENDING)
				comparator = new CBusOperatorHasServiceFirstFalse();
			if(this.orderType==OrderingType.DESCENDING)
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
				busOperatorsList=impl.cGetServicesForOperators(operator, comparator);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return busOperatorsList;
	}

	@Override
	public Collection<CBusOperator> cGetAllBusOperators(int startRowIndex,
			int endRowIndex, String fieldName, int orderBy) {
		CBusOperatorDAOImpl impl = new CBusOperatorDAOImpl();
		Collection<CBusOperator> busOperatorsList = new ArrayList<CBusOperator>();
		
		Comparator<CBusOperator> comparator=null;
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
		
		if(this.orderField.equalsIgnoreCase("has service"))
		{
			if(this.orderType==OrderingType.ASCENDING)
				comparator = new CBusOperatorHasServiceFirstFalse();
			if(this.orderType==OrderingType.DESCENDING)
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
			busOperatorsList = impl.cGetAllBusOperators(startRowIndex, endRowIndex, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return busOperatorsList;
	}

	@Override
	public Collection<CBusOperator> getAllOperators1() {
		Collection<CBusOperator> busOperators = new ArrayList<CBusOperator>();
		busOperators.add(new CBusOperator(101,"Raja Travels","vadapalani,chennai","9893432345","7283492323","asdakld@gmail.com","rahul",true));
		busOperators.add(new CBusOperator(102, "praveen Travels", "mylapore,chennai", "9877323452", "8892934234", "asdads@gmail.com", "Arjun",true));
		busOperators.add(new CBusOperator(103, "SRM Travels", "Navalur,Chennai", "9877342321", "8977342342", "sadhjasd@gmail.com", "Suresh", true));
		busOperators.add(new CBusOperator(104,"ABT Travels","Adyar,Chennai","8923498234","7823472343","asdasdf@yahoo.com","Sanjay",false));
		busOperators.add(new CBusOperator(105, "Sharma Travels", "ambattur,chennai", "9877863321", "9799865432", "sfsfad@yahoo.com", "rohit", false));
		return busOperators;
	}

}
