package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CPassword;

/**
 * 
 * @author Gowtham
 * 
 *         This custom class creates the password input panel
 */
public class CPasswordInputPanel extends JPanel {

	private String captionLabelString, inputString;
	private String errorMessageString = "Validation Error Will be Shown here";
	private int captionWidth, captionHeight;
	private int errorMessageWidth, errorMessageHeight;
	private int inputWidth, inputHeight;
	private int orientation;
	private int preferredLayout;
	private boolean isMandatory;
	private CLabel captionLabel;
	private CPassword input;
	private CError errorMessageLabel;

	/**
	 * 
	 */
	public CPasswordInputPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public CPasswordInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public CPasswordInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 */
	public CPasswordInputPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the orientation
	 */
	public final int cGetOrientation() {
		return orientation;
	}

	/**
	 * 
	 * @param orientation
	 */
	public void cSetOrientation(int orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return the captionLabel
	 */
	public final CLabel cGetCaptionLabel() {
		return captionLabel;
	}

	/**
	 * @param captionLabel
	 *            the captionLabel to set
	 */
	public final void cSetCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	/**
	 * 
	 * @return input
	 */
	public CPassword cGetInput() {
		return input;
	}

	/**
	 * 
	 * @param input
	 */
	public void cSetInput(CPassword input) {
		this.input = input;
	}

	/**
	 * @return the errorMessageLabel
	 */
	public final CError cGetErrorMessageLabel() {
		return errorMessageLabel;
	}

	/**
	 * @param errorMessageLabel
	 *            the errorMessageLabel to set
	 */
	public final void cSetErrorMessageLabel(CError errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	/**
	 * @return the captionLabelString
	 */
	public final String cGetCaptionLabelString() {
		return captionLabelString;
	}

	/**
	 * @param captionLabelString
	 *            the captionLabelString to set
	 */
	public final void cSetCaptionLabelString(String captionLabelString) {
		this.captionLabelString = captionLabelString;
	}

	/**
	 * @return the inputString
	 */
	public final String cGetInputString() {
		return inputString;
	}

	/**
	 * @param inputString
	 *            the inputString to set
	 */
	public final void cSetInputString(String inputString) {
		this.inputString = inputString;
	}

	/**
	 * @return the errorMessageString
	 */
	public final String cGetErrorMessageString() {
		return errorMessageString;
	}

	/**
	 * @param errorMessageString
	 *            the errorMessageString to set
	 */
	public final void cSetErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
	}

	/**
	 * @return the captionWidth
	 */
	public final int cGetCaptionWidth() {
		return captionWidth;
	}

	/**
	 * @param captionWidth
	 *            the captionWidth to set
	 */
	public final void cSetCaptionWidth(int captionWidth) {
		this.captionWidth = captionWidth;
	}

	/**
	 * @return the captionHeight
	 */
	public final int cGetCaptionHeight() {
		return captionHeight;
	}

	/**
	 * @param captionHeight
	 *            the captionHeight to set
	 */
	public final void cSetCaptionHeight(int captionHeight) {
		this.captionHeight = captionHeight;
	}

	/**
	 * @return the inputWidth
	 */
	public final int cGetInputWidth() {
		return inputWidth;
	}

	/**
	 * @param inputWidth
	 *            the inputWidth to set
	 */
	public final void cSetInputWidth(int inputWidth) {
		this.inputWidth = inputWidth;
	}

	/**
	 * @return the inputHeight
	 */
	public final int cGetInputHeight() {
		return inputHeight;
	}

	/**
	 * @param inputHeight
	 *            the inputHeight to set
	 */
	public final void cSetInputHeight(int inputHeight) {
		this.inputHeight = inputHeight;
	}

	/**
	 * @return the errorMessageWidth
	 */
	public final int cGetErrorMessageWidth() {
		return errorMessageWidth;
	}

	/**
	 * @param errorMessageWidth
	 *            the errorMessageWidth to set
	 */
	public final void cSetErrorMessageWidth(int errorMessageWidth) {
		this.errorMessageWidth = errorMessageWidth;
	}

	/**
	 * @return the errorMessageHeight
	 */
	public final int cGetErrorMessageHeight() {
		return errorMessageHeight;
	}

	/**
	 * @param errorMessageHeight
	 *            the errorMessageHeight to set
	 */
	public final void cSetErrorMessageHeight(int errorMessageHeight) {
		this.errorMessageHeight = errorMessageHeight;
	}

	/**
	 * @return the isMandatory
	 */
	public final boolean cIsMandatory() {
		return isMandatory;
	}

	/**
	 * @param isMandatory
	 *            the isMandatory to set
	 */
	public final void cSetMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	/**
	 * @return the preferredLayout
	 */
	public final int cGetPreferredLayout() {
		return preferredLayout;
	}

	/**
	 * @param preferredLayout
	 *            the preferredLayout to set
	 */
	public final void cSetPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	/**
	 * 
	 * this function initializes the components
	 */
	public void cInit() {
		CUIFactory factory = new CUIFactory();
		if (captionLabel == null) {
			captionLabel = (CLabel) factory
					.createUIComponent(CUIComponentType.LABEL);
			//captionLabel = (CLabel) factory.setUI(captionLabel);
		}

		if (input == null) {
			input = (CPassword) factory
					.createUIComponent(CUIComponentType.PASSWORD);
			//input = (CPassword) factory.setUI(input);
		}
		if (errorMessageLabel == null)
			this.errorMessageLabel = (CError) factory
					.createUIComponent(CUIComponentType.ERROR);
	}

	/**
	 * 
	 * @return input-as an integer
	 */
	public int cGetInputTextAsInteger() {
		return input.cGetIntValue();
	}

	/**
	 * 
	 * @return the text in input as a float value
	 */
	public float cGetInputTextAsFloat() {
		return input.cGetFloatValue();
	}

	/**
	 * 
	 * @return the text in input as a double value
	 */
	public double cGetInputTextAsDouble() {
		return input.cGetDoubleValue();
	}

	/**
	 * this function clears the error message
	 */
	public void cClearErrorMessage() {
		this.errorMessageLabel.setForeground(this.getBackground());
	}

	/**
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetCaptionLabelSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		this.captionLabel.setPreferredSize(dimension);
		this.captionLabel.setMaximumSize(dimension);
		this.captionLabel.setMinimumSize(dimension);
		this.captionLabel.setSize(dimension);
	}

	/**
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetErrorMessageLabelSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);

		this.errorMessageLabel.setPreferredSize(dimension);
		this.errorMessageLabel.setMaximumSize(dimension);
		this.errorMessageLabel.setMinimumSize(dimension);
		this.errorMessageLabel.setSize(dimension);
	}

	/**
	 * 
	 * @param width
	 * @param height
	 */
	private void cSetInputSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		this.input.setPreferredSize(dimension);
		this.input.setMaximumSize(dimension);
		this.input.setMinimumSize(dimension);
		this.input.setSize(dimension);
	}

