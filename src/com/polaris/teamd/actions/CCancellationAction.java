package com.polaris.teamd.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable;
import com.polaris.teamd.ui.custom.inputpanel.CComboInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextOutputPanel;
import com.polaris.teamd.ui.staff.CCancellation;

public class CCancellationAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel =  new CCancellation();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Cancellation Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		CForm cForm=new CUIFactory().createForm("resources/forms/cancellation/pnrcancellation.properties");
		new CUIFactory().setFormUI(cForm);
		
		CTextInputPanel textInputPanel=(CTextInputPanel) cForm.getInputPanel(0);
		textInputPanel.cRenderFlowLayout();
		/*CComboInputPanel comboInputPanel=(CComboInputPanel) cForm.getInputPanel(1);
		comboInputPanel.cRenderFlowLayout();
		CComboInputPanel comboInputPanel1=(CComboInputPanel) cForm.getInputPanel(2);
		comboInputPanel1.cRenderFlowLayout();
		CComboInputPanel comboInputPanel2=(CComboInputPanel) cForm.getInputPanel(3);
		comboInputPanel2.cRenderFlowLayout();
		CTextInputPanel textInputPanel1=(CTextInputPanel) cForm.getInputPanel(4);
		textInputPanel1.cRenderFlowLayout();
		CSpinnerInputPanel spinnerInputPanel=(CSpinnerInputPanel) cForm.getInputPanel(5);
		spinnerInputPanel.cRenderFlowLayout();
		CActionPanel actionPanel=(CActionPanel)cForm.getInputPanel(6);
		actionPanel.cRender();
		CSingleSelectInputTablePanel singleSelectInputTable=(CSingleSelectInputTablePanel)cForm.getInputPanel(7);
		singleSelectInputTable.cRenderFlowLayout();
		CTextInputPanel textInputPanel2=(CTextInputPanel) cForm.getInputPanel(8);
		textInputPanel2.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel=(CTextOutputPanel) cForm.getInputPanel(9);
		textOutputPanel.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel1=(CTextOutputPanel) cForm.getInputPanel(10);
		textOutputPanel1.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel2=(CTextOutputPanel) cForm.getInputPanel(11);
		textOutputPanel2.cRenderFlowLayout();
		CTextOutputPanel textOutputPanel3=(CTextOutputPanel) cForm.getInputPanel(12);
		textOutputPanel3.cRenderFlowLayout();
		CActionPanel actionPanel1=(CActionPanel)cForm.getInputPanel(13);
		actionPanel1.cRender();*/
	/*cForm.setPosition(0, 0, 0);
	cForm.setPosition(1, 0, 0);
	cForm.setPosition(2, 0, 0);*/
	/*cForm.getInputPanel(0).setColumnLength(25);
	cForm.getInputPanel(1).setColumnLength(25);
	cForm.getInputPanel(2).setColumnLength(25);*/
	//cForm.setPosition(1, 1, 0);
////		cForm.setPosition(2, 2, 0);
////		cForm.setPosition(3, 3, 0);
////		cForm.setPosition(4, 4, 0);
////		cForm.setPosition(5, 5, 0);
////		cForm.setPosition(6, 6, 0);
//		cForm.setPosition(7, 7, 0);
	//	cForm.setPosition(8, 8, 0);
////		
//		
//		cForm.cSetSize(0,100,10);
//		cForm.cSetSize(1,100,10);
////		cForm.cSetSize(2,100,10);
////		cForm.cSetSize(3,100,10);
////		cForm.cSetSize(4,100,10);
////		cForm.cSetSize(5,100,10);
////		cForm.cSetSize(6,100,10);
	//	cForm.cSetSize(7,100,10);
	//	cForm.cSetSize(8,100,10);
////	
	
		cForm.renderGridBagLayout();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();
		target.add(cForm);
		target.invalidate();
		target.validate();

}
	}


