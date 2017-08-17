package com.polaris.teamd.common.validations;

public interface CValidator {
	boolean cValidate();
	CValidMessage getMessage();
	String getErrorMessage();
}
