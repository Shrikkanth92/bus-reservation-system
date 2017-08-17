package com.polaris.teamd.service;

import java.util.Collection;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CSourceCity;

public interface CSBoardingPointInt {
	

	void addBoardingPoint(CBoardingPoint boardingPoint, CBusService busService);

	
	void deleteBoardingPoint(CBoardingPoint boardingPoint,
			CBusService busService);


	void updateBoardingPoint(CBoardingPoint boardingPoint,
			CBusService busService);

	Collection<CBoardingPoint> getAllBoardingPoints();

	Collection<CBoardingPoint> getAllBoardingPoints(CSourceCity city);

}
