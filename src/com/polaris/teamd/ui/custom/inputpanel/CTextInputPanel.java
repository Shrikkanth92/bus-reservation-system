package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.common.validations.CValidator;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.custom.LayoutType;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.common.utils.UIUtil;

public class CTextInputPanel extends JPanel {
	private String captionString,
			errorMessageString = "Validation Error will be displayed here",
			inputString;
	private int labelWidth, labelHeight, errorMessageWidth, errorMessageheight,
			inputWidth, inputHeight;
	private int orientation;
	private int preferredLayout;
	private boolean isMandatory;
	private CLabel captionLabel;
	private CText input;
	private CError errorMessageLabel;
	private CLabel mandatoryLabel;

	/**
	 * This is a default constructor
	 */

	public CTextInputPanel() {

	}

	public CTextInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public CTextInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	public CTextInputPanel(LayoutManager layout) {
		super(layout);

	}

	public String getCaptionString() {
		return captionString;
	}

	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getErrorMessageString() {
		return errorMessageString;
	}

	public void setErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
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

	private void setCaptionText() {
		this.captionLabel.setText(getCaptionString());
	}

	private void setErrorText() {
		this.errorMessageLabel.setText(getErrorMessageString());
	}

	private void setInputText() {
		this.input.setText(getInputString());
	}

	public void setCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	public CLabel getCaptionLabel() {
		return captionLabel;
	}

	public CError getErrorMessageLabel() {
		return errorMessageLabel;
	}

	public void setErrorMessageLabel(CError errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	public void setInput(CText input) {
		this.input = input;
	}

	public CText getInput() {
		return input;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		if (orientation == 1) {
			this.orientation = CUILayoutType.HORIZONTAL;
		}
		if (orientation == 2) {
			this.orientation = CUILayoutType.VERTICAL;
		}
	}

	public void init() {
		CUIFactory cUIFactory = new CUIFactory();
		captionLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);
		cUIFactory.setUI(captionLabel);
		input = (CText) cUIFactory.createUIComponent(CUIComponentType.TEXT);
		cUIFactory.setUI(input);

		errorMessageLabel = (CError) cUIFactory
				.createUIComponent(CUIComponentType.ERROR);
	}

	public int cGetInputAsInteger() {
		return input.cGetIntValue();
	}

	public float cGetInputAsFloat() {
		return input.cGetFloatValue();
	}

	public double cGetInputAsDouble() {
		return input.cGetDoubleValue();
	}

	public void cSetIntInput(int input) {
		this.input.cSetIntValue(input);
	}

	public void cSetFloatInput(float value) {
		this.input.cSetFloatValue(value);
	}

	public void cSetDoubleInput(double value) {
		this.input.cSetDoubleValue(value);
	}

	public void cClearErrorMessage() {
		this.errorMessageLabel.setText(" ");
	}

	private void cSetLabelWidth(int width) {
		Dimension dimension = new Dimension(width, captionLabel.getHeight());
		this.captionLabel.setPreferredSize(dimension);
		this.captionLabel.setMaximumSize(dimension);
		this.captionLabel.setMinimumSize(dimension);
		this.captionLabel.setSize(dimension);
	}

	private void cSetLabelHeight(int height) {
		Dimension dimension = new Dimension(captionLabel.getWidth(), height);
		this.captionLabel.setPreferredSize(dimension);
		this.captionLabel.setMaximumSize(dimension);
		this.captionLabel.setMinimumSize(dimension);
		this.captionLabel.setSize(dimension);

	}

	private void cSetWidth(int width) {
		Dimension dimension = new Dimension(width, this.getHeight());
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setMinimumSize(dimension);
		this.setSize(dimension);
	}

	private void cSetHeight(int height) {
		Dimension dimension = new Dimension(this.getWidth(), height);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setMinimumSize(dimension);
		this.setSize(dimension);
	}

	private void cSetErrorLabelHeight(int rowHeight) {
		Dimension dimension = new Dimension(errorMessageLabel.getWidth(),
				rowHeight);
		errorMessageLabel.setPreferredSize(dimension);

		errorMessageLabel.setMaximumSize(dimension);

		errorMessageLabel.setMinimumSize(dimension);
		errorMessageLabel.setSize(dimension);

	}

	private void cSetErrorLabelWidth(int rowWidth) {
		Dimension dimension = new Dimension(rowWidth,errorMessageLabel.getHeight());
				
		errorMessageLabel.setPreferredSize(dimension);
				
		errorMessageLabel.setMaximumSize(dimension);
		errorMessageLabel.setMinimumSize(dimension);
		errorMessageLabel.setSize(dimension);

	}

	private void cSetInputWidth(int rowWidth) {
		Dimension dimension = new Dimension(rowWidth,input.getHeight());
		input.setPreferredSize(dimension);
		input.setMaximumSize(dimension);
		input.setMinimumSize(dimension);
		input.setSize(dimension);

	}

	private void cSetInputHeight(int height) {
		Dimension dimension = new Dimension(input.getWidth(),height);
		input.setPreferredSize(dimension);
		input.setMaximumSize(dimension);
		input.setMinimumSize(dimension);
		input.setSize(dimension);

	}

	public void cSetSize(int width, int height) {
		cSetWidth(width);
		cSetHeight(height);
	}
	
	private void cSetLabelSize(int width, int height) {
		cSetLabelWidth(width);
		cSetLabelHeight(height);

	}

	public void cSetInputSize(int width, int height) {
		cSetInputHeight(height);
		cSetInputWidth(width);
	}
	
