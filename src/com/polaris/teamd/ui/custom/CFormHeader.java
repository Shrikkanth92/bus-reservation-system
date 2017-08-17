package com.polaris.teamd.ui.custom;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CFormHeader extends JPanel {

	CLabel label = new CLabel();

	public CLabel getLabel() {
		return label;
	}

	public void setLabel(CLabel label) {
		this.label = label;
	}

	public CFormHeader(String label) {
		cSetText(label);
		
	}
	
	public CFormHeader() {
	}

	public CFormHeader(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public CFormHeader(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	public CFormHeader(LayoutManager layout) {
		super(layout);

	}

	public void cSetText(String labelCaption) {
		label.setText(labelCaption);
		//new CUiFactory().setUi(label);
		this.add(label);

	}

}
