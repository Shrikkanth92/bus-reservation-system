package com.polaris.teamd.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.admin.CManageService;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CCheck;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CMultiCheck;
import com.polaris.teamd.ui.custom.CWizard;
import com.polaris.teamd.ui.custom.inputpanel.CCheckInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CMultiCheckInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CModifyServiceAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CManageService();
		target.removeAll();
		target.add(mypanel);


		CForm welcomeForm = new CForm();
		CForm finishForm = new CForm();
		welcomeForm.cInit("Welcome to Modify Service Wizard");
		finishForm.cInit("Congratulations!");
		CLabel label= new CLabel("This wizard will help you to add new service for an Operator.");
		CLabel label2= new CLabel("1.Edit Basic Information regarding the new Service.");
		CLabel label3= new CLabel("2.Edit the service days and boarding points.");
		CLabel label4= new CLabel("3.Edit Intermediate Cities if any.");
		CLabel label5= new CLabel("You have modified the bus service successfully");
		
		JPanel  jPanel= new JPanel(new GridLayout(5, 1,10,10));
		JPanel  jPanel2= new JPanel(new BorderLayout(50,10));
		
		label5.setFont(new Font("Arial", Font.BOLD, 25));
		label5.setForeground(Color.darkGray);
				

		jPanel.add(label);
		jPanel.add(label2);
		jPanel.add(label3);
		jPanel.add(label4);
		jPanel2.add(label5);
		
		welcomeForm.cAddInputPanel(jPanel);
		finishForm.cAddInputPanel(jPanel2);
		
		new CUIFactory().setFormUI(welcomeForm);
		new CUIFactory().setFormUI(finishForm);
		
		CMultiCheck check=new CMultiCheck();
		check.setLayout(new GridLayout(3, 3));
		check.add(new CCheck("Monday"));
		check.add(new CCheck("Tuesday"));
		check.add(new CCheck("Wednesday"));
		check.add(new CCheck("Thursday"));
		check.add(new CCheck("Friday"));
		check.add(new CCheck("Saturday"));
		check.add(new CCheck("Sunday"));
		check.add(new CCheck("Select All"));
		check.add(new CCheck("Deselect All"));
		
		
		CWizard cWizard = new CWizard(2);

		CForm cForm1 = new CUIFactory()
				.createForm("resources/forms/cmodifyserviceform/cmodifyserviceform00.properties");
		new CUIFactory().setFormUI(cForm1);
		CComboInputPanel panel1 = (CComboInputPanel) cForm1.getInputPanel(0);
		panel1.cRenderFlowLayout();
		CComboInputPanel panel2 = (CComboInputPanel) cForm1.getInputPanel(1);
		panel2.cRenderFlowLayout();
		CComboInputPanel panel3 = (CComboInputPanel) cForm1.getInputPanel(2);
		panel3.cRenderFlowLayout();
		CComboInputPanel panel4 = (CComboInputPanel) cForm1.getInputPanel(3);
		panel4.cRenderFlowLayout();
		CSpinnerInputPanel panel5 = (CSpinnerInputPanel) cForm1.getInputPanel(4);
		panel5.cRenderFlowLayout();
		CSpinnerInputPanel panel6 = (CSpinnerInputPanel) cForm1.getInputPanel(5);
		panel6.cRenderFlowLayout();
		CSpinnerInputPanel panel7 = (CSpinnerInputPanel) cForm1.getInputPanel(6);
		panel7.cRenderFlowLayout();
		CSpinnerInputPanel panel8 = (CSpinnerInputPanel) cForm1.getInputPanel(7);
		panel8.cRenderFlowLayout();
		CActionPanel panel9 = (CActionPanel) cForm1.getInputPanel(8);
		panel9.cRender();

		CForm cForm2 = new CUIFactory().createForm("resources/forms/cmodifyserviceform/cmodifyserviceform01.properties");
		new CUIFactory().setFormUI(cForm2);
		CMultiCheckInputPanel panel21 = (CMultiCheckInputPanel) cForm2.getInputPanel(0);
		panel21.cSetMultiCheck(check);
		panel21.cRenderGridBagLayout();

		CCheckInputPanel panel22 = (CCheckInputPanel) cForm2.getInputPanel(1);
		panel22.cRenderFlowLayout();

		CMultiCheckInputPanel panel23 = (CMultiCheckInputPanel) cForm2.getInputPanel(2);
		panel23.cRenderFlowLayout();

		CActionPanel panel24 = (CActionPanel) cForm2.getInputPanel(3);
		panel24.cRender();
		


		CForm cForm3 = new CUIFactory()
				.createForm("resources/forms/cmodifyserviceform/cmodifyserviceform02.properties");
		new CUIFactory().setFormUI(cForm3);
		CTextInputPanel panel31 = (CTextInputPanel) cForm3.getInputPanel(0);
		panel31.cRenderFlowLayout();
		CSpinnerInputPanel panel32 = (CSpinnerInputPanel) cForm3.getInputPanel(1);
		panel32.cRenderFlowLayout();
		CSpinnerInputPanel panel33 = (CSpinnerInputPanel) cForm3.getInputPanel(2);
		panel33.cRenderFlowLayout();
		CSpinnerInputPanel panel34 = (CSpinnerInputPanel) cForm3.getInputPanel(3);
		panel34.cRenderFlowLayout();
		CActionPanel panel35 = (CActionPanel) cForm3.getInputPanel(4);
		panel35.cRender();
		
		CSingleSelectInputTablePanel panel36=(CSingleSelectInputTablePanel)cForm3.getInputPanel(5);
		panel36.cRenderFlowLayout();
		
		CActionPanel panel37 = (CActionPanel) cForm3.getInputPanel(6);
		panel37.cRender();

		
		welcomeForm.renderGridBagLayout();
		welcomeForm.setVisible(true);
		welcomeForm.invalidate();
		welcomeForm.validate();

		cForm1.renderGridBagLayout();
		cForm1.setVisible(true);
		cForm1.invalidate();
		cForm1.validate();
		
		cForm2.renderGridBagLayout();
		cForm2.setVisible(true);
		cForm2.invalidate();
		cForm2.validate();
				
		cForm3.renderGridBagLayout();
		cForm3.setVisible(true);
		cForm3.invalidate();
		cForm3.validate();
		
		finishForm.renderGridBagLayout();
		finishForm.setVisible(true);
		finishForm.invalidate();
		finishForm.validate();
		
		cWizard.cAdd(welcomeForm);
		cWizard.cAdd(cForm1);
		cWizard.cAdd(cForm2);
		cWizard.cAdd(cForm3);
		cWizard.cAdd(finishForm);
		
		cWizard.render();
		cWizard.setVisible(true);
		cWizard.invalidate();
		cWizard.validate();
		target.add(cWizard);
		target.invalidate();
		target.validate();
	}
}
