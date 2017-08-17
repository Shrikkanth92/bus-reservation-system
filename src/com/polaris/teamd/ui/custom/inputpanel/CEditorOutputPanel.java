package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.polaris.teamd.common.utils.UIUtil;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CEditorPane;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.inputpanel.CInputPanel;

/**
 * 
 * @author nireesha.patnam
 * 
 *         This class is for implementing the Editor Output Panel methods
 */
public class CEditorOutputPanel extends JPanel {

	private CLabel captionLabel;
	private CEditorPane reportPanel;
	private File file;
	private JScrollPane reportContainer;
	private int orientation;
	private int panelWidth, panelheight, captionWidth, captionHeight,
			preferredLayout;
	private String actionButtonString, captionString;
	private CButton actionButton;

	/**
	 * This is an empty constructor
	 */
	public CEditorOutputPanel() {

	}

	public CLabel getCaptionLabel() {
		return captionLabel;
	}

	public String getCaptionString() {
		return captionString;
	}

	public void setCaptionString(String captionString) {
		this.captionString = captionString;
	}

	public void setCaptionLabel(CLabel captionLabel) {
		this.captionLabel = captionLabel;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getPanelWidth() {
		return panelWidth;
	}

	public void setPanelWidth(int panelWidth) {
		this.panelWidth = panelWidth;
	}

	public int getPanelheight() {
		return panelheight;
	}

	public void setPanelheight(int panelheight) {
		this.panelheight = panelheight;
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

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	public String getActionButtonString() {
		return actionButtonString;
	}

	public void setActionButtonString(String actionButtonString) {
		this.actionButtonString = actionButtonString;
	}

	public CButton getActionButton() {
		return actionButton;
	}

	public void setActionButton(CButton actionButton) {
		this.actionButton = actionButton;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {

		this.orientation = orientation;
		// if (orientation == 1) {
		// this.orientation = CUILayoutType.HORIZONTAL;
		// }
		// if (orientation == 2) {
		// this.orientation = CUILayoutType.VERTICAL;
		// }
	}

	/**
	 * This method is used to initialise the component parameters
	 */
	public void init() {
		CUIFactory cUIFactory = new CUIFactory();

		captionLabel = (CLabel) cUIFactory
				.createUIComponent(CUIComponentType.LABEL);
		cUIFactory.setUI(captionLabel);
		reportPanel = (CEditorPane) new CUIFactory()
				.createUIComponent(CUIComponentType.EDITORPANE);
		cUIFactory.setUI(reportPanel);
		actionButton = (CButton) cUIFactory
				.createUIComponent(CUIComponentType.BUTTON);
		cUIFactory.setUI(actionButton);
		
	}

	/**
	 * 
	 * @param file
	 * 
	 *            This method is used to set the page of the report panel
	 */
	public void setPage(File file) {

		this.file = file;
		try {
			reportPanel.setPage(new URL("file:///" + file.getPath() + "/"
					+ file.getName()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param caption
	 * 
	 *            This method is used to set the caption for the Label
	 */
	public void cSetCaption(String caption) {
		this.captionLabel.setText(caption);
	}

	/**
	 * 
	 * @param caption
	 * 
	 *            This method is used to set the caption for the button
	 */
	public void cSetButtonCaption(String caption) {
		this.actionButton.setText(actionButtonString);
	}

	/**
	 * 
	 * @param width
	 * 
	 *            This method is used to set the width of the label
	 */
	private void cSetLabelWidth(int width) {

		captionLabel.setPreferredSize(new Dimension(width, captionLabel
				.getHeight()));
		captionLabel.setMaximumSize(new Dimension(width, captionLabel
				.getHeight()));
		captionLabel.setMinimumSize(new Dimension(width, captionLabel
				.getHeight()));
		captionLabel.setSize(width, captionLabel.getHeight());
	}

	/**
	 * 
	 * @param height
	 * 
	 *            This method is used to set the height of the label
	 */
	private void cSetLabelHeight(int height) {
		captionLabel.setPreferredSize(new Dimension(captionLabel.getWidth(),
				height));
		captionLabel.setMaximumSize(new Dimension(captionLabel.getWidth(),
				height));
		captionLabel.setMinimumSize(new Dimension(captionLabel.getWidth(),
				height));
		captionLabel.setSize(captionLabel.getWidth(), height);
	}

	/**
	 * 
	 * @param width
	 * @param height
	 * 
	 *            This method is used to set the size of the caption label
	 */
	public void cSetLabelSize(int width, int height) {
		captionLabel.setSize(width, height);
		captionLabel.setPreferredSize(new Dimension(width, height));
		captionLabel.setMinimumSize(new Dimension(width, height));
		captionLabel.setMaximumSize(new Dimension(width, height));
	}

	/**
	 * 
	 * @param width
	 * 
	 *            This method is used to set the width of the Editor Panel
	 */
	private void cSetReportPanelWidth(int width) {

		reportPanel.setPreferredSize(new Dimension(width, reportPanel
				.getHeight()));
		reportPanel
				.setMaximumSize(new Dimension(width, reportPanel.getHeight()));
		reportPanel
				.setMinimumSize(new Dimension(width, reportPanel.getHeight()));
		reportPanel.setSize(width, reportPanel.getHeight());
	}

	/**
	 * 
	 * @param height
	 * 
	 *            This method is used to set the height of the Editor Panel
	 */
	private void cSetReportPanelHeight(int height) {
		reportPanel.setPreferredSize(new Dimension(reportPanel.getWidth(),
				height));
		reportPanel
				.setMaximumSize(new Dimension(reportPanel.getWidth(), height));
		reportPanel
				.setMinimumSize(new Dimension(reportPanel.getWidth(), height));
		reportPanel.setSize(reportPanel.getWidth(), height);
	}

	/**
	 * 
	 * @param width
	 * @param height
	 * 
	 *            This method is used to set the size dimensions of a panel
	 * 
	 */
	public void cSetReportPanelSize(int width, int height) {
		reportPanel.setSize(width, height);
		reportPanel.setPreferredSize(new Dimension(width, height));
		reportPanel.setMinimumSize(new Dimension(width, height));
		reportPanel.setMaximumSize(new Dimension(width, height));
	}

	
	
	/**
	 * This method sets the attributes of the components in the editor panel
	 */
	public void setComponentAttributes() {
		if (captionString != null) {
			this.cSetCaption(getCaptionString());
		}
		if (actionButtonString != null) {
			this.cSetButtonCaption(getActionButtonString());
		}
		if (captionWidth != 0 && captionHeight != 0)
			this.cSetLabelSize(getCaptionWidth(), getCaptionHeight());
		if (panelWidth != 0 && panelheight != 0)
			this.cSetReportPanelSize(getPanelWidth(), getPanelheight());

	}


	
	/**
	 * 
	 * @param component
	 * @param gridBagLayout
	 * @param gridx
	 * @param gridy
	 * @param ipadx
	 * @param ipady
	 * @param gridwidth
	 * @param gridheight
	 * 
	 *            This method is used to set the constraints for gridbaglayout
	 * 
	 */
	private void setConstraints(JComponent component,
			GridBagLayout gridBagLayout, int gridx, int gridy, int ipadx,
			int ipady, int gridwidth, int gridheight) {
		double weightx = 0, weighty = 0;
		int fill = GridBagConstraints.BOTH;
		int anchor = GridBagConstraints.LINE_START;

		GridBagConstraints gridBagConstraints = new GridBagConstraints(gridx,
				gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
				new Insets(5, 5, 5, 5), ipadx, ipady);
		gridBagLayout.setConstraints(component, gridBagConstraints);
	}

	
	/**
	 * This method is used to render Boxlayout
	 */
	public void cRenderBoxLayout() {
		setComponentAttributes();

		if (this.orientation == CUILayoutType.HORIZONTAL) {
			Box box = Box.createHorizontalBox();
			box.add(captionLabel);
			reportContainer.add(reportPanel);
			box.add(reportContainer);
			box.add(actionButton);
			this.add(box);
		}

		if (this.orientation == CUILayoutType.VERTICAL) {
			Box box = Box.createVerticalBox();
			box.add(captionLabel);
			reportContainer.add(reportPanel);
			box.add(reportContainer);
			box.add(actionButton);
			this.add(box);

		}

	}

	/**
	 * This method is used to render Border layout
	 */
	public void cRenderBorderLayout() {
		
		setComponentAttributes();
		if (this.orientation == CUILayoutType.HORIZONTAL) {

			setComponentAttributes();
			JPanel panel1, panel2;
			panel1 = new JPanel();
			panel2 = new JPanel();
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(10);
			borderLayout.setVgap(10);
			this.setLayout(borderLayout);
			panel1.add(captionLabel);
			reportContainer.add(reportPanel);
			panel2.add(actionButton);

			this.add(panel1, BorderLayout.NORTH);
			this.add(reportContainer, BorderLayout.CENTER);
			this.add(panel2, BorderLayout.SOUTH);

		}

		if (this.orientation == CUILayoutType.VERTICAL) {

			setComponentAttributes();
			JPanel panel1, panel2, panel3;
			panel1 = new JPanel();
			panel2 = new JPanel();
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(10);
			borderLayout.setVgap(10);
			this.setLayout(borderLayout);
			panel1.add(captionLabel);
			reportContainer.add(reportPanel);
			panel2.add(actionButton);

			this.add(panel1, BorderLayout.WEST);
			this.add(reportContainer, BorderLayout.CENTER);
			this.add(panel2, BorderLayout.EAST);
		}

	}

	/**
	 * This method is used to render Flow layout
	 */
	public void cRenderFlowLayout() {
		setComponentAttributes();

		FlowLayout flowLayout = new FlowLayout();
		this.setLayout(flowLayout);

		captionLabel.setHorizontalAlignment(CLabel.TOP);
		this.add(captionLabel);
		reportContainer.add(reportPanel);
		this.add(reportContainer);
		actionButton.setHorizontalAlignment(CButton.BOTTOM);
		this.add(actionButton);

	}

	/**
	 * This method is used to render GridbagLayout
	 */
	public void cRenderGridBagLayout() {
		setComponentAttributes();
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		this.setLayout(gridBagLayout);
		captionLabel.setHorizontalAlignment(CLabel.RIGHT);

		if (this.orientation == CUILayoutType.HORIZONTAL) {

			setConstraints(captionLabel, gridBagLayout, 0, 0, 1, 1, 3, 1);
			setConstraints(reportContainer, gridBagLayout, 0, 1, 1, 1, 10, 10);
			setConstraints(actionButton, gridBagLayout, 0, 2, 1, 1, 3, 1);
			this.setVisible(true);
			this.add(captionLabel);
			reportContainer.add(reportPanel);
			this.add(reportContainer);
			this.add(actionButton);

		}
		if (this.orientation == CUILayoutType.VERTICAL) {

			setConstraints(captionLabel, gridBagLayout, 0, 0, 1, 1, 3, 1);
			setConstraints(reportContainer, gridBagLayout, 0, 1, 1, 1, 10, 10);
			setConstraints(actionButton, gridBagLayout, 0, 2, 1, 1, 3, 1);
			this.setVisible(true);
			this.add(captionLabel);
			reportContainer.add(reportPanel);
			this.add(reportContainer);
			this.add(actionButton);
		}
	}

	/**
	 * This method is used to hide the contents of the Editor Panel
	 */
	@Override
	public void hide() {
		this.setVisible(false);
		invalidate();
		validate();

	}

	/**
	 * This method is used to display the contents of Editor panel
	 */
	@Override
	public void show() {

		this.setVisible(true);
		init();
		setComponentAttributes();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
		if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
	}

	/**
	 * This method is used to refresh the contents on the screen
	 */
	public void refresh() {
		this.removeAll();
		setComponentAttributes();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
		if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();

	}

}
