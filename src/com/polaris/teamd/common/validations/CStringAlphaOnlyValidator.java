package com.polaris.teamd.common.validations;

public class CStringAlphaOnlyValidator implements CStringValidator {
	String data;
	CStringAlphaOnlyValidatorMessage stringAlphaOnlyValidatorMessage;
	public CStringAlphaOnlyValidator() {
		super();
		stringAlphaOnlyValidatorMessage=new CStringAlphaOnlyValidatorMessage();
	}

	@Override
	public boolean cValidate() {
		char[] dataCharArray = data.toCharArray();
		for (int i = 0; i < dataCharArray.length; i++) {
			if ((int) dataCharArray[i] >= 65 && (int) dataCharArray[i] <= 90)

				return true;
			if ((int) dataCharArray[i] >= 97 && (int) dataCharArray[i] <= 122)
				return true;
		}
		return false;
	}
	public void setFieldNameMessage(String fieldname){
		stringAlphaOnlyValidatorMessage.setFieldName(fieldname);
		}
	@Override
	public void cSetString(String data) {
		this.data = data;

	}

	@Override
	public CValidMessage getMessage() {
		return stringAlphaOnlyValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return stringAlphaOnlyValidatorMessage.getMessage();
	}

}
