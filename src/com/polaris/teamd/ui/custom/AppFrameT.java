package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.inputpanel.CSpinnerInputPanel;

public class AppFrameT extends JFrame {
	public AppFrameT() {
		setFlowLayout();
		CSpinnerInputPanel panel = new CSpinnerInputPanel();
		SpinnerModel currentValue = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
		panel.setCaptionString("Value");
		panel.setErrorMessageString("Wrong Value is used");
		panel.cSetSpinnerSize(50, 20);
		panel.setCurrentValue(currentValue);
		panel.cSetCaptionSize(50, 20);

		panel.cSetErrorLabelSize(120, 20);
		panel.setMandatory(true);
		panel.setOrientation(CUILayoutType.VERTICAL);
		panel.cRenderBorderLayout();
		addComponent(panel);
		showFrame("");
	}

	public void addComponent(JComponent component) {
		this.getContentPane().add(component);
	}

	public void setFlowLayout() {
		this.getContentPane().setLayout(new FlowLayout());
	}

	public void setBorederLayout() {
		this.getContentPane().setLayout(new BorderLayout());
	}

	public void setCardLayout() {
		this.getContentPane().setLayout(new CardLayout());
	}

	public void setGridLayout() {
		this.getContentPane().setLayout(new GridLayout());
	}

	public void setGridBagLayout() {
		this.getContentPane().setLayout(new GridBagLayout());
	}

	public void showFrame(String title) {
		this.setTitle(title);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
