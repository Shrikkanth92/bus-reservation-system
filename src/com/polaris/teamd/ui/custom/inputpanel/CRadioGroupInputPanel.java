package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CRadioGroup;

/**
 * 
 * @author nireesha.patnam
 * 
 */
public class CRadioGroupInputPanel extends JPanel {

	private String captionString,
			errorMessageString = "Validation Error will be displayed here",
			inputString;
	private int labelWidth, labelHeight, errorMessageWidth, errorMessageheight,
			inputWidth, inputHeight;
	private int orientation;
	private int preferredLayout;
	private boolean isMandatory;
	private CLabel captionLabel, mandatoryLabel;
	private CRadioGroup radioGroup;
	private CError errorMessageLabel;

	public CRadioGroupInputPanel() {
		super();

	}

	public CRadioGroupInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public CRadioGroupInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	public CRadioGroupInputPanel(LayoutManager layout) {
		super(layout);

	}

	public String getCaptionString() {
		return captionString;
	}

	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	public String getErrorMessageString() {
		return errorMessageString;
	}

	public void setErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
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

	public int getErrorMessageWidth() {
		return errorMessageWidth;
	}

	public void setErrorMessageWidth(int errorMessageWidth) {
		this.errorMessageWidth = errorMessageWidth;
	}

	public int getErrorMessageheight() {
		return errorMessageheight;
	}

	public void setErrorMessageheight(int errorMessageheight) {
		this.errorMessageheight = errorMessageheight;
	}

	public int getInputWidth() {
		return inputWidth;
	}

	public void setInputWidth(int inputWidth) {
		this.inputWidth = inputWidth;
	}

	public int getInputHeight() {
		return inputHeight;
	}

	public void setInputHeight(int inputHeight) {
		this.inputHeight = inputHeight;
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

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public CLabel getCaptionLabel() {
		return captionLabel;
	}

	public void setCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	public CRadioGroup getRadioGroup() {
		return radioGroup;
	}

	public void setRadioGroup(CRadioGroup radioGroup) {
		this.radioGroup = radioGroup;
	}

	public CError getErrorMessageLabel() {
		return errorMessageLabel;
	}

	public void setErrorMessageLabel(CError errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	public void cSetCaption(String caption) {
		this.captionLabel.setText(caption);
	}

	public void cSetErrorMessage(String message) {
		this.errorMessageLabel.setText(message);
	}

	public void init() {

		CUIFactory cUIFactory = new CUIFactory();
		captionLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);

		cUIFactory.setUI(captionLabel);

		errorMessageLabel = (CError) cUIFactory
				.createUIComponent(CUIComponentType.ERROR);

		radioGroup = (CRadioGroup) cUIFactory
				.createUIComponent(CUIComponentType.RADIOGROUP);
		radioGroup = (CRadioGroup) cUIFactory.setUI(radioGroup);
	}

	private void cSetLabelWidth(int width) {

		this.captionLabel.setPreferredSize(new Dimension(width,
				this.captionLabel.getHeight()));
		this.captionLabel.setMaximumSize(new Dimension(width, this.captionLabel
				.getHeight()));
		this.captionLabel.setMinimumSize(new Dimension(width, this.captionLabel
				.getHeight()));
		this.captionLabel.setSize(new Dimension(width, this.captionLabel
				.getHeight()));
	}

	private void cSetLabelHeight(int height) {
		this.captionLabel.setPreferredSize(new Dimension(this.captionLabel
				.getWidth(), height));
		this.captionLabel.setMaximumSize(new Dimension(this.captionLabel
				.getWidth(), height));
		this.captionLabel.setMinimumSize(new Dimension(this.captionLabel
				.getWidth(), height));
		this.captionLabel.setSize(new Dimension(this.captionLabel.getWidth(),
				height));
	}

	public void cSetWidth(int width) {
		this.setPreferredSize(new Dimension(width, this.getHeight()));
		this.setMaximumSize(new Dimension(width, this.getHeight()));
		this.setMinimumSize(new Dimension(width, this.getHeight()));
		this.setSize(new Dimension(width, this.getHeight()));
	}

	public void cSetHeight(int height) {
		this.setPreferredSize(new Dimension(this.getWidth(), height));
		this.setMaximumSize(new Dimension(this.getWidth(), height));
		this.setMinimumSize(new Dimension(this.getWidth(), height));
		this.setSize(new Dimension(this.getWidth(), height));
	}

	private void cSetErrorLabelHeight(int rowHeight) {
		errorMessageLabel.setPreferredSize(new Dimension(errorMessageLabel
				.getWidth(), rowHeight));
		errorMessageLabel.setMaximumSize(new Dimension(errorMessageLabel
				.getWidth(), rowHeight));
		errorMessageLabel.setMinimumSize(new Dimension(errorMessageLabel
				.getWidth(), rowHeight));
		errorMessageLabel.setSize(new Dimension(errorMessageLabel.getWidth(),
				rowHeight));

	}

	private void cSetErrorLabelWidth(int rowWidth) {
		errorMessageLabel.setPreferredSize(new Dimension(rowWidth,
				errorMessageLabel.getHeight()));
		errorMessageLabel.setMaximumSize(new Dimension(rowWidth,
				errorMessageLabel.getHeight()));
		errorMessageLabel.setMinimumSize(new Dimension(rowWidth,
				errorMessageLabel.getHeight()));
		errorMessageLabel.setSize(new Dimension(rowWidth, errorMessageLabel
				.getHeight()));

	}

	public void cSetSize(int width, int height) {
		cSetWidth(width);
		cSetHeight(height);
	}

	public void cSetLabelSize(int width, int height) {
		cSetLabelWidth(width);
		cSetLabelHeight(height);

	}

	public void cSetErrorLabelSize(int width, int height) {
		cSetErrorLabelHeight(height);
		cSetErrorLabelWidth(width);

	}

	public void setComponentValues() {
		this.cSetCaption(getCaptionString());
		this.cSetErrorMessage(getErrorMessageString());
		checkComponentParameters();

	}

	public void cRenderGridBagLayout() {

		setComponentValues();
		CLabel mandatoryLabel = null;
		GridBagLayout gridBagLayout = new GridBagLayout();

		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		Insets insets = new Insets(5, 5, 5, 5);

		setConstraints(captionLabel, 0, 0, 0.1, 0.1, 1, 1, 1, 1);

		this.setLayout(gridBagLayout);
		this.add(captionLabel);

		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.MANDATORYINDICATOR);
			mandatoryLabel.setForeground(Color.red);

			setConstraints(mandatoryLabel, 0, 1, 0.1, 0.1, 1, 1, 1, 1);
			this.add(mandatoryLabel);
		}

