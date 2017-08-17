package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

import com.polaris.teamd.ui.custom.CDatePicker;
import com.polaris.teamd.ui.custom.CFutureDatePicker;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CPastDatePicker;
import com.polaris.teamd.ui.custom.CSimpleDatePicker;

public class CDatePickerInputPanel extends JPanel {
	CDatePicker datePicker;
	CTextInputPanel targetUI;
	int datePickerPreferences;
	private boolean hideOnSelection;


	public boolean isHideOnSelection() {
		return hideOnSelection;
	}

	public void setHideOnSelection(boolean hideOnSelection) {
		this.hideOnSelection = hideOnSelection;
	}

	public int getDatePickerPreferences() {
		return datePickerPreferences;
	}

	public void setDatePickerPreferences(int datePickerPReferences) {
		this.datePickerPreferences = datePickerPReferences;
	}

	public CDatePicker getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(CDatePicker datePicker) {
		this.datePicker = datePicker;
	}

	public CTextInputPanel getTargetUI() {
		return targetUI;
	}

	public void setTargetUI(CTextInputPanel targetUI) {
		//this.targetUI = targetUI;
		datePicker.setTargetUI(targetUI);
	}

	private void datePickerType() {
		
		if (getDatePickerPreferences() == 1)
			datePicker = new CSimpleDatePicker();
		if (getDatePickerPreferences() == 2)
			datePicker = new CFutureDatePicker();
		if (getDatePickerPreferences() == 3)
			datePicker = new CPastDatePicker();
	}

	public void init() {
		datePickerType();
		
	}
	public void render(){
			
		this.add(datePicker);
		
	}
	public void refresh() {
		this.removeAll();
		init();
		if (!hideOnSelection) {
			render();
		}
	}

}