	/**
	 * 
	 * @param columnLength
	 */

	public void cSetColumnLength(int columnLength) {
		input.setColumns(columnLength);

	}

	/**
	 * this function sets up the components attributes
	 */
	private void cSetComponentAttributes() {
		if (captionLabel != null) {
			if (captionWidth != 0 && captionHeight == 0)
				this.cSetCaptionLabelSize(captionWidth,
						captionLabel.getHeight());
			if (captionWidth == 0 && captionHeight != 0)
				this.cSetCaptionLabelSize(captionLabel.getWidth(),
						captionHeight);
			if (captionWidth != 0 && captionHeight != 0)
				this.cSetCaptionLabelSize(captionWidth, captionHeight);
			
			if (captionLabelString != null)
				captionLabel.setText(captionLabelString);
		}
		if (input != null) {
			if (inputWidth != 0 && inputHeight == 0)
				this.cSetInputSize(inputWidth, input.getHeight());
			if (inputWidth == 0 && inputWidth != 0)
				this.cSetCaptionLabelSize(input.getWidth(), inputWidth);
			if (captionWidth != 0 && captionHeight != 0)
				this.cSetInputSize(inputWidth, inputHeight);
			if (inputString != null)
				this.input.setText(inputString);
		}
		if (errorMessageLabel != null) {
			if (errorMessageWidth != 0 && errorMessageHeight == 0)
				this.cSetErrorMessageLabelSize(errorMessageWidth,
						errorMessageLabel.getHeight());
			if (errorMessageWidth == 0 && errorMessageHeight != 0)
				this.cSetErrorMessageLabelSize(errorMessageLabel.getHeight(),
						errorMessageWidth);
			if (errorMessageWidth != 0 && errorMessageHeight != 0)
				this.cSetErrorMessageLabelSize(errorMessageWidth,
						errorMessageHeight);
			if (errorMessageString != null)
				this.errorMessageLabel.setText(errorMessageString);

		}
	}

