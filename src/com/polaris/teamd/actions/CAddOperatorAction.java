package com.polaris.teamd.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.bean.CBusOperator;
import com.polaris.teamd.service.CSBusOperatorImpl;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.admin.CAddOperator;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CEmptyPanel;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CMultiText;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.custom.inputpanel.CMultiTextInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CAddOperatorAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CAddOperator();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Add Operator Action");

		target.setLayout(new FlowLayout(FlowLayout.LEFT));
		final CForm cForm = new CUIFactory()
				.createForm("resources/forms/addoperator/caddoperatorform.properties");
		new CUIFactory().setFormUI(cForm);

		cForm.setPosition(0, 0, 0);
		cForm.cSetSize(0, 500, 50);
		CTextInputPanel cTextInputPanel1 = (CTextInputPanel) cForm
				.getInputPanel(0);

		cForm.setPosition(1, 1, 0);
		cForm.cSetSize(1, 500, 150);
		CMultiTextInputPanel cMultiTextInputPanel = (CMultiTextInputPanel) cForm
				.getInputPanel(1);
		CMultiText cMultiText = new CMultiText();
		cMultiText.setNumberOfTexts(4);
		int i = cMultiText.getNumberOfTexts();
		cMultiTextInputPanel.setMultiText(cMultiText);
		// cMultiTextInputPanel.setColumnLength(30);
		cMultiTextInputPanel.setErrorMessageOrientation(1);
		cMultiTextInputPanel.setPreferredLayout(4);

		cForm.setPosition(2, i++, 0);
		cForm.cSetSize(2, 500, 50);
		CTextInputPanel cTextInputPanel2 = (CTextInputPanel) cForm
				.getInputPanel(2);

		cForm.setPosition(3, i++, 0);
		cForm.cSetSize(3, 500, 50);
		CTextInputPanel cTextInputPanel3 = (CTextInputPanel) cForm
				.getInputPanel(3);

		cForm.setPosition(4, i++, 0);
		cForm.cSetSize(4, 500, 50);
		CTextInputPanel cTextInputPanel4 = (CTextInputPanel) cForm
				.getInputPanel(4);

		cForm.setPosition(5, i++, 0);
		cForm.cSetSize(5, 500, 50);
		CTextInputPanel cTextInputPanel5 = (CTextInputPanel) cForm
				.getInputPanel(5);

		// cForm.setPosition(6, i++, 0);
		// cForm.cSetSize(6, 500, 50);
		// CEmptyPanel cEmptyPanel = (CEmptyPanel) cForm.getInputPanel(6);

		cForm.setPosition(7, i++, 0);
		cForm.cSetSize(7, 500, 50);
		CActionPanel actionPanel = (CActionPanel) cForm.getInputPanel(6);

		cForm.setPosition(8, 0, 2);
		cForm.cSetSize(8, 500, 50);
		CActionPanel actionPanel1 = (CActionPanel) cForm.getInputPanel(7);

		// final CSingleSelectInputTablePanel cSingleSelectInputTablePanel =
		// (CSingleSelectInputTablePanel) cForm
		// .getInputPanel(8);

		cTextInputPanel1.cRenderFlowLayout();
		cMultiTextInputPanel.refresh();
		cTextInputPanel2.cRenderFlowLayout();
		cTextInputPanel3.cRenderFlowLayout();
		cTextInputPanel4.cRenderFlowLayout();
		cTextInputPanel5.cRenderFlowLayout();
		// cEmptyPanel.cRender();
		actionPanel.cRender();
		actionPanel1.cRender();

		// cSingleSelectInputTablePanel.cHide();

		cForm.render();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();

		target.add(cForm);
		target.invalidate();
		target.validate();

		// final CButton viewButton = actionPanel1.getButtonAt(0);
		//
		// viewButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// cSingleSelectInputTablePanel.cRenderFlowLayout();
		// cSingleSelectInputTablePanel.cShow();
		//
		// // JButton button = (JButton) e.getSource();
		// viewButton.setText("Hide");
		//
		// viewButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// cSingleSelectInputTablePanel.cHide();
		// viewButton.setText("View Existing");
		//
		// }
		// });
		// }
		// });

		// CButton saveButton = actionPanel.getButtonAt(0);
		// saveButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// final CBusOperator cBusOperator = (CBusOperator) ApplicationCache
		// .getValue("Bus Operator");
		//
		// // int count = 2;
		// CTextInputPanel cTextInputPanel = (CTextInputPanel) cForm
		// .getInputPanel(0);
		//
		// final CText cText = cTextInputPanel.getInput();
		//
		// String str = cText.getText();
		// cBusOperator.setOperatorName(str);
		//
		// cText.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		//
		// String str = cText.getText();
		//
		// cBusOperator.setOperatorName(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		//
		// }
		// });
		//
		// CTextInputPanel cTextInputPanel2 = (CTextInputPanel) cForm
		// .getInputPanel(1);
		//
		// final CText cText2 = cTextInputPanel2.getInput();
		// str = cText2.getText();
		//
		// cBusOperator.setOfficeAddress(str);
		// cText2.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		//
		// String str = cText2.getText();
		//
		// cBusOperator.setOfficeAddress(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		//
		// CTextInputPanel cTextInputPanel3 = (CTextInputPanel) cForm
		// .getInputPanel(2);
		//
		// final CText cText3 = cTextInputPanel3.getInput();
		// str = cText3.getText();
		//
		// cBusOperator.setPhoneNumber1(str);
		//
		// cText3.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		//
		// String str = cText3.getText();
		//
		// cBusOperator.setPhoneNumber1(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		// // cForm.getInputPanel(7).new CBusOperatorSaveButtonAction());
		//
		// CTextInputPanel cTextInputPanel4 = (CTextInputPanel) cForm
		// .getInputPanel(3);
		//
		// final CText cText4 = cTextInputPanel4.getInput();
		//
		// str = cText4.getText();
		// System.out.println(str);
		// cBusOperator.setPhoneNumber2(str);
		// cText4.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		// String str = cText4.getText();
		// System.out.println(str);
		// cBusOperator.setPhoneNumber2(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		//
		// CTextInputPanel cTextInputPanel5 = (CTextInputPanel) cForm
		// .getInputPanel(4);
		//
		// final CText cText5 = cTextInputPanel5.getInput();
		//
		// str = cText5.getText();
		//
		// cBusOperator.setEmailId(str);
		// cText5.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		// String str = cText5.getText();
		//
		// cBusOperator.setEmailId(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		//
		// CTextInputPanel cTextInputPanel6 = (CTextInputPanel) cForm
		// .getInputPanel(5);
		//
		// final CText cText6 = cTextInputPanel6.getInput();
		// str = cText6.getText();
		//
		// cBusOperator.setContactPerson(str);
		// cText6.addFocusListener(new FocusListener() {
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		// String str = cText6.getText();
		//
		// cBusOperator.setContactPerson(str);
		//
		// }
		//
		// @Override
		// public void focusGained(FocusEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		//
		// final CSBusOperatorImpl csImpl = new CSBusOperatorImpl();
		// System.out.println(cBusOperator.toString());
		// csImpl.addOperator(cBusOperator);
		//
		// System.out.println(cBusOperator.toString());
		//
		// }
		// });

	}
}
