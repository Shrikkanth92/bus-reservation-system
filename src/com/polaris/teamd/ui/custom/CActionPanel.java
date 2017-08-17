package com.polaris.teamd.ui.custom;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.common.utils.ReflectionUtil;
import com.polaris.teamd.ui.custom.inputpanel.CInputPanel;

@SuppressWarnings("serial")
public class CActionPanel extends JPanel {

	CButton[] buttons;
	String[] actionStrings;
	ArrayList<String> captionList;
	int[] buttonWidths, buttonHeights;

	public CButton[] getButtons() {
		return buttons;
	}

	public CButton getButtonAt(int index) {
		return buttons[index];
	}

	public CActionPanel() {
		super();
		captionList = new ArrayList<String>();
	}

	public CActionPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public CActionPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	public CActionPanel(LayoutManager layout) {
		super(layout);

	}

	public int[] getButtonWidths() {
		return buttonWidths;
	}

	public void setButtonWidths(int[] buttonWidths) {
		this.buttonWidths = buttonWidths;
	}

	public int[] getButtonHeights() {
		return buttonHeights;
	}

	public void setButtonHeights(int[] buttonHeights) {
		this.buttonHeights = buttonHeights;
	}

	public String[] getActionStrings() {
		return actionStrings;
	}

	public void setActionStrings(String[] actionStrings) {
		this.actionStrings = actionStrings;
	}

	public void cAdd(String... captions) {
		for (int i = 0; i < captions.length; i++)
			captionList.add(captions[i]);
	}

	public void cRender() {
		System.out.println("Action panel rendering");
		
		int index = 0;
		for (String caption : captionList) {
			this.add(buttons[index]);
			index++;
		}

	}

	public void setButtonSize(int index, int width, int height) {
		if (buttons[index] != null) {
			buttons[index].setPreferredSize(new Dimension(width, height));
			buttons[index].setMaximumSize(new Dimension(width, height));
			buttons[index].setMinimumSize(new Dimension(width, height));
			buttons[index].setSize(new Dimension(width, height));
		}
	}

	public void setComponentAttributes() {
		buttons = new CButton[captionList.size()];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new CButton();
			setButtonSize(i, buttonWidths[i], buttonHeights[i]);
			//addAction(i,
				//	(AbstractAction) ReflectionUtil.getObject(actionStrings[i]));
			buttons[i].setText(captionList.get(i));
		}

	}

	public void addActionListner(int index, ActionListener actionListener) {
		if (buttons[index] != null) {
			buttons[index].addActionListener(actionListener);
		}
	}
	
	public void addAction(int index, AbstractAction abstractAction) {
		if (buttons[index] != null) {
			buttons[index].setAction(abstractAction);
		}
	}
	
}
