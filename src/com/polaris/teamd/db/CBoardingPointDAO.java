package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CSourceCity;

/**
 * 
 * @author nireesha
 * 
 *         This interface contains methods which can be performed on the
 *         Boarding Point Class
 */
public interface CBoardingPointDAO {

	boolean cSaveBoardingPoint(CBoardingPoint cBoardingPoint) throws Exception;

	boolean cSaveBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) throws Exception;

	boolean cRemoveBoardingPoint(CBoardingPoint cBoardingPoint)
			throws Exception;

	boolean cRemoveBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) throws Exception;

	boolean cModifyBoardingPoint(CBoardingPoint cBoardingPoint)
			throws Exception;

	boolean cModifyBoardingPoint(CBoardingPoint cBoardingPoint,
			CBusService busService) throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints() throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints(Comparator comparator)
			throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints(CSourceCity cSourceCity)
			throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints(CSourceCity cSourceCity,
			Comparator comparator) throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints(CBusService cBusService)
			throws Exception;

	Collection<CBoardingPoint> cGetAllBoardingPoints(CBusService cBusService,
			Comparator comparator) throws Exception;

}
