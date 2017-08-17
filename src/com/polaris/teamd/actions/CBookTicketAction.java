package com.polaris.teamd.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable;
import com.polaris.teamd.ui.custom.CWizard;
import com.polaris.teamd.ui.custom.CWizard1;
import com.polaris.teamd.ui.custom.CWizard1;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CDatePickerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextOutputPanel;
import com.polaris.teamd.ui.staff.CBookTicket;

public class CBookTicketAction extends AbstractAction {

	

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CBookTicket();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Book Ticket Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		CForm cForm = new  CUIFactory().createForm("resources/forms/search services/searchservices.properties");
		CForm cForm1 = new CUIFactory().createForm("resources/forms/seatstatus/seatstatus.properties");
		CForm welcomeForm = new CForm();
		CForm finishForm = new CForm();
		welcomeForm.cInit("Welcome to Ticket Booking Wizard");
		finishForm.cInit("Congratulations!");
		CLabel label= new CLabel("This wizard will help you to book tickets for the customer.");
		CLabel label2= new CLabel("1.Search Services screen is used to search for buses available.");
		CLabel label3= new CLabel("2.Seat Selection screen is used to select the seats required.");
		CLabel label4= new CLabel("3.Confirmation screen is used to check the the passenger details.");
		CLabel label5= new CLabel("4.Ticket Printing screen is used to print the ticket for the passenger.");
		CLabel label6= new CLabel("You have booked tickets successfully");
		
		JPanel  jPanel= new JPanel(new GridLayout(5, 1,10,10));
		JPanel  jPanel2= new JPanel(new BorderLayout(50,10));
		
		label6.setFont(new Font("Arial", Font.BOLD, 25));
		label6.setForeground(Color.darkGray);
				
		jPanel.add(label);
		jPanel.add(label2);
		jPanel.add(label3);
		jPanel.add(label4);
		jPanel.add(label5);
		jPanel2.add(label6,BorderLayout.CENTER);
		
		welcomeForm.cAddInputPanel(jPanel);
		finishForm.cAddInputPanel(jPanel2);
		
		new CUIFactory().setFormUI(welcomeForm);
		new CUIFactory().setFormUI(finishForm);
		
		CWizard wizard= new CWizard(1);
		
		new CUIFactory().setFormUI(cForm);
		
		new CUIFactory().setFormUI(cForm1);
		
//		cForm.setPosition(0, 0, 0);
//		cForm.cSetSize(0, 300, 40);
//		cForm.setPosition(1, 1, 0);
//		cForm.cSetSize(1, 300, 40);
//		cForm.setPosition(2, 2, 0);
//		cForm.cSetSize(2, 300, 40);
//		cForm.setPosition(3, 3, 0);
//		cForm.cSetSize(3, 300, 40);
//		cForm.setPosition(4, 4, 0);
//		cForm.cSetSize(4, 300, 40);
//		cForm.setPosition(5, 5, 0);
//		cForm.cSetSize(5, 300, 40);
//		cForm.setPosition(6, 3, 1);
//		cForm.cSetSize(6, 300, 40);
//		cForm.setPosition(7, 6, 0);
//		cForm.cSetSize(7, 300, 40);
		
		cForm.setPosition(0, 0, 0);
		cForm.cSetSize(0, 300, 70);
		cForm.setPosition(1, 0, 1);
		cForm.cSetSize(1, 300, 70);
		cForm.setPosition(2,0, 2);
	
		cForm.cSetSize(2, 300, 70);
		cForm.setPosition(3, 0, 3);
		cForm.cSetSize(3, 300, 70);
	
		cForm.setPosition(4, 0, 4);
		cForm.cSetSize(4, 300,70);
	
	cForm.setPosition(5, 1, 0);
		cForm.cSetSize(5, 300, 70);
		cForm.setPosition(6, 1, 1);
		cForm.cSetSize(6, 300, 70);
		cForm.setPosition(7, 1, 2);
		cForm.cSetSize(7, 300, 70);
		cForm.setPosition(8, 2, 0);
		cForm.cSetSize(8, 800, 300);
		
		
		CComboInputPanel comboInputPanel= (CComboInputPanel) cForm.getInputPanel(0);
		
		
		
