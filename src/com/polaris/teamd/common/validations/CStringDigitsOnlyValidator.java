package com.polaris.teamd.common.validations;

public class CStringDigitsOnlyValidator implements CStringValidator {
	String data;
	CStringDigitsOnlyValidatorMessage stringDigitsOnlyValidatorMessage;
	public CStringDigitsOnlyValidator() {
		super();
		stringDigitsOnlyValidatorMessage=new CStringDigitsOnlyValidatorMessage();
	}

	@Override
	public boolean cValidate() {
		char[] dataCharArray = data.toCharArray();
		for (int i = 0; i < dataCharArray.length; i++) {
			if ((int) dataCharArray[i] >= 48 && (int) dataCharArray[i] <= 57)

				return true;

		}
		return false;

	}
	public void setFieldNameMessage(String fieldname){
		stringDigitsOnlyValidatorMessage.setFieldName(fieldname);
		}
	@Override
	public void cSetString(String data) {
		this.data = data;
	}

	@Override
	public CValidMessage getMessage() {
		return stringDigitsOnlyValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return stringDigitsOnlyValidatorMessage.getMessage();
	}

}
