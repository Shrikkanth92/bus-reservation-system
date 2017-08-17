package com.polaris.teamd.service;

import com.polaris.teamd.bean.CLogin;

public interface CLoginService {
	boolean authenticate(CLogin cLogin);

}
