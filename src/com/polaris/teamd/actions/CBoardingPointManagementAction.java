package com.polaris.teamd.actions;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.admin.CBoardingPointManagement;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CSingleSelectList;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectListInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
import com.polaris.teamd.ui.CUIFactory;

public class CBoardingPointManagementAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel =  new CBoardingPointManagement();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Boarding Point Management Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		final CForm cForm=new CUIFactory().createForm("resources/forms/boardingpoint/cboardingpoint.properties");
		new CUIFactory().setFormUI(cForm);	
	
		cForm.renderFlowLayout();
//		cForm.setBorder(BorderFactory.createLineBorder(Color.orange));
		
		CComboInputPanel comboInputPanel=(CComboInputPanel) cForm.getInputPanel(0);
		comboInputPanel.cRenderFlowLayout();
		
		CActionPanel actionPanel=(CActionPanel) cForm.getInputPanel(1);
		actionPanel.cRender();
		
//		CSingleSelectListInputPanel selectListInputPanel=(CSingleSelectListInputPanel) cForm.getInputPanel(2);
//		selectListInputPanel.cRenderFlowLayout();
		
		
		
		CButton viewButton=actionPanel.getButtonAt(1);	
		viewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			System.out.println("button clicked");
			CTextInputPanel cTextInputPanel=(CTextInputPanel) cForm.getInputPanel(3);
			cTextInputPanel.cRenderFlowLayout();
			CActionPanel actionPanel1=(CActionPanel) cForm.getInputPanel(4);
			actionPanel1.cRender();
				
			}
		});
		
	
	

		
//		cForm.renderGridBagLayout();
		
		
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();
		
		target.add(cForm);
		target.invalidate();
		target.validate();
		
		
		
	}

}
