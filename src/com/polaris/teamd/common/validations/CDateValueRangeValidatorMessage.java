package com.polaris.teamd.common.validations;

import java.io.File;
import java.util.Date;

import com.polaris.teamd.common.PropertyFileProcessing;

public class CDateValueRangeValidatorMessage implements CValidMessage {
	String fieldName;
	Date minDate;
	Date maxDate;

	public CDateValueRangeValidatorMessage() {
		super();
	}

	public CDateValueRangeValidatorMessage(String fieldName, Date minDate,
			Date maxDate) {
		super();
		this.fieldName = fieldName;
		this.minDate = minDate;
		this.maxDate = maxDate;
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

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public String toString() {
		return "CDateValueRangeValidatorMessage [fieldName=" + fieldName
				+ ", minDate=" + minDate + ", maxDate=" + maxDate + "]";
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

			if (new String(sb).equals(new String(sb1))) {

				StringBuffer errorMessage = new StringBuffer(messages[i]);

				StringBuffer str1 = new StringBuffer(errorMessage.toString()
						.replaceAll("FIELDNAME", getFieldName()));
				StringBuffer str2 = new StringBuffer(str1.toString()
						.replaceAll("MINVALUE", getMinDate() + ""));
				StringBuffer str3 = new StringBuffer(str2.toString()
						.replaceAll("MAXVALUE", getMaxDate() + ""));
				return str3.toString();
			}
		}

		return null;
	}
}
