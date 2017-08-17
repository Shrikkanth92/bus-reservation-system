package com.polaris.teamd.common.validations;


public class CDoubleMaximumValueValidator implements CDoubleValidator{
	double data;
	double maximumDataValue;
	CDoubleMaximumValueValidatorMessage doubleMaximumValueValidatorMessage;
	public CDoubleMaximumValueValidator() {
		super();
		doubleMaximumValueValidatorMessage=new CDoubleMaximumValueValidatorMessage();
	}

	public double getMinimumDataValue() {
		return maximumDataValue;
	}

	public void setMinimumDataValue(float minimumDataValue) {
		this.maximumDataValue = maximumDataValue;
	}
	public void setFieldNameMessage(String fieldname){
		doubleMaximumValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMaxValueMessage(double maxValue){
		doubleMaximumValueValidatorMessage.setMaxValue(maxValue);
		
		}
	@Override
	public boolean cValidate() {
		if (data < maximumDataValue)
			return true;
		return false;
	}

	@Override
	public void cSetDouble(double data) {
		this.data = data;
	}

	@Override
	public CValidMessage getMessage() {
		return doubleMaximumValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return doubleMaximumValueValidatorMessage.getMessage();
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public double getMaximumDataValue() {
		return maximumDataValue;
	}

	public void setMaximumDataValue(double maximumDataValue) {
		this.maximumDataValue = maximumDataValue;
	}
	
}
