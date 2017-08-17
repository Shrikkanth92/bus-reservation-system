package com.polaris.teamd.service;

import java.util.Date;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.bean.CLogin;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.common.exception.CLoginException;
import com.polaris.teamd.db.CLoginDAO;
import com.polaris.teamd.db.impl.CLoginDAOImpl;

public class CLoginServiceImpl implements CLoginService {
	static CLogin login;
	static int count;
	static {
		login = ((CLogin) ApplicationCache.getValue("Current Login"));
		count = 0;
		login.setCount(count);
	}

	

	@Override
	public boolean authenticate(CLogin cLogin) {
		// try {
		CLoginDAO impl = new CLoginDAOImpl();
		System.out.println(count);
		
		if (count < 3) {
			login=impl.findLogin(cLogin);
			if (cLogin.equals(login)) {
				
				((CLogin) ApplicationCache.getValue("Current Login")).setUserName(login.getUserName());
				((CLogin) ApplicationCache.getValue("Current Login")).setRoleId(login.getRoleId());
				login.setCount(0);
				return true;
			} else {
				login.setCount(count++);
				return false;
			}
		} else
			try {
				{
					System.out.println("error");
					throw new CLoginException();
				}
			} catch (Exception e) {
				CLoginException cLoginException = new CLoginException(
						CExceptionTypes.SEVERE, new Date(), this.getClass(), e);
				CExceptionHandler cExceptionHandler = new CExceptionHandler();
				cExceptionHandler.handleException(cLoginException);
			}
		return false;
	}
	

}