package com.polaris.teamd.actions;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.ui.custom.CDatePicker;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.staff.CTicketAvailabilty;
import com.polaris.teamd.ui.custom.*;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CDatePickerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CTicketAvailabilityAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CTicketAvailabilty();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Ticket Availability Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		CForm cForm = new CUIFactory()
				.createForm("resources/forms/ticketavailability/ticketavailability.properties");
		new CUIFactory().setFormUI(cForm);
		
		CTextInputPanel text=(CTextInputPanel)cForm.getInputPanel(0);
		CDatePickerInputPanel date=(CDatePickerInputPanel) cForm.getInputPanel(1);
		date.setTargetUI(text);
		CComboInputPanel comboInputPanel=(CComboInputPanel)cForm.getInputPanel(2);
		comboInputPanel.cRenderFlowLayout();
		CComboInputPanel comboInputPanel1=(CComboInputPanel)cForm.getInputPanel(3);
		comboInputPanel.cRenderFlowLayout();
		CActionPanel actionPanel =(CActionPanel)cForm.getInputPanel(4);
		actionPanel.cRender();
		CComboInputPanel comboInputPanel2=(CComboInputPanel)cForm.getInputPanel(5);
		comboInputPanel2.cRenderFlowLayout();
		CComboInputPanel comboInputPanel3=(CComboInputPanel)cForm.getInputPanel(6);
		comboInputPanel3.cRenderFlowLayout();
		CComboInputPanel comboInputPanel4=(CComboInputPanel)cForm.getInputPanel(7);
		comboInputPanel4.cRenderFlowLayout();
		// // cForm.setPosition(8, 8, 0);
		CFilterTableInputPanel filterTableInputPanel=(CFilterTableInputPanel) cForm.getInputPanel(8);
		filterTableInputPanel.setLabelString("search");
		filterTableInputPanel.setInputWidth(10);
		filterTableInputPanel.setTableWidth(500);
		filterTableInputPanel.setTableHeight(250);
		filterTableInputPanel.setButtonString("search");
		filterTableInputPanel.setButtonWidth(100);
		filterTableInputPanel.cRenderFlowLayout();
		// cForm.cSetSize(0,1000,100); cForm.cSetSize(1,100,10);
		/*
		 * cForm.cSetSize(2,100,10); cForm.cSetSize(3,100,10);
		 * cForm.cSetSize(4,100,10); cForm.cSetSize(5,100,10);
		 * cForm.cSetSize(6,100,10); cForm.cSetSize(7,100,10);
		 */
		// cForm.cSetSize(8,100,10);

		cForm.renderGridBagLayout();
		// cForm.renderFlowLayout();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();
		target.add(cForm);
		target.invalidate();
		target.validate();

	}
}
