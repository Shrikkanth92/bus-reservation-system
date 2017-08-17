package com.polaris.teamd.service;

import java.util.ArrayList;
import java.util.Collection;

import com.polaris.teamd.bean.CBoardingPoint;
import com.polaris.teamd.bean.CSourceCity;
import com.polaris.teamd.db.impl.CSourceCityDAOImpl;

public class CSSourceCityImpl implements CSSourceCityInt{
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public void addSourceCity(CSourceCity cSourceCity) {
		CSourceCityDAOImpl impl = new CSourceCityDAOImpl();
		status = impl.saveCity(cSourceCity);
	}

	@Override
	public void updateCity(CSourceCity cSourceCity) {
		CSourceCityDAOImpl impl = new CSourceCityDAOImpl();
		status = impl.updateCity(cSourceCity);
	}

	@Override
	public void deleteCity(CSourceCity cSourceCity) {
		CSourceCityDAOImpl impl = new CSourceCityDAOImpl();
		status = impl.deleteCity(cSourceCity);
	}

	@Override
	public Collection<CSourceCity> getAllSourceCity() {
		CSourceCityDAOImpl impl = new CSourceCityDAOImpl();
		Collection<CSourceCity> cities = new ArrayList<CSourceCity>(); 
		cities = impl.getAllSourceCity();
		return cities;
	}
	
	public Collection<CSourceCity> getAllSourceCity1()
	{
		Collection<CSourceCity> sourceCities = new ArrayList<CSourceCity>();
		
		ArrayList<CBoardingPoint> boardingPoints= new ArrayList<CBoardingPoint>();
		boardingPoints.add(new CBoardingPoint(101, "Guindy", "Guindy Signal"));
		
		sourceCities.add(new CSourceCity(101, "CHENNAI", boardingPoints));
		sourceCities.add(new CSourceCity(101, "CHENNAI", boardingPoints));
		sourceCities.add(new CSourceCity(101, "CHENNAI", boardingPoints));
		sourceCities.add(new CSourceCity(101, "CHENNAI", boardingPoints));
		sourceCities.add(new CSourceCity(101, "CHENNAI", boardingPoints));
		return sourceCities;
		
	}
}
