package com.polaris.teamd.common.validations;

public class CFloatValueRangeValidator implements CFloatValidator{

	float data;
	float minValue, maxValue;
	CFloatValueRangeValidatorMessage floatValueRangeValidatorMessage;
	public CFloatValueRangeValidator() {
		super();
		floatValueRangeValidatorMessage=new CFloatValueRangeValidatorMessage();
	}

	public float getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public void setFieldNameMessage(String fieldname){
		floatValueRangeValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(float minValue){
		floatValueRangeValidatorMessage.setMinValue(minValue);
		
		}
	public void setMaxValueMessage(float maxValue){
		floatValueRangeValidatorMessage.setMaxValue(maxValue);
		
		}
	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	
		@Override
		public boolean cValidate() {
			if(data>minValue && data<maxValue)
			return true;
			return false;
		}

		

		@Override
		public void cSetFloat(float data) {
			this.data=data;
		}

		@Override
		public CValidMessage getMessage() {
			
			return floatValueRangeValidatorMessage;
		}

		@Override
		public String getErrorMessage() {
			return floatValueRangeValidatorMessage.getMessage();
		}


}
