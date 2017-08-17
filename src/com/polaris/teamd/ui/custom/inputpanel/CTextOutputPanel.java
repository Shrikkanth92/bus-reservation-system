package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;

public class CTextOutputPanel extends JPanel {
	private String captionString, inputString, separatorString;
	private int labelWidth, labelHeight, outputWidth, outputHeight,
			separatorWidth, separatorHeight;
	private int orientation;
	private int preferredLayout;

	private CLabel captionLabel;
	private CLabel outputLabel;

	private CLabel separatorLabel;

	public String getCaptionString() {
		return captionString;
	}

	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	public String getOutputString() {
		return inputString;
	}

	public void setOutputString(String inputString) {
		this.inputString = inputString;
	}

	public String getSeparatorString() {
		return separatorString;
	}

	public void setSeparatorString(String separatorString) {
		this.separatorString = separatorString;
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}

	public int getLabelHeight() {
		return labelHeight;
	}

	public void setLabelHeight(int labelHeight) {
		this.labelHeight = labelHeight;
	}

	public int getOutputWidth() {
		return outputWidth;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public int getOutputHeight() {
		return outputHeight;
	}

	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}

	public int getSeparatorWidth() {
		return separatorWidth;
	}

	public void setSeparatorWidth(int separatorWidth) {
		this.separatorWidth = separatorWidth;
	}

	public int getSeparatorHeight() {
		return separatorHeight;
	}

