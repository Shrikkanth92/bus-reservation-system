package com.polaris.teamd.common.validations;


public class CDoubleMinimumValueValidator implements CDoubleValidator {
	double data;
	double minimumDataValue;
CDoubleMinimumValueValidatorMessage doubleMinimumValueValidatorMessage;
	public CDoubleMinimumValueValidator() {
	super();
	doubleMinimumValueValidatorMessage=new CDoubleMinimumValueValidatorMessage();
}

	public double getMinimumDataValue() {
		return minimumDataValue;
	}

	public void setMinimumDataValue(float minimumDataValue) {
		this.minimumDataValue = minimumDataValue;
	}
	public void setFieldNameMessage(String fieldname){
		doubleMinimumValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(double minValue){
		doubleMinimumValueValidatorMessage.setMinValue(minValue);
		
		}
	@Override
	public boolean cValidate() {
		if (data > minimumDataValue)
			return true;
		return false;
	}

	@Override
	public void cSetDouble(double data) {
		this.data = data;
	}

	@Override
	public CValidMessage getMessage() {
		return doubleMinimumValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return doubleMinimumValueValidatorMessage.getMessage();
	}

	public void setMinimumDataValue(double minimumDataValue) {
		this.minimumDataValue = minimumDataValue;
	}
	
	
}
