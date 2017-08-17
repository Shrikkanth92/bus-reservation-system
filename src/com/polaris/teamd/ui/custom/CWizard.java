/**
 * 
 */
package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIFactory;

/**
 * 
 * @author shrikkanth.ramesh
 * 
 */
public class CWizard extends JPanel {

	private ArrayList<CWizardStep> cWizardStepsList = new ArrayList<CWizardStep>();
	private JPanel jPanel = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel stepsPanel = new JPanel();
	private CardLayout cardLayout;
	private ArrayList<CForm> formList = new ArrayList<CForm>();
	private int chosenIndex = 0;

	public CWizard() {
		super();
	}

	public CWizard(int selectType) {
		if (selectType == 1)
			initWizardSteps1();
		if (selectType == 2)
			initWizardSteps2();
		GridLayout gridLayout = new GridLayout(10, 5);
		gridLayout.setVgap(20);
		stepsPanel.setLayout(gridLayout);

	}

	public void initWizardSteps1() {
		cWizardStepsList.add(new CWizardStep(0, 1, "1. Welcome", new CLabel()));
		cWizardStepsList.add(new CWizardStep(1, 0, "2. Search Services",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(2, 0, "3. Select Seats ",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(3, 0, "4. Confirmation Screen",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(4, 0, "4. Ticket Printing",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(5, 0, "5. Finish", new CLabel()));

	}

	public void initWizardSteps2() {
		cWizardStepsList.add(new CWizardStep(0, 1, "Welcome", new CLabel()));
		cWizardStepsList.add(new CWizardStep(1, 0, "Basic Details",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(2, 0,
				"Service Days & Boarding Points", new CLabel()));
		cWizardStepsList.add(new CWizardStep(3, 0, "Intermediate Cities",
				new CLabel()));
		cWizardStepsList.add(new CWizardStep(4, 0, "Finish", new CLabel()));
	}

	public void cAdd(CForm cForm) {
		System.out.println(formList.size());
		System.out.println("CADDDDDDDDDDD");
		formList.add(cForm);
	}

	public CWizard render() {
		int index = 1;
		String key = "form";

		this.setLayout(new BorderLayout());

		for (int i = 0; i < cWizardStepsList.size(); i++) {
			cWizardStepsList.get(i).setStatus(
					cWizardStepsList.get(i).getStatus());
			CLabel cLabel = cWizardStepsList.get(i).getcLabel();
			stepsPanel.add(cLabel);
		}

		cardLayout = new CardLayout();
		jPanel.setLayout(cardLayout);

		for (CForm form : formList) {
			form.renderGridBagLayout();
			jPanel.add(key + index, form);
			index++;
		}
		CButton prevButton = new CButton("Previous");
		CButton nextButton = new CButton("Next");
		CButton finishButton = new CButton("Cancel");
		jPanel2.add(prevButton);
		jPanel2.add(nextButton);
		jPanel2.add(finishButton);
		(new CUIFactory()).applyBorder(stepsPanel);
		this.add(stepsPanel, BorderLayout.WEST);
		this.add(jPanel, BorderLayout.CENTER);
		this.add(jPanel2, BorderLayout.NORTH);
		System.out.println(formList.size());
		prevButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chosenIndex != 0) {
					cWizardStepsList.get(chosenIndex).setStatus(0);
					chosenIndex--;
					cWizardStepsList.get(chosenIndex).setStatus(1);
					stepsPanel.repaint();
					stepsPanel.invalidate();
					stepsPanel.validate();
					cardLayout.previous(jPanel);
				}

			}
		});

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenIndex != (cWizardStepsList.size() - 1)) {
					cWizardStepsList.get(chosenIndex).setStatus(2);
					chosenIndex++;
					cWizardStepsList.get(chosenIndex).setStatus(1);
					stepsPanel.repaint();
					stepsPanel.invalidate();
					stepsPanel.validate();
					cardLayout.next(jPanel);
				}

			}
		});
		return this;
	}
}
