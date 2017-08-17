package com.polaris.teamd.common.validations;


public class CDoubleValueRangeValidator implements CDoubleValidator {
	double data;
	double minValue, maxValue;
	CDoubleValueRangeValidatorMessage doubleValueRangeValidatorMessage;
	public CDoubleValueRangeValidator() {
		super();
		doubleValueRangeValidatorMessage=new CDoubleValueRangeValidatorMessage();
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public void setFieldNameMessage(String fieldname){
		doubleValueRangeValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(double minValue){
		doubleValueRangeValidatorMessage.setMinValue(minValue);
		
		}
	public void setMaxValueMessage(double maxValue){
		doubleValueRangeValidatorMessage.setMaxValue(maxValue);
		
		}
	@Override
	public boolean cValidate() {
		if (data > minValue && data < maxValue)
			return true;
		return false;
	}

	@Override
	public void cSetDouble(double data) {
		this.data = data;
	}

	@Override
	public CValidMessage getMessage() {
		return doubleValueRangeValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return doubleValueRangeValidatorMessage.getMessage();
	}

}
