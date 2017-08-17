package com.polaris.teamd.common.validations;

import java.util.Date;

public class CDateValueRangeValidator implements CDateValidator {
	Date data;
	Date minDate;
	Date maxDate;
	CDateValueRangeValidatorMessage dateValueRangeValidatorMessage;

	public CDateValueRangeValidator() {
		super();
		dateValueRangeValidatorMessage = new CDateValueRangeValidatorMessage();
	}
	public void setFieldNameMessage(String fieldname){
		dateValueRangeValidatorMessage.setFieldName(fieldname);
		}
	public void setMaxValueMessage(Date maxDate){
		dateValueRangeValidatorMessage.setMaxDate(maxDate);
		
		}
	public void setMinValueMessage(Date minDate){
		dateValueRangeValidatorMessage.setMinDate(minDate);
		
		}
	
	@Override
	public boolean cValidate() {
		if (data.after(minDate) && data.before(maxDate))
			return true;
		return false;
	}

	@Override
	public void cSetdate(Date date) {
		this.data = date;
	}

	@Override
	public CValidMessage getMessage() {
		return dateValueRangeValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return dateValueRangeValidatorMessage.getMessage();
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
	
	

}
