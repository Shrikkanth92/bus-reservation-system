package com.polaris.teamd.common.validations;

import java.io.File;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CIntMinimumValueValidatorMessage implements CValidMessage {
	String fieldName;
	int minValue;

	public CIntMinimumValueValidatorMessage() {
		super();
	}

	public CIntMinimumValueValidatorMessage(String fieldName, int minValue) {
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

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public String toString() {
		return "CIntMinimumvalueValidatorMessage [fieldName=" + fieldName
				+ ", minValue=" + minValue + "]";
	}

	@Override
	public String getMessage() {
		PropertyFileProcessing processing = new PropertyFileProcessing();
		processing.setPropertyFile(new File(
				"resources/validations/validations.properties"));
		int countClassName = processing.getIndexedPropertyCount("class");
		int countMessage = processing.getIndexedPropertyCount("message");
		String[] classNames = processing.getIndexedPropertyValues("class");
		String[] messages = processing.getIndexedPropertyValues("message");

		for (int i = 0; i < countClassName; i++) {

			StringBuffer sb = new StringBuffer(classNames[i]);
			sb.append("Message");
			StringBuffer sb1 = new StringBuffer(this.getClass().toString());

			sb1.delete(0, 6);
			System.out.println(sb1);
		
			if (new String(sb).equals(new String(sb1))) {
				System.out.println(sb);
				StringBuffer errorMessage = new StringBuffer(messages[i]);

				String str = errorMessage.toString().replaceAll("FIELDNAME",
						this.getFieldName());
				StringBuffer str2 = new StringBuffer(str);
				StringBuffer str3 = new StringBuffer(str2.toString()
						.replaceAll("MINVALUE", this.getMinValue() + ""));
				return str3.toString();
			}
		}
		return null;
	}

}
