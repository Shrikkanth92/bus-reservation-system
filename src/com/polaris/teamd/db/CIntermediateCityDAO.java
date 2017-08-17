package com.polaris.teamd.db;

import java.util.Collection;
import java.util.Comparator;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CIntermediateCity;
import com.polaris.teamd.bean.CTrip;
/**
 * 
 * @author nireesha
 *
 *This interface contains methods which can be performed on the Intermediate Class
 */

public interface CIntermediateCityDAO {

	boolean cSaveIntermediateCity(CIntermediateCity object) throws Exception;

	boolean cDeleteIntermediateCity(CIntermediateCity object) throws Exception;

	boolean cUpdateIntermediateCity(CIntermediateCity object) throws Exception;

	Collection<CIntermediateCity> cGetIntermediateCities(CBusService busService)
			throws Exception;

	Collection<CIntermediateCity> cGetIntermediateCities(
			CBusService busService, Comparator object1) throws Exception;


}
