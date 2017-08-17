package com.polaris.teamd.common.validations;

import java.io.File;
import java.util.Date;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CDateMinValueValidatorMessage implements CValidMessage {
String fieldName;
Date minDate;
public CDateMinValueValidatorMessage() {
	super();
}
public CDateMinValueValidatorMessage(String fieldName, Date minDate) {
	super();
	this.fieldName = fieldName;
	this.minDate = minDate;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public Date getMinDate() {
	return minDate;
}
public void setMinDate(Date minDate) {
	this.minDate = minDate;
}

public String toString() {
	return "CDateMinValueValidatorMessage [fieldName=" + fieldName
			+ ", minDate=" + minDate + "]";
}
@Override
public String getMessage() {
	PropertyFileProcessing processing =new PropertyFileProcessing();
	processing.setPropertyFile(new File("resources/validations/validations.properties"));
	int countClassName=processing.getIndexedPropertyCount("class");
	
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
			
			StringBuffer str2=new StringBuffer(str.toString().replaceAll("MINVALUE",getMinDate()+""));
			 return str2.toString();
		}
	}
	return null;
}
}