	/**
	 * 
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param weightx
	 * @param weighty
	 * @param ipadx
	 * @param ipady
	 * @param anchor
	 * @param fill
	 * @param insets
	 * @param gridwidth
	 * @param gridheight
	 */
	public void cSetConstraints(GridBagLayout gridBagLayout,
			JComponent component, int gridx, int gridy, double weightx,
			double weighty, int ipadx, int ipady, Insets insets, int gridwidth,
			int gridheight) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints(gridx,
				gridy, gridwidth, gridheight, weightx, weighty,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, insets,
				ipadx, ipady);
		gridBagLayout.setConstraints(component, gridBagConstraints);
	}

	/**
	 * this function renders components in gridBagLayout
	 */

	public void cRenderGridBagLayout() {
		this.cInit();
		cSetComponentAttributes();
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		Insets insets = new Insets(0, 5, 2, 0);
		cSetConstraints(gridBagLayout, captionLabel, 1, 0, 1, 1, 0, 0, insets,
				0, 0);

		this.add(captionLabel);

		if (this.orientation == CUILayoutType.VERTICAL) {
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				mandatoryMarker.setText("*");
				cSetConstraints(gridBagLayout, mandatoryMarker, 2, 0, 0, 0, 0,
						0, insets, 0, 0);
				this.add(mandatoryMarker);
			}
			cSetConstraints(gridBagLayout, input, 1, 1, 3, 1, 0, 0, insets, 0,
					0);
			this.add(input);
			cSetConstraints(gridBagLayout, errorMessageLabel, 1, 2, 0, 0, 0, 0,
					insets, 2, 0);

			this.add(errorMessageLabel);
		} else {
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				mandatoryMarker.setText("*");
				cSetConstraints(gridBagLayout, mandatoryMarker, 2, 0, 0, 0, 0,
						0, insets, 0, 0);
				this.add(mandatoryMarker);
			}
			cSetConstraints(gridBagLayout, input, 3, 0, 0, 0, 0, 0, insets, 0,
					0);
			this.add(input);
			cSetConstraints(gridBagLayout, errorMessageLabel, 1, 1, 0, 0, 0, 0,
					insets, 2, 0);

			this.add(errorMessageLabel);
		}
		// this.errorMessageLabel.setForeground(this.getBackground());
		this.setVisible(true);
	}

	/**
	 * this function renders the components in Flow Layout
	 */
	public void cRenderFlowLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		System.out.println(captionLabel.getWidth() + "..." + captionLabel.getHeight());
		//System.out.println(captionLabel.getText());
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);
		this.add(captionLabel);
		if (isMandatory) {
			CLabel mandatoryMarker = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryMarker.setText("*");
			mandatoryMarker.setForeground(Color.RED);
			this.add(mandatoryMarker);
		}
		this.add(input);
		this.add(errorMessageLabel);
		this.setVisible(true);
	}
	
	/**
	 * this function renders the components in Box Layout
	 */
	public void cRenderBoxLayout() {
		this.cInit();
		this.cSetComponentAttributes();

		if (this.orientation == CUILayoutType.VERTICAL) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Box box = Box.createVerticalBox();
			box.add(captionLabel);
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setText("*");
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				box.add(mandatoryMarker);

			}
			box.add(input);
			box.add(errorMessageLabel);
			this.add(box);
		}

		else {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box = Box.createHorizontalBox();
			box.add(captionLabel);
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setText("*");
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				box.add(mandatoryMarker);

			}
			box.add(input);
			box.add(errorMessageLabel);
			this.add(box);
		}

		this.setVisible(true);
	}

	/**
	 * this function renders the components in Border Layout
	 */

	public void cRenderBorderLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		this.setLayout(new BorderLayout());
		panel1.add(captionLabel);
		if (isMandatory) {
			CLabel mandatoryMarker = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryMarker.setText("*");
			mandatoryMarker.setForeground(Color.RED);
			mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
			panel1.add(mandatoryMarker);
		}
		if (orientation == CUILayoutType.HORIZONTAL) {
			panel1.add(input);
			this.add(panel1, BorderLayout.CENTER);
			panel2.add(errorMessageLabel);
			this.add(panel2, BorderLayout.SOUTH);
		} else {
			this.add(panel1, BorderLayout.NORTH);
			panel2.add(input);
			this.add(panel2, BorderLayout.CENTER);
			this.add(errorMessageLabel, BorderLayout.SOUTH);
		}

		this.setVisible(true);
	}

	/**
	 * this function hides the text input panel
	 */

	public void cHide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();

	}

	/**
	 * this function displays the error message
	 */

	public void cShowErrorMessage() {
		this.errorMessageLabel.setForeground(Color.RED);
	}

	/**
	 * this function displays the text input panel
	 */

	public void cShow() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();

	}

	/**
	 * this function removes and reinitializes all components
	 */
	public void cRefresh() {
		this.removeAll();
		this.cInit();
		if (this.cGetPreferredLayout() == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (this.cGetPreferredLayout() == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (this.cGetPreferredLayout() == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if (this.cGetPreferredLayout() == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
	}

	/**
	 * 
	 * @param focusListener
	 */
	public void cAddFocusListner(FocusListener focusListener) {
		if (input != null)
			input.addFocusListener(focusListener);
	}

	/**
	 * 
	 * @param actionListener
	 */
	public void cAddActionListner(ActionListener actionListener) {
		if (input != null)
			input.addActionListener(actionListener);
	}

	/**
	 * 
	 * @param mouseListener
	 */
	public void cAddMouseListner(MouseListener mouseListener) {
		if (input != null)
			input.addMouseListener(mouseListener);
	}
}