package com.polaris.teamd.db;

import com.polaris.teamd.bean.CLogin;

public interface CLoginDAO {
	boolean createLogin(CLogin cLogin);

	boolean deleteLogin(CLogin cLogin);

	boolean updateLogin(CLogin cLogin);

	CLogin findLogin(CLogin cLogin);

}
