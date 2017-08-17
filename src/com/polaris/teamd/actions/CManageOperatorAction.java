package com.polaris.teamd.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.admin.CManageOperator;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CManageOperatorAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CManageOperator();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Manage Operator Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		CForm cForm = new CUIFactory()
				.createForm("resources/forms/manageoperator/cmanageoperatorform.properties");
		new CUIFactory().setFormUI(cForm);

		CFilterTableInputPanel cFilterTableInputPanel = (CFilterTableInputPanel) cForm
				.getInputPanel(0);
		cFilterTableInputPanel.setButtonString("Search");
		cFilterTableInputPanel.setInputWidth(200);
		cFilterTableInputPanel.setTableWidth(500);
		cFilterTableInputPanel.setTableHeight(100);
		cFilterTableInputPanel.cRenderFlowLayout();
		cFilterTableInputPanel.cRenderBorderLayout();

		CTextInputPanel cTextInputPanel = (CTextInputPanel) cForm
				.getInputPanel(1);
		CTextInputPanel cTextInputPanel1 = (CTextInputPanel) cForm
				.getInputPanel(2);
		CTextInputPanel cTextInputPanel2 = (CTextInputPanel) cForm
				.getInputPanel(3);
		CTextInputPanel cTextInputPanel3 = (CTextInputPanel) cForm
				.getInputPanel(4);
		CTextInputPanel cTextInputPanel4 = (CTextInputPanel) cForm
				.getInputPanel(5);
		CTextInputPanel cTextInputPanel5 = (CTextInputPanel) cForm
				.getInputPanel(6);

		cTextInputPanel.cRenderFlowLayout();
		cTextInputPanel1.cRenderFlowLayout();
		cTextInputPanel2.cRenderFlowLayout();
		cTextInputPanel3.cRenderFlowLayout();
		cTextInputPanel4.cRenderFlowLayout();
		cTextInputPanel5.cRenderFlowLayout();

		CActionPanel actionPanel = (CActionPanel) cForm.getInputPanel(7);

		actionPanel.cRender();

		cForm.renderGridBagLayout();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();

		target.add(cForm);
		target.invalidate();
		target.validate();
	}

}