		comboInputPanel.setPreferredSize(new Dimension(comboInputPanel.getWidth(), 50));
		comboInputPanel.setMaximumSize(new Dimension(comboInputPanel.getWidth(), 50));
		comboInputPanel.setSize(new Dimension(comboInputPanel.getWidth(), 50));
		comboInputPanel.cRenderFlowLayout();
		
		System.out.println();
		CComboInputPanel comboInputPanel2= (CComboInputPanel) cForm.getInputPanel(1);
		comboInputPanel2.cRenderFlowLayout();
		CComboInputPanel cComboInputPanel3=(CComboInputPanel) cForm.getInputPanel(2);
		cComboInputPanel3.cRenderFlowLayout();
		CTextInputPanel text=(CTextInputPanel)cForm.getInputPanel(3);
		text.cRenderFlowLayout();
		CDatePickerInputPanel date=(CDatePickerInputPanel) cForm.getInputPanel(4);
		date.setTargetUI(text);
		date.render();
		CSpinnerInputPanel spinnerInputPanel2 = (CSpinnerInputPanel) cForm.getInputPanel(5);
		spinnerInputPanel2.cRenderFlowLayout();
		CComboInputPanel comboInputPanel4= (CComboInputPanel) cForm.getInputPanel(6);
		comboInputPanel4.cRenderFlowLayout();
		 CActionPanel actionPanel =(CActionPanel) cForm.getInputPanel(7);
		 actionPanel.cRender();
		 CSingleSelectInputTablePanel inputTablePanel= (CSingleSelectInputTablePanel) cForm.getInputPanel(8);
		 inputTablePanel.cRenderFlowLayout();
//		 CActionPanel actionPanel1 =(CActionPanel) cForm.getInputPanel(9);
//		 actionPanel1.cRender();
		 
		 cForm1.setPosition(0, 0, 0);
			cForm1.cSetSize(0, 100, 50);
			cForm1.setPosition(1, 1, 0);
			cForm1.cSetSize(1, 100, 50);
			cForm1.setPosition(2,0, 0);
			cForm1.cSetSize(2, 100, 50);
			cForm1.setPosition(3, 1, 0);
			cForm1.cSetSize(3, 100, 50);
			cForm1.setPosition(4, 0, 0);
			cForm1.cSetSize(4, 100, 50);
			cForm1.setPosition(5, 1, 0);
			cForm1.cSetSize(5, 100, 50);
			cForm1.setPosition(6, 0, 0);
			cForm1.cSetSize(6, 500, 300);
			cForm1.setPosition(7, 1, 0);
			cForm1.cSetSize(7, 500, 100);
			cForm1.setPosition(8, 0, 0);
			cForm1.cSetSize(8, 100, 50);
			cForm1.setPosition(8, 1,0);
			cForm1.cSetSize(9, 100, 50);
			cForm1.setPosition(9, 7, 0);
			cForm1.cSetSize(10, 100, 50);
			cForm1.setPosition(10,7, 1);
			cForm1.cSetSize(11, 100, 50);
			cForm1.setPosition(11,8, 0);
			cForm1.cSetSize(12, 100, 50);
			cForm1.setPosition(12,8,1);
			cForm1.cSetSize(13, 100, 50);
			cForm1.setPosition(13,9, 0);
		CTextOutputPanel textOutputPanel = (CTextOutputPanel) cForm1.getInputPanel(0);
		textOutputPanel.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel2 = (CTextOutputPanel) cForm1.getInputPanel(1);
		textOutputPanel2.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel3 = (CTextOutputPanel) cForm1.getInputPanel(2);
		textOutputPanel3.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel4 = (CTextOutputPanel) cForm1.getInputPanel(3);
		textOutputPanel4.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel5 = (CTextOutputPanel) cForm1.getInputPanel(4);
		textOutputPanel5.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel6 = (CTextOutputPanel) cForm1.getInputPanel(5);
		textOutputPanel6.cRenderFlowLayout();
		CSingleSelectInputTablePanel inputTablePanel2=(CSingleSelectInputTablePanel) cForm1.getInputPanel(6);
		inputTablePanel2.cRenderFlowLayout();
		CFilterTableInputPanel cFilterTableInputPanel=(CFilterTableInputPanel) cForm1.getInputPanel(7);
		cFilterTableInputPanel.setButtonString("Search");
		cFilterTableInputPanel.setInputWidth(200);
		cFilterTableInputPanel.setTableWidth(500);
		cFilterTableInputPanel.setTableHeight(100);
		cFilterTableInputPanel.cRenderFlowLayout();
		cFilterTableInputPanel.cRenderBorderLayout();
		cFilterTableInputPanel.cRenderFlowLayout();
		CTextInputPanel cTextInputPanel =(CTextInputPanel) cForm1.getInputPanel(8);
		cTextInputPanel.cRenderFlowLayout();
		CComboInputPanel comboInputPanel5= (CComboInputPanel) cForm1.getInputPanel(9);
		comboInputPanel5.cRenderFlowLayout();
		CTextInputPanel cTextInputPanel6 =(CTextInputPanel) cForm1.getInputPanel(10);
		cTextInputPanel6.cRenderFlowLayout();
		CComboInputPanel comboInputPanel6= (CComboInputPanel) cForm1.getInputPanel(11);
		comboInputPanel6.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel7 = (CTextOutputPanel) cForm1.getInputPanel(12);
		textOutputPanel7.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel8 = (CTextOutputPanel) cForm1.getInputPanel(13);
		textOutputPanel8.cRenderFlowLayout();
		
