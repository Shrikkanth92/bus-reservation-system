package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CMultiText;

/**
 * 
 * @author Gowtham
 * 
 *         This class creates the multitext input panel with one label and
 *         multiple text fields
 * 
 */
public class CMultiTextInputPanel extends JPanel {

	private CLabel captionLabel, mandatoryLabel;
	private CMultiText multiText;
	private CError errorMessageLabel;
	private String labelString,
			errorString = "Validation error will be displayed here",
			concatenatedString;
	private int orientation;
	private int errorMessageOrientation;
	private boolean isMandatory;
	private int captionLabelWidth, captionLabelHeight, multiTextHeight,
			multiTextWidth, errorMessageHeight, errorMessageWidth,
			columnLength = 13;
	private int preferredLayout;

	/**
	 * This is a default constructor
	 */
	public CMultiTextInputPanel() {
	}

	public CMultiText getMultiText() {
		return multiText;
	}

	public void setMultiText(CMultiText multiText) {
		this.multiText = multiText;
	}

	public CLabel getCaptionLabel() {
		return captionLabel;
	}

	public void setCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	public CError getErrorMessageLabel() {
		return errorMessageLabel;
	}

	public void setErrorMessageLabel(CError errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	public String getLabelString() {
		return labelString;
	}

	public void setLabelString(String labelString) {
		this.labelString = labelString;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public int getCaptionLabelWidth() {
		return captionLabelWidth;
	}

	public void setCaptionLabelWidth(int captionLabelRowWidth) {
		this.captionLabelWidth = captionLabelRowWidth;
	}

	public int getCaptionLabelHeight() {
		return captionLabelHeight;
	}

	public void setCaptionLabelHeight(int captionLabelHeight) {
		this.captionLabelHeight = captionLabelHeight;
	}

	public int getMultiTextHeight() {
		return multiTextHeight;
	}

	public void setMultiTextHeight(int multiTextHeight) {
		this.multiTextHeight = multiTextHeight;
	}

	public int getMultiTextWidth() {
		return multiTextWidth;
	}

	public void setMultiTextWidth(int multiTextWidth) {
		this.multiTextWidth = multiTextWidth;
	}

	public int getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(int columnLength) {
		this.columnLength = columnLength;
	}

	public int getErrorMessageHeight() {
		return errorMessageHeight;
	}

	public void setErrorMessageHeight(int errorMessageHeight) {
		this.errorMessageHeight = errorMessageHeight;
	}

	public int getErrorMessageWidth() {
		return errorMessageWidth;
	}

	public void setErrorMessageWidth(int errorMessageWidth) {
		this.errorMessageWidth = errorMessageWidth;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getErrorMessageOrientation() {
		return errorMessageOrientation;
	}

	public void setErrorMessageOrientation(int errorMessageOrientation) {
		this.errorMessageOrientation = errorMessageOrientation;
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	/**
	 * This function concatenates the string entered in the textfields
	 * 
	 * @return- This function returns the concatenated string
	 */
	public String cGetConcatenatedString() {
		if (multiText != null)
			this.concatenatedString = multiText.getConcatenatedString();
		return concatenatedString;
	}

	/**
	 * This function sets the message passed in the textfields
	 * 
	 * @param message
	 * 
	 */
	public void cSetConcatenatedString(String message) {
		multiText.setWithConcatenatedString(message);
	}

	/**
	 * This function sets the specified height and width of the label
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetLabelSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		captionLabel.setPreferredSize(dimension);
		captionLabel.setMaximumSize(dimension);
		captionLabel.setMinimumSize(dimension);
		captionLabel.setSize(width, height);
	}

	/**
	 * This function sets the specified height and width of the text field
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetmultiTextSize(int width, int height) {
		multiText.cSetSize(width, height, 0, multiText.getNumberOfTexts());

	}

	/**
	 * This function sets the specified height and width of the error message
	 * label
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetErrorMessageLabelSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		errorMessageLabel.setPreferredSize(dimension);
		errorMessageLabel.setMaximumSize(dimension);
		errorMessageLabel.setMinimumSize(dimension);
		errorMessageLabel.setSize(width, height);
	}

	/**
	 * This function initializes the objects for the label and error message
	 */
	public void init() {

		CUIFactory cuiFactory = new CUIFactory();
		if (captionLabel == null) {
			captionLabel = (CLabel) cuiFactory
					.createUIComponent(CUIComponentType.LABEL);
			captionLabel = (CLabel) cuiFactory.setUI(captionLabel);
		}
		if (multiText == null) {
			multiText = (CMultiText) cuiFactory
					.createUIComponent(CUIComponentType.MULTITEXT);
			multiText = (CMultiText) cuiFactory.setUI(multiText);
		}

		if (errorMessageLabel == null)
			errorMessageLabel = (CError) cuiFactory
					.createUIComponent(CUIComponentType.ERROR);

	}

	/**
	 * This function checks for the size requirements and calls the
	 * corresponding functions
	 */
	private void setComponentAttributes() {

		if (captionLabel != null) {

			if (captionLabelWidth != 0 && captionLabelHeight == 0)
				cSetLabelSize(captionLabelWidth, captionLabel.getHeight());
			if (captionLabelWidth == 0 && captionLabelHeight != 0)
				cSetLabelSize(captionLabel.getWidth(), captionLabelHeight);
			if (captionLabelWidth != 0 && captionLabelHeight != 0)
				cSetLabelSize(captionLabelWidth, captionLabelHeight);
			captionLabel.setText(labelString);
		}

		if (errorMessageLabel != null) {
			if (errorMessageHeight != 0 && errorMessageWidth == 0)
				cSetErrorMessageLabelSize(errorMessageLabel.getWidth(),
						errorMessageHeight);
			if (errorMessageHeight == 0 && errorMessageWidth != 0)
				cSetErrorMessageLabelSize(errorMessageWidth,
						errorMessageLabel.getHeight());
			if (errorMessageHeight != 0 && errorMessageWidth != 0)
				cSetErrorMessageLabelSize(errorMessageWidth, errorMessageHeight);
			// errorMessageLabel.setForeground(this.getBackground());
			errorMessageLabel.setText(errorString);
		}

		if (multiText != null) {
			multiText.initialise();
			multiText.render();
			multiText.setColumnLength(this.columnLength, 0,
					multiText.getNumberOfTexts());
			// if (multiTextHeight != 0 && multiTextWidth == 0)
			// cSetmultiTextSize(multiText.getWidth(), multiTextHeight);
			// if (multiTextHeight == 0 && multiTextWidth != 0)
			// cSetmultiTextSize(multiTextWidth, multiText.getHeight());
			if (multiTextHeight != 0 && multiTextWidth != 0) {
				cSetmultiTextSize(multiTextWidth, multiTextHeight);
			}

			if (concatenatedString != null)
				multiText.setWithConcatenatedString(concatenatedString);

		}
	}

	/**
	 * This function creates a panel for the label and mandatory symbol
	 * 
	 * @return- This function returns the JPanel
	 */
	private JPanel getLabelPanel() {
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		labelPanel.add(captionLabel);
		if (this.isMandatory) {
			mandatoryLabel = new CLabel("*");
			mandatoryLabel.setForeground(Color.RED);
			labelPanel.add(mandatoryLabel);
		}
		return labelPanel;
	}

	/**
	 * This function renders the multitext input panel in the flowlayout
	 */
	public void cRenderFlowLayout() {

		setComponentAttributes();

		JPanel labelPanel = getLabelPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 10, 10);
		this.setLayout(flowLayout);
		this.add(labelPanel);

		if (this.isMandatory) {

			this.add(mandatoryLabel);
		}
		this.add(multiText);
		this.add(errorMessageLabel);
	}

	/**
	 * This function renders the multitext input panel in the gridbaglayout
	 * based on the orientation
	 */
	public void cRenderGridBagLayout() {

		setComponentAttributes();

		GridBagLayout gridBagLayout = new GridBagLayout();

		JPanel labelPanel = getLabelPanel();
		this.setLayout(gridBagLayout);
		cSetConstraints(gridBagLayout, labelPanel, 0, 0, 0, 0, 1, 1);
		this.add(labelPanel);

		if (this.orientation == 1) {
			cSetConstraints(gridBagLayout, multiText, 1, 0, 0, 0, 1, 1);
			this.add(multiText);
			if (this.errorMessageOrientation == 1) {
				cSetConstraints(gridBagLayout, errorMessageLabel, 2, 0, 0, 0,
						1, 1);
				this.add(errorMessageLabel);
			} else {
				cSetConstraints(gridBagLayout, errorMessageLabel, 1,
						multiText.getNumberOfTexts() + 1, 0, 0, 1, 1);
				this.add(errorMessageLabel);
			}
		}
		if (this.orientation == 2) {
			cSetConstraints(gridBagLayout, multiText, 0, 1, 0, 0, 1,
					multiText.getNumberOfTexts());
			this.add(multiText);

			if (this.errorMessageOrientation == 1) {
				cSetConstraints(gridBagLayout, errorMessageLabel, 1, 1, 0, 0,
						1, 1);
				this.add(errorMessageLabel);
			} else {
				cSetConstraints(gridBagLayout, errorMessageLabel, 0,
						multiText.getNumberOfTexts() + 1, 0, 0, 1, 1);
				this.add(errorMessageLabel);
			}
		}
		this.setVisible(true);
	}

	/**
	 * This function sets the constraints for the gridbag layout
	 */
	private void cSetConstraints(GridBagLayout gridBagLayout,
			Component component, int gridx, int gridy, double weightx,
			double weighty, int gridwidth, int gridheight) {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.insets = new Insets(5, 0, 5, 0);
		if (this.orientation == 1)
			gbc.fill = GridBagConstraints.HORIZONTAL;
		else
			gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.NORTH;
		gridBagLayout.setConstraints(component, gbc);
	}

	/**
	 * This function renders the multitext input panel in the box layout
	 */
	public void cRenderBoxLayout() {

		setComponentAttributes();
		JPanel labelPanel = getLabelPanel();
		Box box;

		if (this.orientation == 1) {
			// this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			box = Box.createHorizontalBox();
			box.add(labelPanel);
			box.add(multiText);
			box.add(errorMessageLabel);
			this.add(box);
		} else {
			// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			box = Box.createVerticalBox();
			box.add(labelPanel);
			box.add(multiText);
			box.add(errorMessageLabel);
			this.add(box);
		}
		this.setVisible(true);
	}

	/**
	 * This function renders the multitext input panel in the border layout
	 */
	public void cRenderBorderLayout() {

		setComponentAttributes();
		JPanel labelPanel = getLabelPanel();
		JPanel labelTextPanel, errorPanel;
		labelTextPanel = new JPanel();
		errorPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		this.setLayout(borderLayout);
		labelTextPanel.add(labelPanel);
		labelTextPanel.add(multiText);
		errorPanel.add(errorMessageLabel);
		if (this.orientation == 1) {
			this.add(labelTextPanel, borderLayout.CENTER);
			this.add(errorPanel, borderLayout.EAST);
		} else {
			this.add(labelTextPanel, borderLayout.CENTER);
			this.add(errorPanel, borderLayout.SOUTH);
		}
	}

	public void showErrorMessage() {
		this.errorMessageLabel.setForeground(Color.RED);
	}

	public void clearErrorMessage() {
		this.errorMessageLabel.setForeground(this.getBackground());
	}

	/**
	 * This function is to show the frame
	 */
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

	/**
	 * This function is to hide the frame
	 */
	public void hide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	public void refresh() {
		this.removeAll();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
	}

	public void addFocusListener(FocusListener focusListener) {
		if (multiText != null)
			multiText.addFocusListener(focusListener);
	}

	public void addMouseListener(MouseListener mouseListener) {
		if (multiText != null)
			multiText.addMouseListener(mouseListener);
	}

	public void addActionListener(ActionListener actionListener) {
		if (multiText != null)
			multiText.addActionListener(actionListener);
	}
}
