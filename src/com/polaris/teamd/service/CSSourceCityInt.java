package com.polaris.teamd.service;

import java.util.Collection;

import com.polaris.teamd.bean.CSourceCity;

public interface CSSourceCityInt {
	void addSourceCity(CSourceCity cSourceCity);

	void updateCity(CSourceCity cSourceCity);

	void deleteCity(CSourceCity cSourceCity);

	Collection<CSourceCity> getAllSourceCity();
}