		CForm cForm2=new CUIFactory().createForm("resources/forms/confirmation/confirmationform.properties");
		new CUIFactory().setFormUI(cForm2);
		
		cForm2.renderGridBagLayout();
		
		CTextOutputPanel outputPanel=(CTextOutputPanel) cForm2.getInputPanel(0);
		
		outputPanel.cRenderGridBagLayout();
		CTextOutputPanel outputPanel2=(CTextOutputPanel) cForm2.getInputPanel(1);
		outputPanel2.cRenderGridBagLayout();
		CTextOutputPanel outputPanel3=(CTextOutputPanel) cForm2.getInputPanel(2);
		outputPanel3.cRenderGridBagLayout();
		CTextOutputPanel outputPanel4=(CTextOutputPanel) cForm2.getInputPanel(3);
		outputPanel4.cRenderGridBagLayout();
		CTextOutputPanel outputPanel5=(CTextOutputPanel) cForm2.getInputPanel(4);
		outputPanel5.cRenderGridBagLayout();
		CTextOutputPanel outputPanel6=(CTextOutputPanel) cForm2.getInputPanel(5);
		outputPanel6.cRenderGridBagLayout();
		CSingleSelectInputTablePanel outputPanel7=(CSingleSelectInputTablePanel) cForm2.getInputPanel(6);
		outputPanel7.cRenderFlowLayout();
		//CTextOutputPanel outputPanel8=(CTextOutputPanel) cForm2.getInputPanel(7);
//		outputPanel8.cRenderGridBagLayout();
//		CTextOutputPanel outputPanel9=(CTextOutputPanel) cForm2.getInputPanel(8);
//		outputPanel9.cRenderGridBagLayout();
//		CTextOutputPanel outputPanel10=(CTextOutputPanel) cForm2.getInputPanel(9);
//		outputPanel10.cRenderGridBagLayout();
		CTextOutputPanel outputPanel11=(CTextOutputPanel) cForm2.getInputPanel(7);
		outputPanel11.cRenderGridBagLayout();
		CTextOutputPanel outputPanel12=(CTextOutputPanel) cForm2.getInputPanel(8);
		outputPanel12.cRenderGridBagLayout();
		CTextOutputPanel outputPanel13=(CTextOutputPanel) cForm2.getInputPanel(9);
		outputPanel13.cRenderGridBagLayout();
		CTextOutputPanel outputPanel14=(CTextOutputPanel) cForm2.getInputPanel(10);
		outputPanel14.cRenderGridBagLayout();
//		CTextOutputPanel outputPanel15=(CTextOutputPanel) cForm2.getInputPanel(14);
//		outputPanel15.cRenderGridBagLayout();
		CTextOutputPanel outputPanel16=(CTextOutputPanel) cForm2.getInputPanel(11);
		outputPanel16.cRenderGridBagLayout();
		
