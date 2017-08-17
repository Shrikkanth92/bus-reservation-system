package com.polaris.teamd.common.validations;

import java.util.Date;

public class CDateMaxValueValidator implements CDateValidator {
	Date data;
	Date maxDate;
	
	CDateMaxValueValidatorMessage dateMaxValueValidatorMessage;
	public CDateMaxValueValidator() {
		super();
		dateMaxValueValidatorMessage=new CDateMaxValueValidatorMessage();
	}
	public void setFieldNameMessage(String fieldname){
		dateMaxValueValidatorMessage.setFieldName(fieldname);
		}
	public void setMaxValueMessage(Date maxDate){
		dateMaxValueValidatorMessage.setMaxDate(maxDate);
		
		}
	@Override
	public boolean cValidate() {
		if(data.before(maxDate))
		return true;
		return false;
	}

	@Override
	public void cSetdate(Date date) {
		this.data=date;
	}

	@Override
	public CValidMessage getMessage() {
		return dateMaxValueValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return dateMaxValueValidatorMessage.getMessage();
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

}
