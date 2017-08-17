package com.polaris.teamd.actions;

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
import com.polaris.teamd.ui.custom.CMultiCheck;
import com.polaris.teamd.ui.custom.inputpanel.CCheckInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CMultiCheckInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextOutputPanel;

public class CManageServiceAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel =  new CManageService();
		target.removeAll();
		target.add(mypanel);
		
		CForm cForm=new CUIFactory().createForm("resources/forms/cmanageserviceform/cmanageserviceform.properties");
		new CUIFactory().setFormUI(cForm);
		
		CMultiCheck check=new CMultiCheck();
		check.setLayout(new GridLayout(3, 3));
		check.add(new CCheck("Monday"));
		check.add(new CCheck("Tuesday"));
		check.add(new CCheck("Wednesday"));
		check.add(new CCheck("Thursday"));
		check.add(new CCheck("Friday"));
		check.add(new CCheck("Saturday"));
		check.add(new CCheck("Sunday"));
		
		CFilterTableInputPanel panel1= (CFilterTableInputPanel) cForm.getInputPanel(0);

		panel1.setButtonString("Search");
		panel1.setInputWidth(200);
		panel1.setTableWidth(500);
		panel1.setTableHeight(100);
		panel1.setInputHeight(30);
		panel1.cRenderFlowLayout();
				
		CTextOutputPanel  panel2= (CTextOutputPanel) cForm.getInputPanel(1);
		panel2.cRenderFlowLayout();
		CTextOutputPanel  panel3= (CTextOutputPanel) cForm.getInputPanel(2);
		panel3.cRenderFlowLayout();
		CTextOutputPanel panel4= (CTextOutputPanel) cForm.getInputPanel(3);
		panel4.cRenderFlowLayout();
		CTextOutputPanel panel5= (CTextOutputPanel) cForm.getInputPanel(4);
		panel5.cRenderFlowLayout();
		CTextOutputPanel panel6= (CTextOutputPanel) cForm.getInputPanel(5);
		panel6.cRenderFlowLayout();
		CTextOutputPanel panel7= (CTextOutputPanel) cForm.getInputPanel(6);
		panel7.cRenderFlowLayout();
		CTextOutputPanel panel8= (CTextOutputPanel) cForm.getInputPanel(7);
		panel8.cRenderFlowLayout();
		CTextOutputPanel panel9= (CTextOutputPanel) cForm.getInputPanel(8);
		panel9.cRenderFlowLayout();

		
		CMultiCheckInputPanel panel10=(CMultiCheckInputPanel)cForm.getInputPanel(9);
		panel10.cSetMultiCheck(check);
		panel10.cRenderGridBagLayout();
		
		CCheckInputPanel panel11 = (CCheckInputPanel) cForm.getInputPanel(10);
		panel11.cRenderFlowLayout();
//		CSingleSelectInputTablePanel panel12=(CSingleSelectInputTablePanel)cForm.getInputPanel(11);
//		panel12.cRenderFlowLayout();
		
		CActionPanel panel13=(CActionPanel)cForm.getInputPanel(12);
		panel13.cRender();
		

		cForm.renderGridBagLayout();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();
		target.add(cForm);
		target.invalidate();
		target.validate();
	}

}
