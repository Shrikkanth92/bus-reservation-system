package com.polaris.teamd.db;

import com.polaris.teamd.bean.CBusType;

public interface CBusTypeDAO {
	boolean add(CBusType busType);

	boolean modify(CBusType busType);

	boolean delete(CBusType busType);
}
