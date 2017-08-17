package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CCheck;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;

public class CCheckInputPanel extends JPanel {

	private CLabel caption, mandatoryLabel;
	private CCheck input;
	private CError errorMessage;
	private boolean inputValue;
	private String captionString,
			errorString = "Validation Error will be displayed here";
	private int captionWidth, captionHeight, inputWidth, inputHeight,
			errorMessageWidth, errorMessageHeight;
	private Dimension captionDimension, inputDimension, errorDimension;
	private int orientation = 1;
	private int preferredLayout;
	private boolean isMandatory;

	{
		captionDimension=new Dimension();
		inputDimension=new Dimension();
		errorDimension=new Dimension();
	}
	public CCheckInputPanel() {
		super();
	}

	public CCheckInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public CCheckInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public CCheckInputPanel(LayoutManager layout) {
		super(layout);
	}

	public CLabel getCaption() {
		return caption;
	}

	public void setCaption(CLabel caption) {
		caption = caption;
	}

	public CLabel getMandatoryLabel() {
		return mandatoryLabel;
	}

	public void setMandatoryLabel(CLabel mandatoryLabel) {
		this.mandatoryLabel = mandatoryLabel;
	}

	public CCheck getInput() {
		return input;
	}

	public void setInput(CCheck input) {
		this.input = input;
	}