	private void cSetErrorLabelSize(int width, int height) {
		cSetErrorLabelHeight(height);
		cSetErrorLabelWidth(width);

	}

	private void setComponentValues() {
		if (getInputString() != null)
			this.setInputText();
		if (getCaptionString() != null)
			this.setCaptionText();
		if (getErrorMessageString() != null)
			this.setErrorText();
		checkComponentParameters();

	}

	public void cRenderGridBagLayout() {

		setComponentValues();
		
		GridBagLayout gridBagLayout = new GridBagLayout();

		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		Insets insets = new Insets(5, 5, 5, 5);

		setConstraints(captionLabel, gridBagLayout, 0, 0,1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, insets,2, 2);

		this.setLayout(gridBagLayout);
		this.add(captionLabel);

		if (isMandatory() == true) {
		
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);

			setConstraints(mandatoryLabel, gridBagLayout, 1, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 2, 2);
			this.add(mandatoryLabel);
		}

		if (this.orientation == 1) {
			setConstraints(input, gridBagLayout, 2, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
					insets, 2, 2);
			this.add(input);
			setConstraints(errorMessageLabel, gridBagLayout, 3, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST,GridBagConstraints.BOTH, insets, 2, 2);
			this.add(errorMessageLabel);

		}
		if (this.orientation == 2) {
			
			this.setConstraints(input, gridBagLayout, 0, 1, 1, 1, 0, 0,
					GridBagConstraints.WEST,GridBagConstraints.BOTH, insets, 2, 2);
			this.add(input);

			setConstraints(errorMessageLabel, gridBagLayout, 0, 2,1, 1, 0, 0,
					GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 2, 2);

			this.add(errorMessageLabel);

		}
		this.setVisible(true);

	}

	private void setConstraints(JComponent component,
			GridBagLayout gridBagLayout, int gridx, int gridy, double weightx,
			double weighty, int ipadx, int ipady, int anchor, int fill,
			Insets insets, int gridwidth, int gridheight) {
	
		GridBagConstraints gridBagConstraints = new GridBagConstraints(gridx,
				gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
				insets, ipadx, ipady);

		gridBagLayout.setConstraints(component, gridBagConstraints);

	}

	private void checkComponentParameters() {
		if (labelWidth != 0)
			cSetLabelWidth(labelWidth);
		if (labelHeight != 0)
			cSetLabelHeight(labelHeight);
		if (errorMessageWidth != 0)
			cSetErrorLabelWidth(errorMessageWidth);
		if (errorMessageheight != 0)
			cSetErrorLabelHeight(errorMessageheight);
		if (inputWidth != 0)
			cSetInputWidth(inputWidth);
		if (inputHeight != 0)
			cSetInputHeight(inputHeight);
	}

	public void cRenderBoxLayout() {
		setComponentValues();

		checkComponentParameters();
		JPanel panel1,panel2;
		panel1=new JPanel();
		panel2=new JPanel();
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		panel1.add(captionLabel);
		if (this.orientation == 1) {
			Box box = Box.createHorizontalBox();
			panel1.add(captionLabel);
			if (isMandatory() == true) {
				mandatoryLabel = (CLabel) new CUIFactory()
				.createUIComponent(CUIComponentType.LABEL);
		mandatoryLabel.setText("*");
				mandatoryLabel.setForeground(Color.red);
				panel1.add(mandatoryLabel);
			}

			panel2.add(input);
			panel2.add(errorMessageLabel);
			box.add(panel1);
			box.add(panel2);
			this.add(box);

			
		}
		if (this.orientation == 2) {
			Box box = Box.createVerticalBox();
			panel1.add(captionLabel);
			if (isMandatory() == true) {
				mandatoryLabel = (CLabel) new CUIFactory()
				.createUIComponent(CUIComponentType.LABEL);
		mandatoryLabel.setText("*");
				mandatoryLabel.setForeground(Color.red);
				panel1.add(mandatoryLabel);
			}

			panel2.add(input);
			panel2.add(errorMessageLabel);
			box.add(panel1);
			box.add(panel2);
			this.add(box);
			
		}
		this.setVisible(true);
	}

	public void cRenderFlowLayout() {
		setComponentValues();
		checkComponentParameters();

		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		this.add(captionLabel);
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
			.createUIComponent(CUIComponentType.LABEL);
	mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);
			this.add(mandatoryLabel);
		}

		this.add(input);

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
			.createUIComponent(CUIComponentType.LABEL);
	mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);
			panel1.add(mandatoryLabel);
		}
		panel1.add(input);
		panel2.add(errorMessageLabel);
		if(orientation==CUILayoutType.HORIZONTAL){
		this.add(panel1, borderLayout.CENTER);
		this.add(panel2, borderLayout.EAST);
		}
		if(orientation==CUILayoutType.VERTICAL){
			this.add(panel1, borderLayout.CENTER);
			this.add(panel2, borderLayout.SOUTH);
		}
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

	
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

	public void addFocusListner(FocusListener focusListener) {
		if (input != null)
			input.addFocusListener(focusListener);
	}

	public void addActionListner(ActionListener actionListener) {
		if (input != null)
			input.addActionListener(actionListener);
	}

	public void addMouseListner(MouseListener mouseListener) {
		if (input != null)
			input.addMouseListener(mouseListener);
	}


	public void showError() {
		if (errorMessageLabel != null) {

			this.errorMessageLabel.setForeground(Color.RED);
		}

	}

	

	
}