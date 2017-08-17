package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import com.polaris.teamd.common.validations.CValidator;

public class CValidatingListener implements FocusListener {

	ArrayList<CValidator> validatorList = new ArrayList<CValidator>();
	CInputPanel inputPanel = null;
	
	

	public void setInputPanel(CInputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public void addValidator(CValidator cValidator) {
		validatorList.add(cValidator);
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		boolean result=false;
		for (CValidator cValidator : validatorList) {
			result = cValidator.cValidate();
			if(!result)
			{
				inputPanel.cSetErrorMessage(cValidator.getErrorMessage());	
				return;
			}
		}
		
		
		
			
	}
}