	public CError getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(CError errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getCaptionString() {
		return captionString;
	}

	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public int getCaptionWidth() {
		return captionWidth;
	}

	public void setCaptionWidth(int captionWidth) {
		this.captionWidth = captionWidth;
	}

	public int getCaptionHeight() {
		return captionHeight;
	}

	public void setCaptionHeight(int captionHeight) {
		this.captionHeight = captionHeight;
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

	public int getErrorMessageWidth() {
		return errorMessageWidth;
	}

	public void setErrorMessageWidth(int errorMessageWidth) {
		this.errorMessageWidth = errorMessageWidth;
	}

	public int getErrorMessageHeight() {
		return errorMessageHeight;
	}

	public void setErrorMessageHeight(int errorMessageHeight) {
		this.errorMessageHeight = errorMessageHeight;
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

	public boolean getInputValue() {
		if (input != null)
			inputValue = input.isSelected();
		return inputValue;
	}

	public void setInputValue(boolean inputValue) {
		this.inputValue = inputValue;
	}

	public void cSetCaptionWidth(int width) {
		captionDimension.width=width;
	}

	/**
	 * 
	 * @param height
	 *            set the height of label
	 */
	public void cSetCaptionHeight(int height) {
		captionDimension.height=height;
	}

	/**
	 * 
	 * @param width
	 *            set the width of label.
	 * @param height
	 *            set the height of label
	 */
	public void cSetCaptionSize(int width, int height) {
		captionDimension = new Dimension(width, height);
	}

	/**
	 * 
	 * @param width
	 *            set the width of input.
	 */

	public void cSetInputWidth(int width) {
		inputDimension.width=width;
	}

	/**
	 * 
	 * @param height
	 *            set the height of input.
	 */

	public void cSetInputHeight(int height) {
		inputDimension.height=height;
	}

	/**
	 * 
	 * @param width
	 *            set the width of input
	 * @param height
	 *            set the height of input.
	 */

	public void cSetInputSize(int width, int height) {
		inputDimension = new Dimension(width, height);
	}

	/**
	 * 
	 * @param width
	 *            set the width of error.
	 * @param height
	 *            set the height of error
	 */
	public void cSetErrorSize(int width, int height) {
		errorDimension = new Dimension(width, height);
	}

	/**
	 * 
	 * @param width
	 *            set the width of error.
	 */

	public void cSetErrorWidth(int width) {
		errorDimension.width=width;
	}

	/**
	 * 
	 * @param height
	 *            set the height of error
	 */
	public void cSetErrorHeight(int height) {
		errorDimension.height=height;
	}

	/**
	 * 
	 * @param orientation
	 *            set orientation of the panel.
	 */

	public void cSetErrorMessage(String message) {
		setErrorString(message);

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
	 * Used to create component objects.
	 * 
	 * @param currentValue
	 */
	public void cInit() {
		CUIFactory CUIFactory = new CUIFactory();
		caption = (CLabel) CUIFactory.createUIComponent(CUIComponentType.LABEL);
		caption = (CLabel) CUIFactory.setUI(caption);
		input = (CCheck) CUIFactory
				.createUIComponent(CUIComponentType.CHECKBOX);
		input = (CCheck) CUIFactory.setUI(input);
		errorMessage = (CError) new CUIFactory()
				.createUIComponent(CUIComponentType.ERROR);
		mandatoryLabel = (CLabel) CUIFactory
				.createUIComponent(CUIComponentType.LABEL);

	}

	public void cRenderFlowLayout() {
		this.setLayout(new FlowLayout());
		cInit();
		setComponents();
		System.out.println(caption.getText());
		System.out.println(caption.getSize());
		addComponents();

	}

	/**
	 * This method is used to add components to the frame.
	 */
	private void addComponents() {
		this.add(input);
		this.add(caption);
		if (isMandatory) {
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.RED);
			mandatoryLabel.setFont(new Font("Verdana", Font.ITALIC, 12));
			this.add(mandatoryLabel);
		}
		this.add(errorMessage);
	}

	/**
	 * This function is used to render the panel in grid bag layout.
	 * 
	 * @param currentValue
	 *            set the current value of model.
	 */
	public void cRenderGridBagLayout() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		cInit();
		if (orientation == CUILayoutType.HORIZONTAL) {
			setConstraints(gridBagLayout, caption, 0, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST, 5, 5, 5, 5,
					GridBagConstraints.BOTH, 2, 2);
			if (isMandatory) {
				setConstraints(gridBagLayout, mandatoryLabel, 1, 0, 1, 1, 0, 0,
						GridBagConstraints.WEST, 5, 5, 5, 5,
						GridBagConstraints.BOTH, 2, 2);
				setConstraints(gridBagLayout, input, 2, 0, 1, 1, 0, 0,
						GridBagConstraints.WEST, 5, 5, 5, 5,
						GridBagConstraints.BOTH, 2, 2);
			} else {
				setConstraints(gridBagLayout, input, 1, 0, 1, 1, 0, 0,
						GridBagConstraints.WEST, 5, 5, 5, 5,
						GridBagConstraints.BOTH, 2, 2);
			}
			setConstraints(gridBagLayout, errorMessage, 0, 1, 2, 1, 0, 0,
					GridBagConstraints.WEST, 5, 5, 5, 5,
					GridBagConstraints.BOTH, 2, 2);
		}
		if (orientation == CUILayoutType.VERTICAL) {
			setConstraints(gridBagLayout, caption, 0, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST, 5, 5, 5, 5,
					GridBagConstraints.BOTH, 2, 2);
			if (isMandatory)
				setConstraints(gridBagLayout, mandatoryLabel, 1, 0, 1, 1, 0, 0,
						GridBagConstraints.WEST, 5, 5, 5, 5,
						GridBagConstraints.BOTH, 2, 2);
			setConstraints(gridBagLayout, input, 0, 1, 1, 1, 0, 0,
					GridBagConstraints.WEST, 5, 5, 5, 5,
					GridBagConstraints.BOTH, 2, 2);
			setConstraints(gridBagLayout, errorMessage, 0, 2, 2, 1, 0, 0,
					GridBagConstraints.WEST, 5, 5, 5, 5,
					GridBagConstraints.BOTH, 2, 2);
		}
		setComponents();
		addComponents();
	}

	/**
	 * This function is used to set constraints for the component.
	 * 
	 * @param gridBagLayout
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 * @param anchor
	 * @param top
	 * @param left
	 * @param right
	 * @param bottom
	 * @param fill
	 * @param ipadx
	 * @param ipady
	 * @param component
	 */

	private void setConstraints(GridBagLayout gridBagLayout,
			JComponent component, int gridx, int gridy, int gridwidth,
			int gridheight, int weightx, int weighty, int anchor, int top,
			int left, int right, int bottom, int fill, int ipadx, int ipady) {
		Insets insets = new Insets(top, left, bottom, right);
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
				gridwidth, gridheight, weightx, weighty, anchor, fill, insets,
				ipadx, ipady);
		gridBagLayout.setConstraints(component, gbc);

	}

	/**
	 * This function is used to set the size of the components.
	 */
	private void setComponents() {
		caption.setText(captionString);
		input.setSelected(inputValue);
		errorMessage.setText(errorString);
		errorMessage.setForeground(Color.RED);
		if (captionWidth != 0)
			cSetCaptionWidth(captionWidth);
		if (captionHeight != 0)
			cSetCaptionHeight(captionHeight);
		if (inputHeight != 0)
			cSetInputHeight(inputHeight);
		if (inputWidth != 0)
			cSetInputWidth(inputWidth);
		if (errorMessageHeight != 0)
			cSetErrorHeight(errorMessageHeight);
		if (errorMessageWidth != 0)
			cSetErrorWidth(errorMessageWidth);

		caption.setPreferredSize(captionDimension);
		caption.setMaximumSize(captionDimension);
		caption.setMinimumSize(captionDimension);
		
		
		input.setPreferredSize(inputDimension);
		input.setMaximumSize(inputDimension);
		input.setMinimumSize(inputDimension);
		

		errorMessage.setPreferredSize(errorDimension);
		errorMessage.setMaximumSize(errorDimension);
		errorMessage.setMinimumSize(errorDimension);
		
	}

	/**
	 * This function is used to render the components in box layout
	 */
	public void cRenderBoxLayout() {
		Box box;
		if (orientation == CUILayoutType.HORIZONTAL) {
			box = Box.createHorizontalBox();
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		} else {
			box = Box.createVerticalBox();
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		}
		cInit();
		setComponents();
		addComponents();

	}

	/**
	 * This function is used to display the components in border layout
	 */
	public void cRenderBorderLayout() {
		cInit();
		setComponents();
		JPanel panel1, panel2;
		panel1 = new JPanel();
		panel2 = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		this.setLayout(borderLayout);
		panel1.add(input);

		panel1.add(caption);
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);
			panel1.add(mandatoryLabel);
		}

		panel2.add(errorMessage);
		this.add(panel1, borderLayout.CENTER);
		this.add(panel2, borderLayout.SOUTH);

	}

	/**
	 * This function is used to refresh the screen.
	 */
	public void refresh() {
		this.removeAll();
		cInit();
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
	 * This function is used to hide the error on the screen
	 */

	public void hideError() {
		if (errorMessage != null)
			this.errorMessage.setForeground(this.getBackground());

	}

	/**
	 * This function is used to display the error message.
	 */
	public void showError() {
		if (errorMessage != null) {

			this.errorMessage.setForeground(Color.RED);
		}

	}


}
