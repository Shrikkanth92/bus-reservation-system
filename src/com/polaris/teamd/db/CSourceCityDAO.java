package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CSourceCity;
/**
 * 
 * @author gowtham
 *
 *This interface contains methods which can be performed on the Source City Class

 */
public interface CSourceCityDAO {

	boolean saveCity(CSourceCity cSourceCity);

	boolean updateCity(CSourceCity cSourceCity);

	boolean deleteCity(CSourceCity cSourceCity);

	Collection<CSourceCity> getAllSourceCity();

	Collection<CSourceCity> getAllSourceCity(Comparator comparator);

}
