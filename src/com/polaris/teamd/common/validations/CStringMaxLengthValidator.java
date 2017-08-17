package com.polaris.teamd.common.validations;

public class CStringMaxLengthValidator implements CStringValidator {
	String data;
	int maximumLength;
	CStringMaxLengthValidatorMessage stringMaxLengthValidatorMessage;
	public CStringMaxLengthValidator() {
		super();
		stringMaxLengthValidatorMessage=new CStringMaxLengthValidatorMessage();
	}

	public CStringMaxLengthValidator(String data, int maximumLength,
			CStringMaxLengthValidatorMessage stringMaxLengthValidatorMessage) {
		super();
		this.data = data;
		this.maximumLength = maximumLength;
		this.stringMaxLengthValidatorMessage = stringMaxLengthValidatorMessage;
	}

	public int getMaximumLength() {
		return maximumLength;
	}

	public void setMaximumLength(int maximumLength) {
		this.maximumLength = maximumLength;
	}
	public void setFieldNameMessage(String fieldname){
		stringMaxLengthValidatorMessage.setFieldName(fieldname);
		}
	public void setMaxValueMessage(int maxValue){
		stringMaxLengthValidatorMessage.setMaximumLength(maxValue);
		}
	@Override
	public boolean cValidate() {
		if(data.length()<maximumLength)
		return true;
		return false;
	}

	@Override
	public void cSetString(String data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return stringMaxLengthValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return stringMaxLengthValidatorMessage.getMessage();
	}

}
