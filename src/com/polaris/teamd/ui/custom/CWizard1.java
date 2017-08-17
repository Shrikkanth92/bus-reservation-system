package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.polaris.teamd.app.ApplicationCache;

/**
 * 
 * @author
 * @version Java 1.6
 */
public class CWizard1 extends JPanel {

	private ArrayList<CForm> formList = new ArrayList<CForm>();
	private int layoutType;
	private CActionPanel actionPanel;
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	CardLayout cardLayout;
	/**
	 * This method sets the layout for the panels
	 * @param layoutType
	 */
	public final void setLayoutType(int layoutType) {
		this.layoutType = layoutType;
	}
/**
 * This is the non parameterized constructor
 */
	public CWizard1() {
		super();
	}
/**
 * This is the parameterized constructor
 * @param isDoubleBuffered
 */
	public CWizard1(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}
/**
 * This is the parameterized constructor
 * @param layout
 * @param isDoubleBuffered
 */
	public CWizard1(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
/**
 * This is the parameterized constructor
 * @param layout
 */
	public CWizard1(LayoutManager layout) {
		super(layout);
	}
/**
 * This method is to add a form to the wizard
 * @param form
 */
	public void cAdd(CForm form) {
		formList.add(form);
	}
/**
 * This method sets the actionpanel for the wizard
 * @param actionPanel
 */
	public void setActionPanel(CActionPanel actionPanel) {
		this.actionPanel = actionPanel;
	}
/**
 * This method gets the action panel
 * @return
 */
	public CActionPanel getActionPanel() {
		return actionPanel;
	}
/**
 * This method displays the wizard
 * @return
 */
	public CWizard1 render() {
		int index = 1;
		String key = "form";

		if (layoutType == LayoutType.CARDLAYOUT) {
			cardLayout = new CardLayout();
			panel.setLayout(cardLayout);
			for (CForm form : formList) {
				form.renderGridBagLayout();
				panel.add((key + index), form);
				index++;
			}
			CButton prevButton=new CButton("Previous");
			CButton nextButton=new CButton("Next");
			panel2.add(prevButton);
			panel2.add(nextButton);
			this.add(panel2,BorderLayout.SOUTH);
			prevButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.previous(panel);
				}
			});
			
			nextButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					cardLayout.next(panel);
				}
			});
			
			//ApplicationCache.put("WIZARD", panel);
		}
		if (layoutType == LayoutType.TABBEDPANE) {
			System.out.println("hhhh");
			this.setLayout(new BorderLayout());
			JTabbedPane tabbedPane = new JTabbedPane();
			for (CForm form : formList) {
				form.renderGridBagLayout();
				tabbedPane.add((key + index), form);
				index++;
			}
			panel.add(tabbedPane);
		}
		this.add(panel,BorderLayout.CENTER);
		
		actionPanel.cRender();
		this.add(actionPanel,BorderLayout.SOUTH);
		return this;
	}

}
