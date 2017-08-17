package com.polaris.teamd.common.validations;

public class CIntValueRangeValidator implements CIntValidator{
int data;
int minValue,maxValue;
CIntValueRangeValidatorMessage intValueRangeValidatorMessage;
public CIntValueRangeValidator() {
	super();
	intValueRangeValidatorMessage=new CIntValueRangeValidatorMessage();
}

public int getMinValue() {
	return minValue;
}

public void setMinValue(int minValue) {
	this.minValue = minValue;
}

public int getMaxValue() {
	return maxValue;
}

public void setMaxValue(int maxValue) {
	this.maxValue = maxValue;
}
public void setFieldNameMessage(String fieldname){
	intValueRangeValidatorMessage.setFieldName(fieldname);
	}
public void setMinValueMessage(int minValue){
	intValueRangeValidatorMessage.setMinValue(minValue);
	}
public void setMaxValueMessage(int maxValue){
	intValueRangeValidatorMessage.setMaxValue(maxValue);
	}

	@Override
	public boolean cValidate() {
		if(data>minValue && data<maxValue)
		return true;
		return false;
	}

	@Override
	public void cSetInt(int data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return intValueRangeValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return intValueRangeValidatorMessage.getMessage();
	}

}
