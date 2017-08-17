package com.polaris.teamd.common.validations;

public class CIntMinimunValueValidator implements CIntValidator{
	int data;
	int minimumDataValue;
	CIntMinimumValueValidatorMessage intMinimumvalueValidatorMessage;
	public CIntMinimunValueValidator() {
		super();
		intMinimumvalueValidatorMessage=new CIntMinimumValueValidatorMessage();
	}

	public int getMinimumDataValue() {
		return minimumDataValue;
	}

	public void setMinimumDataValue(int minimumDataValue) {
		this.minimumDataValue = minimumDataValue;
	}
	public void setFieldNameMessage(String fieldname){
		intMinimumvalueValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(int minValue){
		intMinimumvalueValidatorMessage.setMinValue(minValue);
		}
	@Override
	public boolean cValidate() {
		if(data>minimumDataValue)
			return true;
		return false;
	}

	@Override
	public void cSetInt(int data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		
		return intMinimumvalueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return intMinimumvalueValidatorMessage.getMessage();
	}

}
