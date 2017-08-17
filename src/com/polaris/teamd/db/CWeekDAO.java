package com.polaris.teamd.db;

import java.util.Collection;

import com.polaris.teamd.bean.CBusService;
import com.polaris.teamd.bean.CWeekDays;

public interface CWeekDAO {
	boolean saveWeekDays(CBusService service);

	boolean deleteWeekDays(CBusService service);

	boolean updateWeekDays(CBusService service);

	CWeekDays findWeekDays(CBusService service);

	Collection getAllWeekDays();

}
