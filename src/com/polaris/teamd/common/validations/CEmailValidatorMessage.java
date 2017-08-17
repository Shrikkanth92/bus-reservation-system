package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CEmailValidatorMessage implements CValidMessage{
String fieldName;
public CEmailValidatorMessage() {
	super();
}

public CEmailValidatorMessage(String fieldName) {
	super();
	this.fieldName = fieldName;
}

public String getFieldName() {
	return fieldName;
}

public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}


public String toString() {
	return "CEmailValidatorMessage [fieldName=" + fieldName + "]";
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
			
			StringBuffer str1=new StringBuffer(errorMessage.toString().replaceAll("FIELDNAME", getFieldName()));
			
			return str1.toString();
		}
	}
	return null;
}
}
