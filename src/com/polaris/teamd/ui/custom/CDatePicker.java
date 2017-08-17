package com.polaris.teamd.ui.custom;

import java.util.Date;

import javax.swing.JPanel;

import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public abstract class CDatePicker extends JPanel{
	
	private Date selectedDate;

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	abstract public CTextInputPanel getTargetUI(); 
		
	
	abstract public void setTargetUI(CTextInputPanel targetUI);
		


}
