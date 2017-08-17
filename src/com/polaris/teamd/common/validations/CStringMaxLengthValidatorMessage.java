package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CStringMaxLengthValidatorMessage implements CValidMessage{
String fieldName;
int maximumLength;
public CStringMaxLengthValidatorMessage() {
	super();
}
public CStringMaxLengthValidatorMessage(String fieldName, int maximumLength) {
	super();
	this.fieldName = fieldName;
	this.maximumLength = maximumLength;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public int getMaximumLength() {
	return maximumLength;
}
public void setMaximumLength(int maximumLength) {
	this.maximumLength = maximumLength;
}

public String toString() {
	return "CStringMaxLengthValidatorMessage [fieldName=" + fieldName
			+ ", maximumLength=" + maximumLength + "]";
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
		
		if(sb.toString().equals(sb1.toString())){
		
			StringBuffer errorMessage=new StringBuffer( messages[i]);
			
		StringBuffer str1=new StringBuffer(	errorMessage.toString().replaceAll("FIELDNAME", getFieldName()));
			StringBuffer str2=new StringBuffer(str1.toString().replaceAll("MAXVALUE", getMaximumLength()+""));
			return str2.toString();
		}
	}
	return null;
	
}

}
