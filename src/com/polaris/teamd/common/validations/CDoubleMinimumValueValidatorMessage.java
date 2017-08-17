package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CDoubleMinimumValueValidatorMessage implements CValidMessage {
String fieldName;
double minValue;
public CDoubleMinimumValueValidatorMessage() {
	super();
}
public CDoubleMinimumValueValidatorMessage(String fieldName, double minValue) {
	super();
	this.fieldName = fieldName;
	this.minValue = minValue;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public double getMinValue() {
	return minValue;
}
public void setMinValue(double minValue) {
	this.minValue = minValue;
}

public String toString() {
	return "CDoubleMinimumValueValidatorMessage [fieldName=" + fieldName
			+ ", minValue=" + minValue + "]";
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
			
			String str=errorMessage.toString().replaceAll("FIELDNAME", getFieldName());
			StringBuffer str2=new StringBuffer(str);
			StringBuffer str3=new StringBuffer(str2.toString().replaceAll("MINVALUE",getMinValue()+""));
			 return str3.toString();
		}
	}
	return null;
}

}
