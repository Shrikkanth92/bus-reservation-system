package com.polaris.teamd.common.validations;

public class CIntMaximumValueValidator implements CIntValidator {
	int maximumDataValue;
	int data;
	CIntMaximumValueValidatorMessage intMaximumValueValidatorMessage;

	public CIntMaximumValueValidator() {
		super();
		intMaximumValueValidatorMessage = new CIntMaximumValueValidatorMessage();
	}

	public int getMaximumDataValue() {
		return maximumDataValue;
	}

	public void setMaximumDataValue(int maximumDataValue) {
		this.maximumDataValue = maximumDataValue;
	}

	public void setFieldNameMessage(String fieldname) {
		intMaximumValueValidatorMessage.setFieldName(fieldname);
	}

	public void setMaxValueMessage(int maxValue) {
		intMaximumValueValidatorMessage.setMaxValue(maxValue);
	}

	@Override
	public boolean cValidate() {
		if (data < maximumDataValue)
			return true;
		return false;
	}

	@Override
	public void cSetInt(int data) {
		this.data = data;
	}

	@Override
	public CValidMessage getMessage() {
		return intMaximumValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return intMaximumValueValidatorMessage.getMessage();
	}

}
