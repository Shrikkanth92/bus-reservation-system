package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CIntMaximumValueValidatorMessage implements CValidMessage{
	String fieldName;
	int maxValue;


	

	public CIntMaximumValueValidatorMessage() {
		super();
	}

	public CIntMaximumValueValidatorMessage(String fieldName, int maxValue) {
		super();
		this.fieldName = fieldName;
		this.maxValue = maxValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public String toString() {
		return "CIntMaximumValueValidatorMessage [fieldName=" + fieldName
				+ ", maxValue=" + maxValue + "]";
	}

	@Override
	public String getMessage() {
		PropertyFileProcessing processing =new PropertyFileProcessing();
		processing.setPropertyFile(new File("resources/validations/validations.properties"));
		int countClassName=processing.getIndexedPropertyCount("class");
		int countMessage=processing.getIndexedPropertyCount("message");
		String[] classNames=processing.getIndexedPropertyValues("class");
		String[] messages=processing.getIndexedPropertyValues("message");
		
		for(int i=0;i<countClassName;i++){
			
			StringBuffer sb=new StringBuffer(classNames[i]);
			sb.append("Message");
			StringBuffer sb1=new StringBuffer(this.getClass().toString());
			
			sb1.delete(0, 6);
			
			if(new String(sb).equals(new String(sb1))){
			
				StringBuffer errorMessage=new StringBuffer( messages[i]);
				
			StringBuffer str1=new StringBuffer(	errorMessage.toString().replaceAll("FIELDNAME", getFieldName()));
				StringBuffer str2=new StringBuffer(str1.toString().replaceAll("MAXVALUE", getMaxValue()+""));
				return str2.toString();
			}
		}
		
		return null;
	}

	

}
