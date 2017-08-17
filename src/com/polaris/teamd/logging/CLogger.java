package com.polaris.teamd.logging;

import com.polaris.teamd.common.exception.CException;
/**
 * 
 * @author Gowtham
 *
 */
public abstract class CLogger {
	public abstract CException log(CException cException);
}
