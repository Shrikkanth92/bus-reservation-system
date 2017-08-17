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
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.custom.inputpanel.CSingleSelectInputTablePanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUIFactory;

public class CAddOperatorInputUIAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		button.setText("Add Operator");
		JPanel target = com.polaris.teamd.app.ApplicationCache
				.get("CONTENTSCREEN");
		// JPanel mypanel = new CAddOperator();
		target.removeAll();
		// target.add(mypanel);

		target.setLayout(new FlowLayout(FlowLayout.LEFT));

		com.polaris.teamd.ui.custom.CForm cForm = new CUIFactory()
				.createForm("resources/forms/addoperator/caddoperatorform.properties");

		new CUIFactory().setFormUI(cForm);
		// cForm.setPosition(0, 0, 0);
		// cForm.setPosition(1, 2, 0);
		// cForm.setPosition(2, 3, 0);
		// cForm.setPosition(3, 4, 0);
		// cForm.setPosition(4, 5, 0);
		// cForm.setPosition(5, 6, 0);
		// cForm.setPosition(6, 7, 0);
		// cForm.setPosition(7, 8, 0);
		// cForm.setPosition(8, 0, 1);
		// cForm.setPosition(9, 10, 0);

		/*
		 * cForm.cSetSize(0, 150, 40); cForm.cSetSize(1, 150, 40);
		 * cForm.cSetSize(2, 150, 40); cForm.cSetSize(3, 150, 40);
		 * cForm.cSetSize(4, 150, 40); cForm.cSetSize(5, 150, 40);
		 * cForm.cSetSize(6, 150, 40); cForm.cSetSize(7, 150, 40);
		 */
		// cForm.cSetSize(8, 150, 40);
		// cForm.cSetSize(9, 250, 40);

		// cForm.getInputPanel(0).cSetErrorLabelSize(60, 30);
		/*
		 * cForm.getInputPanel(0).cSetInputSize(150, 35);
		 * cForm.getInputPanel(1).cSetInputSize(150, 35);
		 * cForm.getInputPanel(2).cSetInputSize(150, 35);
		 * cForm.getInputPanel(3).cSetInputSize(150, 35);
		 * cForm.getInputPanel(4).cSetInputSize(150, 35);
		 * cForm.getInputPanel(5).cSetInputSize(150, 35);
		 * cForm.getInputPanel(6).cSetInputSize(150, 35);
		 * cForm.getInputPanel(7).cSetInputSize(150, 35);
		 * 
		 * cForm.getInputPanel(8).cSetInputSize(300, 300);
		 */

		/*
		 * cForm.getInputPanel(0).setColumnLength(20);
		 * cForm.getInputPanel(1).setColumnLength(20);
		 * cForm.getInputPanel(2).setColumnLength(20);
		 * cForm.getInputPanel(3).setColumnLength(20);
		 * cForm.getInputPanel(4).setColumnLength(20);
		 * cForm.getInputPanel(5).setColumnLength(20);
		 * cForm.getInputPanel(6).setColumnLength(20);
		 */
		// cForm.getInputPanel(7).setColumnLength(20);

		// cForm.getInputPanel(8).setColumnLength(10);

		final CBusOperator cBusOperator = (CBusOperator) ApplicationCache
				.getValue("Bus Operator");
		//int count = 2;
		CTextInputPanel cTextInputPanel = (CTextInputPanel) cForm
				.getInputPanel(0);
		
		final CText cText = cTextInputPanel.getInput();

		cText.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				String str = cText.getText();

				cBusOperator.setOperatorName(str);

			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		CTextInputPanel cTextInputPanel2 = (CTextInputPanel) cForm
				.getInputPanel(1);

		final CText cText2 = cTextInputPanel2.getInput();

		cText2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				String str = cText2.getText();

				cBusOperator.setOfficeAddress(str);

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		CTextInputPanel cTextInputPanel3 = (CTextInputPanel) cForm
				.getInputPanel(2);

		final CText cText3 = cTextInputPanel3.getInput();

		cText3.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				String str = cText3.getText();

				cBusOperator.setPhoneNumber1(str);

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// cForm.getInputPanel(7).new CBusOperatorSaveButtonAction());

		CTextInputPanel cTextInputPanel4 = (CTextInputPanel) cForm
				.getInputPanel(3);

		final CText cText4 = cTextInputPanel4.getInput();

		cText4.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String str = cText4.getText();

				cBusOperator.setPhoneNumber2(str);

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		CTextInputPanel cTextInputPanel5 = (CTextInputPanel) cForm
				.getInputPanel(4);

		final CText cText5 = cTextInputPanel5.getInput();

		cText5.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String str = cText5.getText();

				cBusOperator.setEmailId(str);

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		CTextInputPanel cTextInputPanel6 = (CTextInputPanel) cForm
				.getInputPanel(5);

		final CText cText6 = cTextInputPanel6.getInput();

		cText6.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String str = cText6.getText();

				cBusOperator.setContactPerson(str);

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		cForm.cSetSize(0, 250, 40);
		cForm.renderGridBagLayout();
		CActionPanel actionPanel = (CActionPanel) cForm.getInputPanel(6);
		System.out.println(actionPanel.getButtons().length);
		CButton addButton = actionPanel.getButtonAt(0);
		System.out.println(addButton);
		final CSBusOperatorImpl csImpl = new CSBusOperatorImpl();
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csImpl.addOperator(cBusOperator);
			}
		});

		// cForm.renderFlowLayout();
		cForm.setVisible(true);
		cForm.invalidate();
		cForm.validate();

		target.add(cForm);
		target.invalidate();
		target.validate();
		System.out.println("Add Operator panel");
	}

}
