package com.polaris.teamd.common.validations;

public class CFloatMinimumValueValidator implements CFloatValidator{
	float data;
	float minimumDataValue;
	CFloatMinimumValueValidatorMessage floatMinimumValueValidatorMessage;
	public CFloatMinimumValueValidator() {
		super();
		floatMinimumValueValidatorMessage=new CFloatMinimumValueValidatorMessage();
	}

	public float getMinimumDataValue() {
		return minimumDataValue;
	}

	public void setMinimumDataValue(float minimumDataValue) {
		this.minimumDataValue = minimumDataValue;
	}
	public void setFieldNameMessage(String fieldname){
		floatMinimumValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(float minValue){
		floatMinimumValueValidatorMessage.setMinValue(minValue);
		}
	@Override
	public boolean cValidate() {
		if(data>minimumDataValue)
			return true;
		return false;
	}

	@Override
	public void cSetFloat(float data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return floatMinimumValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return floatMinimumValueValidatorMessage.getMessage();
	}

}
