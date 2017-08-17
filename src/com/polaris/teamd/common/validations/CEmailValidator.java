package com.polaris.teamd.common.validations;

public class CEmailValidator implements CStringValidator
{
	String data;
	CEmailValidatorMessage emailValidatorMessage;
	public CEmailValidator() {
		super();
		emailValidatorMessage=new CEmailValidatorMessage();
	}

	@Override
	public boolean cValidate() {
		String pattern="*@*.???";
		if(data.matches(pattern))
		return true;
		return false;
	}
	public void setFieldNameMessage(String fieldname){
		emailValidatorMessage.setFieldName(fieldname);
		}
	@Override
	public void cSetString(String data) {
		this.data=data;
	}

	@Override
	public CValidMessage getMessage() {
		return emailValidatorMessage;
	}

	@Override
	public String getErrorMessage() {
		return emailValidatorMessage.getMessage();
	}

}
