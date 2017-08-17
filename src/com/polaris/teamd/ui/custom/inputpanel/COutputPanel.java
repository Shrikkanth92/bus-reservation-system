package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.lang.reflect.Method;

import javax.print.attribute.standard.MediaSize.Other;

import com.polaris.teamd.common.utils.UIUtil;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;

public class COutputPanel extends CInputPanel {
	CLabel caption;
	CLabel output;
	int orientation;
	GridBagLayout gridBagLayout;
	GridBagConstraints gbc;

	private CUIFactory CUIFactory = new CUIFactory();

	public COutputPanel() {
		caption = (CLabel) new CUIFactory()
				.createUIComponent(CUIComponentType.LABEL);
		output = (CLabel) new CUIFactory()
				.createUIComponent(CUIComponentType.LABEL);

		this.add(caption);
		this.add(output);

	}

	public void setCaption(String caption){
		this.caption.setText(caption);
	}
	
	public void setOutput(String output){
		this.output.setText(output);
	}
	public void setOrientation(int orientation) {
		if (orientation == 1) {
			this.orientation = CUILayoutType.HORIZONTAL;
		}
		if (orientation == 2) {
			this.orientation = CUILayoutType.VERTICAL;
		}
	}

	@Override
	public void addValidators(FocusListener focusListener) {
	}

	@Override
	public void cSetErrorMessage(String message) {
	}

	@Override
	public void cClearErrorMessage() {
	}

	@Override
	public void cSetTargetBean(String propertyKey) {
	}

	@Override
	public void cSetTarget() {
	}

	@Override
	public void cSetTargetProperty(String propertyName) {
	}

	@Override
	public void setData(Object object) {
	}

	@Override
	public void cRender() {
		gridBagLayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gridBagLayout);
		caption.setHorizontalAlignment(CLabel.RIGHT);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 2, 150);
		gridBagLayout.setConstraints(caption, gbc);
		this.add(caption);

		if (this.orientation == 1) {
			gbc.gridx = 2;
			gbc.gridy = 0;
			gridBagLayout.setConstraints(output, gbc);
			this.add(output);
			// this.setVisible(true);
		} else {
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridBagLayout.setConstraints(output, gbc);
			this.add(output);
			// this.setVisible(true);
		}
		System.out.println("rendered");
	}

	@Override
	public void setColumnLength(int columnLength) {
	}

	@Override
	public void cRender(int top, int left, int bottom, int right) {
	}

	@Override
	public void cSetLabelSize(int width, int height) {
		caption.setSize(width, height);
		caption.setPreferredSize(new Dimension(width, height));
		caption.setMinimumSize(new Dimension(width, height));
		caption.setMaximumSize(new Dimension(width, height));
	}

	@Override
	public void cSetInputSize(int width, int height) {
	}

	@Override
	public void cSetErrorLabelSize(int width, int height) {
	}

	@Override
	public void hide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	@Override
	public void hideError() {
	}

	@Override
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

}
