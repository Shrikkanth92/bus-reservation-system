package com.polaris.teamd.common.validations;

import java.util.Date;

public class CDateMinValueValidator implements CDateValidator {
	Date data;
	Date minDate;
	CDateMinValueValidatorMessage dateMinValueValidatorMessage;

	public CDateMinValueValidator() {
		super();
		dateMinValueValidatorMessage = new CDateMinValueValidatorMessage();
	}

	public void setFieldNameMessage(String fieldname){
		dateMinValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMinValueMessage(Date minDate){
		dateMinValueValidatorMessage.setMinDate(minDate);
		
		}
	@Override
	public boolean cValidate() {
		if (data.after(minDate))
			return true;
		return false;
	}

	@Override
	public void cSetdate(Date date) {
		this.data = date;
	}

	@Override
	public CValidMessage getMessage() {
		return dateMinValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return dateMinValueValidatorMessage.getMessage();
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	
}
