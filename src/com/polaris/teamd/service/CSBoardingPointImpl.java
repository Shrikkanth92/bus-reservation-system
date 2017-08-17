package com.polaris.teamd.service;

import java.util.ArrayList;
import java.util.Collection;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.db.impl.CBoardingPointDAOImpl;

public class CSBoardingPointImpl implements CSBoardingPointInt {

	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public void addBoardingPoint(CBoardingPoint boardingPoint,
			CBusService busService) {
		CBoardingPointDAOImpl impl = new CBoardingPointDAOImpl();
		try {
			status = impl.cSaveBoardingPoint(boardingPoint, busService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoardingPoint(CBoardingPoint boardingPoint,
			CBusService busService) {
		CBoardingPointDAOImpl impl = new CBoardingPointDAOImpl();
		try {
			status = impl.cRemoveBoardingPoint(boardingPoint, busService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoardingPoint(CBoardingPoint boardingPoint,
			CBusService busService) {
		CBoardingPointDAOImpl impl = new CBoardingPointDAOImpl();
		try {
			status = impl.cModifyBoardingPoint(boardingPoint, busService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<CBoardingPoint> getAllBoardingPoints() {
		CBoardingPointDAOImpl impl = new CBoardingPointDAOImpl();
		Collection<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
		try {
			boardingPoints = impl.cGetAllBoardingPoints();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardingPoints;
	}

	@Override
	public Collection<CBoardingPoint> getAllBoardingPoints(CSourceCity city) {
		CBoardingPointDAOImpl impl = new CBoardingPointDAOImpl();
		Collection<CBoardingPoint> boardingPoints = new ArrayList<CBoardingPoint>();
		try {
			boardingPoints = impl.cGetAllBoardingPoints(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardingPoints;
	}
	
	public Collection<CBoardingPoint> getAllBoardingPoints1()
	{
		Collection<CBoardingPoint> boardingPoints= new ArrayList<CBoardingPoint>();
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		
		return boardingPoints;
		
	}
}