	public void setSeparatorHeight(int separatorHeight) {
		this.separatorHeight = separatorHeight;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	public CLabel getCaptionLabel() {
		return captionLabel;
	}

	public void setCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	public CLabel getOutput() {
		return outputLabel;
	}

	public void setOutput(CLabel input) {
		this.outputLabel = input;
	}

	public CLabel getSeparatorLabel() {
		return separatorLabel;
	}

	public void setSeparatorLabel(CLabel separatorLabel) {
		this.separatorLabel = separatorLabel;
	}

	private void setSeparatorText() {
		this.separatorLabel.setText(getSeparatorString());
	}

	private void setCaptionText() {
		this.captionLabel.setText(getCaptionString());
	}

	private void setOutputText() {
		this.outputLabel.setText(getOutputString());
	}

	private void setCaptionLabelWidth(int width) {
		Dimension dimension = new Dimension(width, getLabelHeight());
		captionLabel.setPreferredSize(dimension);
		captionLabel.setMaximumSize(dimension);
		captionLabel.setMinimumSize(dimension);
	}

	private void setOutputLabelWidth(int width) {
		Dimension dimension = new Dimension(width, getOutputHeight());
		outputLabel.setPreferredSize(dimension);
		outputLabel.setMaximumSize(dimension);
		outputLabel.setMinimumSize(dimension);
	}

	private void setSeparatorLabelWidth(int width) {
		Dimension dimension = new Dimension(width, getSeparatorHeight());
		separatorLabel.setPreferredSize(dimension);
		separatorLabel.setMaximumSize(dimension);
		separatorLabel.setMinimumSize(dimension);
	}

	private void setCaptionLabelHeight(int height) {
		Dimension dimension = new Dimension(getLabelWidth(), height);
		captionLabel.setPreferredSize(dimension);
		captionLabel.setMaximumSize(dimension);
		captionLabel.setMinimumSize(dimension);
	}

	private void setOutputLabelHeight(int height) {
		Dimension dimension = new Dimension(getOutputWidth(), height);
		outputLabel.setPreferredSize(dimension);
		outputLabel.setMaximumSize(dimension);
		outputLabel.setMinimumSize(dimension);
	}

	private void setSeparatorLabelHeight(int height) {
		Dimension dimension = new Dimension(getSeparatorWidth(), height);
		separatorLabel.setPreferredSize(dimension);
		separatorLabel.setMaximumSize(dimension);
		separatorLabel.setMinimumSize(dimension);
	}

	private void setCaptionLabelSize(int width, int height) {
		setCaptionLabelWidth(width);
		setCaptionLabelHeight(height);
	}

	private void setInputLabelWidth(int width, int height) {
		setOutputLabelWidth(width);
		setOutputLabelHeight(height);
	}

	private void setSeparatorLabelSize(int width, int height) {
		setSeparatorLabelWidth(width);
		setSeparatorLabelHeight(height);
	}

	private void checkComponentParameters() {
		if (labelWidth != 0)
			setLabelWidth(getLabelWidth());
		if (labelHeight != 0)
			setLabelHeight(getLabelHeight());
		if (separatorWidth != 0)
			setSeparatorLabelWidth(getSeparatorWidth());
		if (separatorHeight != 0)
			setSeparatorHeight(getSeparatorHeight());
		if (outputWidth != 0)
			setOutputLabelWidth(getOutputWidth());
		if (outputHeight != 0)
			setOutputHeight(getOutputHeight());
	}

	public void init() {
		CUIFactory cUIFactory = new CUIFactory();
		captionLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);
		cUIFactory.setUI(captionLabel);
		outputLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);
		cUIFactory.setUI(outputLabel);
		separatorLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);
		cUIFactory.setUI(captionLabel);

	}

	public void setComponentValues() {
		if (getOutputString() != null)
			setOutputText();
		if (getCaptionString() != null)
			setCaptionText();
		if (getSeparatorString() != null)
			setSeparatorText();

	}

	public void cRenderFlowLayout() {
		setComponentValues();
		checkComponentParameters();
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		this.add(captionLabel);
		if (separatorLabel != null)
			this.add(separatorLabel);
		this.add(outputLabel);

	}

	public void cRenderGridBagLayout() {

		setComponentValues();

		GridBagLayout gridBagLayout = new GridBagLayout();
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		Insets insets = new Insets(5, 5, 5, 5);
		setConstraints(captionLabel, gridBagLayout, 0, 0, 0, 0, 0, 0,
				GridBagConstraints.CENTER, 0, insets, 0, 0);
		this.setLayout(gridBagLayout);
		this.add(captionLabel);
		if (separatorLabel != null) {
			setConstraints(separatorLabel, gridBagLayout, 1, 0, 0, 0, 0, 0,
					GridBagConstraints.EAST, 0, insets, 0, 0);
			this.add(separatorLabel);
		}

		if (this.orientation == 1) {
			setConstraints(outputLabel, gridBagLayout, 2, 0, 0, 0, 0, 0, GridBagConstraints.EAST, 0,
					insets, 0, 0);
			this.add(outputLabel);

		}
		if (this.orientation == 2) {
			this.setConstraints(outputLabel, gridBagLayout, 0, 1, 0, 0, 0, 0,
					GridBagConstraints.EAST, 0, insets, 0, 0);
			this.add(outputLabel);

		}
		this.setVisible(true);

	}

	private void setConstraints(JComponent component,
			GridBagLayout gridBagLayout, int gridx, int gridy, double weightx,
			double weighty, int ipadx, int ipady, int anchor, int fill,
			Insets insets, int gridwidth, int gridheight) {
		System.out.println(anchor);
		GridBagConstraints gridBagConstraints = new GridBagConstraints(gridx,
				gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
				insets, ipadx, ipady);

		gridBagLayout.setConstraints(component, gridBagConstraints);

	}

	public void cRenderBoxLayout() {
		setComponentValues();
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		JPanel panel1, panel2;
		panel1 = new JPanel();
		panel2 = new JPanel();
		if (this.orientation == 1) {
			Box box = Box.createHorizontalBox();
			panel1.add(captionLabel);
			if (separatorLabel != null) {

				panel1.add(separatorLabel);
			}

			panel2.add(outputLabel);
			box.add(panel1);
			box.add(panel2);
			this.add(box);

		}
		if (this.orientation == 2) {
			Box box = Box.createVerticalBox();
			panel1.add(captionLabel);
			if (separatorLabel != null) {
				panel1.add(separatorLabel);
			}
			panel2.add(outputLabel);
			box.add(panel1);
			box.add(panel2);
			this.add(box);

		}
		this.setVisible(true);
	}

	public void cRenderBorderLayout() {
		setComponentValues();
		JPanel panel1, panel2;
		panel1 = new JPanel();
		panel2 = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		this.setLayout(borderLayout);
		panel1.add(captionLabel);
		if (separatorLabel != null) {

			panel1.add(separatorLabel);
		}
		panel2.add(outputLabel);

		this.add(panel1, borderLayout.CENTER);
		this.add(panel2, borderLayout.SOUTH);

	}

	public void refresh() {
		this.removeAll();
		init();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout ==CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if (preferredLayout ==CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
	}

}
