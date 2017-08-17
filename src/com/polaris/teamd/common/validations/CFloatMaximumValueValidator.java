package com.polaris.teamd.common.validations;

public class CFloatMaximumValueValidator implements CFloatValidator{
	float maximumDataValue;
	float data;
	CFloatMaximumValueValidatorMessage floatMaximumValueValidatorMessage;
	public CFloatMaximumValueValidator() {
		super();
		floatMaximumValueValidatorMessage=new CFloatMaximumValueValidatorMessage();
	}

	public float getMaximumDataValue() {
		return maximumDataValue;
	}

	public void setMaximumDataValue(float maximumDataValue) {
		this.maximumDataValue = maximumDataValue;
	}
	public void setFieldNameMessage(String fieldname){
		floatMaximumValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMaxValueMessage(float maxValue){
		floatMaximumValueValidatorMessage.setMaxValue(maxValue);
		
		}
	@Override
	public boolean cValidate() {
		if(data<maximumDataValue)
			return true;
		return false;
		
	}

	@Override
	public void cSetFloat(float data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return floatMaximumValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return floatMaximumValueValidatorMessage.getMessage();
	}

}
