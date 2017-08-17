package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.polaris.teamd.ui.CLayoutPreferences;

public class CComboPairInputPanel extends JPanel {

	private CComboInputPanel combo1, combo2;
	private String captionString1, captionString2, inputString1, inputString2,
			errorMessageString1 = "Error message",
			errorMessageString2 = "Error message";

	private int orientation = 1;
	private boolean isMandatory;
	private int preferredLayout;
	private Dimension captionDimension, inputDimension, errorDimension;

	public CComboInputPanel getCombo1() {
		return combo1;
	}

	public void setCombo1(CComboInputPanel combo1) {
		this.combo1 = combo1;
	}

	public CComboInputPanel getCombo2() {
		return combo2;
	}

	public void setCombo2(CComboInputPanel combo2) {
		this.combo2 = combo2;
	}

	public String getCaptionString1() {
		return captionString1;
	}

	public void setCaptionString1(String captionString1) {
		this.captionString1 = captionString1;
	}

	public String getCaptionString2() {
		return captionString2;
	}

	public void setCaptionString2(String captionString2) {
		this.captionString2 = captionString2;
	}

	public String getInputString1() {
		return inputString1;
	}

	public void setInputString1(String inputString1) {
		this.inputString1 = inputString1;
	}

	public String getInputString2() {
		return inputString2;
	}

	public void setInputString2(String inputString2) {
		this.inputString2 = inputString2;
	}

	public String getErrorMessageString1() {
		return errorMessageString1;
	}

	public void setErrorMessageString1(String errorMessageString1) {
		this.errorMessageString1 = errorMessageString1;
	}

	public String getErrorMessageString2() {
		return errorMessageString2;
	}

	public void setErrorMessageString2(String errorMessageString2) {
		this.errorMessageString2 = errorMessageString2;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	public Dimension getCaptionDimension() {
		return captionDimension;
	}

	public void setCaptionDimension(Dimension captionDimension) {
		this.captionDimension = captionDimension;
	}

	public Dimension getInputDimension() {
		return inputDimension;
	}

	public void setInputDimension(Dimension inputDimension) {
		this.inputDimension = inputDimension;
	}

	public Dimension getErrorDimension() {
		return errorDimension;
	}

	public void setErrorDimension(Dimension errorDimension) {
		this.errorDimension = errorDimension;
	}

	private void init() {
		combo1 = new CComboInputPanel();
		combo2 = new CComboInputPanel();
	}

	public void cRenderFlowLayout() {
		this.setLayout(new FlowLayout());
		init();
		if (isMandatory == true) {
			combo1.setMandatory(true);
			combo2.setMandatory(true);
		}

		setComponentValue();
		setComponentSize();
		combo1.cRenderFlowLayout();
		combo2.cRenderFlowLayout();
		addComponents();
	}

	public void refresh() {
		this.removeAll();
		init();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		// if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
		// cRenderBorderLayout();
		// if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
		// cRenderBoxLayout();
		// if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
		// cRenderGridBagLayout();
	}

	private void setComponentValue() {
		combo1.setCaptionString(captionString1);
		combo2.setCaptionString(captionString2);

		combo1.setInputString(inputString1);
		combo2.setInputString(inputString2);

		combo1.setErrorMessageString(errorMessageString1);
		combo2.setErrorMessageString(errorMessageString2);
		
	}

	private void setComponentSize() {

		combo1.setCaptionDimension(captionDimension);
		combo1.setInputDimension(inputDimension);
		combo1.setErrorDimension(errorDimension);
		
		combo2.setCaptionDimension(captionDimension);
		combo2.setInputDimension(inputDimension);
		combo2.setErrorDimension(errorDimension);
	}

	private void addComponents() {
		this.add(combo1);
		this.add(combo2);
	}
	


	/**
	 * This function is used to hide the panel.
	 */

	@Override
	public void hide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	/**
	 * This function is used to show the panel.
	 */

	@Override
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

	/**
	 * This function is used to hide the error on the screen
	 */

	public void hideError() {
		if (combo1.getErrorMessage() != null)
			this.combo1.getErrorMessage().setForeground(this.getBackground());
		if (combo2.getErrorMessage() != null)
			this.combo2.getErrorMessage().setForeground(this.getBackground());

	}

	/**
	 * This function is used to display the error message.
	 */
	public void showError() {
		if (combo1.getErrorMessage() != null)
			this.combo1.getErrorMessage().setForeground(Color.red);
		if (combo2.getErrorMessage() != null)
			this.combo2.getErrorMessage().setForeground(Color.red);
	}

	
}
