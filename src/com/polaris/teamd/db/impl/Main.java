package com.polaris.teamd.db.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CTripSeat;
import com.polaris.teamd.bean.utils.CReservationPNRNumberAscendingOrder;

public class Main {

	public static void main(String[] args) {

		CBusOperatorDAOImpl cBusOperatorDAOImpl = new CBusOperatorDAOImpl();
		// CReservationDAOImpl cReservationDAOImpl = new CReservationDAOImpl();
		// CSourceCityDAOImpl cSourceCityDAOImpl = new CSourceCityDAOImpl();

		// CSourceCity cSourceCity = new CSourceCity();
		// cSourceCity.setCityId(101);
		// cSourceCity.setCityName("Chennai");
		// CBoardingPoint cBoardingPoint = new CBoardingPoint();
		// ArrayList<CBoardingPoint> al = new ArrayList<CBoardingPoint>();
		// al.add(new CBoardingPoint(1, "Guindy"));
		// al.add(new CBoardingPoint(2, "Tambaram"));
		// cSourceCity.setBoardingPointList(al);
		//
		// cSourceCityDAOImpl.updateCity(cSourceCity);
		CBusOperator busOperator = new CBusOperator(101, "KPN Travels",
				"Guindy,Chennai", "8292849", "2840280", "kpn@gmail.com",
				"gowtham", true);
		CBusOperator busOperator1 = new CBusOperator(80, "Parveen Travels",
				"Guindy,Chennai", "8292849", "2840280", "kpn@gmail.com",
				"gowtham", true);
		try {
			cBusOperatorDAOImpl.cUpdateBusOperator(busOperator);
			cBusOperatorDAOImpl.cUpdateBusOperator(busOperator1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CReservation cReservation = new CReservation(1234455954, new CTrip(),
		// "hujefh", "8292849", "2840280", 12, new CTripSeat(),
		// new CBoardingPoint(), 9, 3, 7, 5, "licence", "fh485r79h",
		// 5000.00, new Date(), "gowtham");
		// try {
		// cReservationDAOImpl.updateReservation(cReservation);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
