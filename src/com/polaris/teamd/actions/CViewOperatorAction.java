package com.polaris.teamd.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.admin.CViewOperator;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CViewOperatorAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CViewOperator();
		target.removeAll();
		target.add(mypanel);
		System.out.println("View Operator Action");
		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		CForm cForm = new CUIFactory()
				.createForm("resources/forms/viewoperator/cviewoperatorform.properties");
		new CUIFactory().setFormUI(cForm);

		CFilterTableInputPanel cFilterTableInputPanel = (CFilterTableInputPanel) cForm
				.getInputPanel(0);
		cFilterTableInputPanel.setLabelString("Search");
		cFilterTableInputPanel.setInputWidth(10);
		cFilterTableInputPanel.setTableWidth(500);
		cFilterTableInputPanel.setTableHeight(100);
		cFilterTableInputPanel.cRenderFlowLayout();
		cFilterTableInputPanel.cRenderBorderLayout();

		CActionPanel actionPanel = (CActionPanel) cForm.getInputPanel(1);
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