		CForm cForm3=new CUIFactory().createForm("resources/forms/finalscreen/finalscreenform.properties");
		new CUIFactory().setFormUI(cForm3);
	
		cForm3.renderGridBagLayout();
		CTextOutputPanel cTextOutputPanel1=(CTextOutputPanel) cForm3.getInputPanel(0);
		cTextOutputPanel1.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel2=(CTextOutputPanel) cForm3.getInputPanel(1);
		cTextOutputPanel2.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel3=(CTextOutputPanel) cForm3.getInputPanel(2);
		cTextOutputPanel3.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel4=(CTextOutputPanel) cForm3.getInputPanel(3);
		cTextOutputPanel4.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel5=(CTextOutputPanel) cForm3.getInputPanel(4);
		cTextOutputPanel5.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel6=(CTextOutputPanel) cForm3.getInputPanel(5);
		cTextOutputPanel6.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel7=(CTextOutputPanel) cForm3.getInputPanel(6);
		cTextOutputPanel7.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel8=(CTextOutputPanel) cForm3.getInputPanel(7);
		cTextOutputPanel8.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel9=(CTextOutputPanel) cForm3.getInputPanel(8);
		cTextOutputPanel9.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel10=(CTextOutputPanel) cForm3.getInputPanel(9);
		cTextOutputPanel10.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel11=(CTextOutputPanel) cForm3.getInputPanel(10);
		cTextOutputPanel11.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel12=(CTextOutputPanel) cForm3.getInputPanel(11);
		cTextOutputPanel12.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel13=(CTextOutputPanel) cForm3.getInputPanel(12);
		cTextOutputPanel13.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel14=(CTextOutputPanel) cForm3.getInputPanel(13);
		cTextOutputPanel14.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel15=(CTextOutputPanel) cForm3.getInputPanel(14);
		cTextOutputPanel15.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel16=(CTextOutputPanel) cForm3.getInputPanel(15);
		cTextOutputPanel16.cRenderGridBagLayout();
		CTextOutputPanel cTextOutputPanel17=(CTextOutputPanel) cForm3.getInputPanel(16);
		cTextOutputPanel17.cRenderGridBagLayout();
		CSingleSelectInputTablePanel inputTablePanel3 = (CSingleSelectInputTablePanel) cForm3.getInputPanel(17);
		System.out.println(inputTablePanel3);
		inputTablePanel3.cRenderFlowLayout();
		CActionPanel actionPanel2= (CActionPanel) cForm3.getInputPanel(18);
		actionPanel2.cRender();
		
		cForm.renderHorizontalBox();
		cForm1.render();
		cForm2.setVisible(true);
		cForm2.invalidate();
		cForm2.validate();
		cForm1.setVisible(true);
		cForm1.invalidate();
		cForm1.validate();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();
		cForm3.setVisible(true);
		cForm3.invalidate();
		cForm3.validate();
		wizard.cAdd(welcomeForm);
		wizard.cAdd(cForm);
		wizard.cAdd(cForm1);
		wizard.cAdd(cForm2);
		wizard.cAdd(cForm3);
		wizard.cAdd(finishForm);
		wizard.render();
		wizard.setVisible(true);
		wizard.invalidate();
		wizard.validate();
		target.add(wizard);
		target.invalidate();
		target.validate();
		
	}

}
