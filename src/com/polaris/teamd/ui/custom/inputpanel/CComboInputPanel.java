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
import javax.swing.SpinnerModel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CCombo;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;

/**
 * 
 * @author mohamedjaveed.b
 * 
 *         This class is used to create spinner panel.
 */
public class CComboInputPanel extends JPanel {

	private String captionString, inputString,
			errorMessageString = "Validation Error will be displayed here";
	private int orientation = 1;
	private boolean isMandatory;
	private int preferredLayout;
	private Dimension captionDimension, inputDimension, errorDimension;
	private CLabel caption, mandatoryLabel;
	private CCombo input;
	private CError errorMessage;

	/**
	 * This is the default constructor
	 */
	public CComboInputPanel() {
		super();
		setMinimumSize(new Dimension(getWidth(), 40));
		setMaximumSize(new Dimension(getWidth(), 40));
		setPreferredSize(new Dimension(getWidth(), 40));
		
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param isDoubleBuffered
	 */
	public CComboInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public CComboInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * This is a parameterised constructor
	 * 
	 * @param layout
	 */

	public CComboInputPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * This method is used to return the value of label.
	 * 
	 * @return caption
	 */
	public CLabel getCaption() {
		return caption;
	}

	/**
	 * This method is used to set the caption
	 * 
	 * @param caption
	 */

	public void setCaption(CLabel caption) {
		this.caption = caption;
	}

	/**
	 * This method is used to get the mandatory label.
	 * 
	 * @return
	 */

	public CLabel getMandatoryLabel() {
		return mandatoryLabel;
	}

	/**
	 * This method is used to set the mandatory label.
	 * 
	 * @param mandatoryLabel
	 */
	public void setMandatoryLabel(CLabel mandatoryLabel) {
		this.mandatoryLabel = mandatoryLabel;
	}

	/**
	 * This method is used to get the input.
	 * 
	 * @return
	 */
	public CCombo getInput() {
		return input;
	}

	/**
	 * This method is used to set the input.
	 * 
	 * @param input
	 */
	public void setInput(CCombo input) {
		this.input = input;
	}

	/**
	 * This method is used to get the error message.
	 * 
	 * @return
	 */
	public CError getErrorMessage() {
		return errorMessage;
	}

	/**
	 * This method is used to set the error message.
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(CError errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * This method is used to get the caption dimension
	 * 
	 * @return
	 */
	public Dimension getCaptionDimension() {
		return captionDimension;
	}

	/**
	 * This method is used to set the caption dimension
	 * 
	 * @param captionDimension
	 */
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

	/**
	 * This method is used to get the orientation of the panel.
	 * 
	 * @return
	 */

	public int getOrientation() {
		return orientation;
	}

	/**
	 * This method is used to get the mandatory value.
	 * 
	 * @return
	 */
	public boolean isMandatory() {
		return isMandatory;
	}

	/**
	 * This method is used to get the preferred layout of the panel.
	 * 
	 * @return
	 */
	public int getPreferredLayout() {
		return preferredLayout;
	}

	/**
	 * This method is used to set the preferred layout of the panel.
	 * 
	 * @param preferredLayout
	 */
	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	/**
	 * 
	 * @return The value of the label.
	 */
	public String getCaptionString() {
		return captionString;
	}

	/**
	 * 
	 * @param captionString
	 *            This is used to set the label value.
	 */
	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	/**
	 * 
	 * @return the value of input.
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * 
	 * @param inputString
	 *            set the value of input
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	/**
	 * 
	 * @return the value of error string.
	 */

	public String getErrorMessageString() {
		return errorMessageString;
	}

	/**
	 * 
	 * @param errorMessageString
	 *            set the value of error message.
	 */

	public void setErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
	}

	public Object cGetSelectedObject() {
		return input.getSelectedObject();
	}

	/**
	 * 
	 * @param isMandatory
	 *            set if the field is mandatory.
	 */
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	/**
	 * 
	 * @param width
	 *            set the width of label.
	 */

	public void cSetCaptionWidth(int width) {
		captionDimension = new Dimension(width, caption.getHeight());
	}

	/**
	 * 
	 * @param height
	 *            set the height of label
	 */
	public void cSetCaptionHeight(int height) {
		captionDimension = new Dimension(caption.getWidth(), height);
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
		inputDimension = new Dimension(width, inputDimension.height);
	}

