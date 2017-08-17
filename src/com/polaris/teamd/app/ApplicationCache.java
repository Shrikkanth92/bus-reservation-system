package com.polaris.teamd.app;

import java.util.HashMap;

import javax.swing.JPanel;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CLogin;
import com.polaris.teamd.bean.CPNRCancellation;
import com.polaris.teamd.bean.CReservation;
import com.polaris.teamd.bean.CSearchBean;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.bean.CTrip;
import com.polaris.teamd.bean.CTripSeat;
import com.polaris.teamd.bean.CWeekDays;

public class ApplicationCache {

	static HashMap<String, Object> appCache = new HashMap<String, Object>();

	static {
		refreshAll();
	}

	public static void refreshAll() {
		appCache.put("Bus Operator", new CBusOperator());
		appCache.put("Bus Service", new CBusService());
		appCache.put("Source City", new CSourceCity());
		appCache.put("Intermediate City", new CIntermediateCity());
		appCache.put("Boarding Point", new CBoardingPoint());
		appCache.put("Trip", new CTrip());
		appCache.put("Reservation", new CReservation());
		appCache.put("Trip Seat", new CTripSeat());
		appCache.put("PNR Cancellation", new CPNRCancellation());
		appCache.put("Week Days", new CWeekDays());
		appCache.put("SEARCH BEAN", new CSearchBean());
		appCache.put("Current Login", new CLogin());
	}

	public static void refresh(String objectKey) {
		appCache.get(objectKey);
	}
	public static void put(String keyName,JPanel panel)
	{
		appCache.put(keyName, panel);
	}
	public static JPanel get(String keyName)
	{
		return (JPanel) appCache.get(keyName);
	}
	
	public static Object getValue(String keyName) {
		return appCache.get(keyName);
	}

}
