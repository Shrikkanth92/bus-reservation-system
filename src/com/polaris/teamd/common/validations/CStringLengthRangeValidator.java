package com.polaris.teamd.common.validations;

import java.awt.MultipleGradientPaint.ColorSpaceType;

public class CStringLengthRangeValidator implements CStringValidator {
	String data;
	int minimumLength,maximumLength;
	CStringLengthRangeValidatorMessage stringLengthRangeValidatorMessage;
	public CStringLengthRangeValidator() {
		super();
		stringLengthRangeValidatorMessage=new CStringLengthRangeValidatorMessage();
	}

	public int getMinimumLength() {
		return minimumLength;
	}

	public void setMinimumLength(int minimumLength) {
		this.minimumLength = minimumLength;
	}

	public int getMaximumLength() {
		return maximumLength;
	}

	public void setMaximumLength(int maximumLength) {
		this.maximumLength = maximumLength;
	}
	public void setFieldNameMessage(String fieldname){
		stringLengthRangeValidatorMessage.setFieldName(fieldname);
		}
	public void setMinvalueMessage(int minValue){
		stringLengthRangeValidatorMessage.setMinValue(minValue);
		}
	public void setMaxValueMessage(int maxValue){
		stringLengthRangeValidatorMessage.setMaxvalue(maxValue);
		}

	@Override
	public boolean cValidate() {
		if(minimumLength<data.length()&&maximumLength>data.length())
		return true;
		return false;
	}

	@Override
	public void cSetString(String data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return stringLengthRangeValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return stringLengthRangeValidatorMessage.getMessage();
	}

}