	/**
	 * 
	 * @param height
	 *            set the height of input.
	 */

	public void cSetInputHeight(int height) {
		inputDimension = new Dimension(inputDimension.width, height);
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
		errorDimension = new Dimension(width, errorDimension.height);
	}

	/**
	 * 
	 * @param height
	 *            set the height of error
	 */
	public void cSetErrorHeight(int height) {
		errorDimension = new Dimension(errorDimension.width, height);
	}

	/**
	 * 
	 * @param orientation
	 *            set orientation of the panel.
	 */

	public void setOrientation(int orientation) {
		if (orientation == 1)
			this.orientation = CUILayoutType.HORIZONTAL;
		if (orientation == 2)
			this.orientation = CUILayoutType.VERTICAL;
	}

	public void cSetErrorMessage(String message) {
		setErrorMessageString(message);

	}

	public void cSetInputSize(int width, int height) {
		inputDimension = new Dimension(width, height);

	}

	public void cSetErrorLabelSize(int width, int height) {
		errorDimension = new Dimension(width, height);
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
	public void init() {
		CUIFactory CUIFactory = new CUIFactory();
		caption = (CLabel) CUIFactory.createUIComponent(CUIComponentType.LABEL);
		caption = (CLabel) CUIFactory.setUI(caption);
		caption.setText(captionString);
		input = (CCombo) CUIFactory
				.createUIComponent(CUIComponentType.COMBOBOX);
		input = (CCombo) CUIFactory.setUI(input);
		errorMessage = (CError) new CUIFactory()
				.createUIComponent(CUIComponentType.ERROR);
		errorMessage.setText(errorMessageString);
		mandatoryLabel = (CLabel) CUIFactory
				.createUIComponent(CUIComponentType.LABEL);
	}

	/**
	 * This function is used to render the panel in flow layout.
	 * 
	 * @param currentValue
	 *            set the current value of model.
	 */
	public void cRenderFlowLayout() {
		this.setLayout(new FlowLayout());
		init();
		setComponentSize();
		addComponents();

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
		init();
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
		setComponentSize();
		addComponents();
	}

	/**
	 * This function is used to render the components in box layout
	 */
	public void cRenderBoxLayout() {
		Box box;
		JPanel captionpanel;
		captionpanel = new JPanel();

		if (orientation == CUILayoutType.HORIZONTAL) {
			box = Box.createHorizontalBox();
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		} else {
			box = Box.createVerticalBox();
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		}
		init();
		setComponentSize();
		captionpanel.add(caption);
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);
			captionpanel.add(mandatoryLabel);
		}

		box.add(captionpanel);
		box.add(input);
		box.add(errorMessage);
		this.add(box);
	}

	/**
	 * This function is used to display the components in border layout
	 */
	public void cRenderBorderLayout() {
		init();
		setComponentSize();
		JPanel panel1, panel2;
		panel1 = new JPanel();
		panel2 = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		this.setLayout(borderLayout);
		panel1.add(caption);
		if (isMandatory() == true) {
			mandatoryLabel = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.red);
			panel1.add(mandatoryLabel);
		}
		panel1.add(input);
		panel2.add(errorMessage);
		this.add(panel1, borderLayout.CENTER);
		this.add(panel2, borderLayout.SOUTH);

	}

	/**
	 * This method is used to add components to the frame.
	 */
	private void addComponents() {
		caption.setHorizontalAlignment(CLabel.RIGHT);
		this.add(caption);
		if (isMandatory) {
			mandatoryLabel.setText("*");
			mandatoryLabel.setForeground(Color.RED);
			mandatoryLabel.setFont(new Font("Verdana", Font.ITALIC, 12));
			this.add(mandatoryLabel);
		}
		this.add(input);
		this.add(errorMessage);
	}

	/**
	 * This function is used to refresh the screen.
	 */
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
	private void setComponentSize() {
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
	 * This function is used to hide the error on the screen
	 */

	public void hideError() {
		if (errorMessage != null)
			this.errorMessage.setForeground(this.getBackground());

	}

	/**
	 * This function is used to display the error message.
	 */
	public void showErrorMessage() {
		if (errorMessage != null)
			this.errorMessage.setBackground(Color.RED);
	}
}
