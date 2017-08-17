package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CStringMinLengthValidatorMessage implements CValidMessage{
String fieldName;
int minimumLength;
public CStringMinLengthValidatorMessage() {
	super();
}
public CStringMinLengthValidatorMessage(String fieldName, int minimumLength) {
	super();
	this.fieldName = fieldName;
	this.minimumLength = minimumLength;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public int getMinimumLength() {
	return minimumLength;
}
public void setMinimumLength(int minimumLength) {
	this.minimumLength = minimumLength;
}

public String toString() {
	return "CStringMinLengthValidatorMessage [fieldName=" + fieldName
			+ ", minimumLength=" + minimumLength + "]";
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
			StringBuffer str3=new StringBuffer(str2.toString().replaceAll("MINVALUE",getMinimumLength()+""));
			 return str3.toString();
		}
	}
	return null;
	
}
}
