package com.polaris.teamd.common.validations;

public class CStringMinLengthValidator implements CStringValidator{
	String data;
	int minimumLength;
	CStringMinLengthValidatorMessage stringMinLengthValidatorMessage;
	public CStringMinLengthValidator() {
		super();
		stringMinLengthValidatorMessage=new CStringMinLengthValidatorMessage();
	}

	public CStringMinLengthValidator(String data, int minimumLength,
			CStringMinLengthValidatorMessage stringMinLengthValidatorMessage) {
		super();
		this.data = data;
		this.minimumLength = minimumLength;
		this.stringMinLengthValidatorMessage = stringMinLengthValidatorMessage;
	}

	public int getMinimumLength() {
		return minimumLength;
	}

	public void setMinimumLength(int minimumLength) {
		this.minimumLength = minimumLength;
	}
	public void setFieldNameMessage(String fieldname){
		stringMinLengthValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(int minValue){
		stringMinLengthValidatorMessage.setMinimumLength(minValue);
		}
	@Override
	public boolean cValidate() {
		if(data.length()>minimumLength)
		return true;
		else
			return false;
	}

	@Override
	public void cSetString(String data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return stringMinLengthValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return stringMinLengthValidatorMessage.getMessage();
	}

}