		if (this.orientation == CUILayoutType.HORIZONTAL) {
			setConstraints(radioGroup, 0, 2, 0.1, 0.1, 1, 1, 1, 1);
			this.add(radioGroup);
			setConstraints(errorMessageLabel, 0, 3, 0.1, 0.1, 1, 1, 1, 1);
			this.add(errorMessageLabel);

		}
		if (this.orientation == CUILayoutType.VERTICAL) {
			setConstraints(radioGroup, 0, 1, 0.1, 0.1, 1, 1, 1, 1);
			this.add(radioGroup);
			setConstraints(errorMessageLabel, 0, 2, 0.1, 0.1, 1, 1, 1, 1);
			this.add(errorMessageLabel);

		}
		this.setVisible(true);

	}

	public void setConstraints(JComponent component, int gridx, int gridy,
			double weightx, double weighty, int gridwidth, int gridheight,
			int ipadx, int ipady) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.ipadx = ipadx;
		gbc.ipady = ipady;
		gbc.insets = new Insets(5, 5, 5, 5);
		if (this.orientation == 1)
			gbc.fill = GridBagConstraints.HORIZONTAL;
		if (this.orientation == 2)
			gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gridBagLayout.setConstraints(component, gbc);
	}

	private void checkComponentParameters() {
		if (labelWidth != 0)
			cSetLabelWidth(labelWidth);
		if (labelHeight != 0)
			cSetLabelWidth(labelHeight);
		if (errorMessageWidth != 0)
			cSetErrorLabelWidth(errorMessageWidth);
		if (errorMessageheight != 0)
			cSetErrorLabelHeight(errorMessageheight);

	}

	public void cRenderBoxLayout() {
		setComponentValues();
		checkComponentParameters();
		CLabel mandatoryLabel = null;
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);

		if (this.orientation == CUILayoutType.HORIZONTAL) {
			Box box = Box.createHorizontalBox();
			box.add(captionLabel);
			if (isMandatory() == true) {
				mandatoryLabel = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.MANDATORYINDICATOR);
				mandatoryLabel.setForeground(Color.red);
				box.add(mandatoryLabel);
			}

			box.add(radioGroup);
			box.add(errorMessageLabel);
			this.add(box);

			this.setVisible(true);
		}
		if (this.orientation == CUILayoutType.VERTICAL) {
			Box box = Box.createVerticalBox();
			box.add(captionLabel);
			if (isMandatory() == true) {
				mandatoryLabel = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.MANDATORYINDICATOR);
				mandatoryLabel.setForeground(Color.red);
				box.add(mandatoryLabel);
			}

			box.add(radioGroup);
			box.add(errorMessageLabel);
			this.add(box);
			this.setVisible(true);
		}

	}

	public void cRenderFlowLayout() {
		setComponentValues();
		checkComponentParameters();

		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		this.add(captionLabel);
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.MANDATORYINDICATOR);
			mandatoryLabel.setForeground(Color.red);
			this.add(mandatoryLabel);
		}

		this.add(radioGroup);

		this.add(errorMessageLabel);

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
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.MANDATORYINDICATOR);
			mandatoryLabel.setForeground(Color.red);
			panel1.add(mandatoryLabel);
		}
		panel1.add(radioGroup);
		panel2.add(errorMessageLabel);
		this.add(panel1, borderLayout.CENTER);
		this.add(panel2, borderLayout.SOUTH);

	}

	public void refresh() {
		this.removeAll();
		init();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
	}

	/**
	 * This method is to hide the panel
	 */
	@Override
	public void hide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	public void hideError() {
		if (errorMessageLabel != null)
			this.errorMessageLabel.setForeground(this.getBackground());

	}

	/**
	 * This method is to show the panel
	 */

	@Override
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

	public void showErrorMessage() {
		if (errorMessageLabel != null) {

			this.errorMessageLabel.setBackground(Color.RED);
		}

	}

}
