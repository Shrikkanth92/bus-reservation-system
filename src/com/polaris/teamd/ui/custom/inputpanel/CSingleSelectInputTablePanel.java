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
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.common.validations.CValidator;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.common.utils.UIUtil;

public class CSingleSelectInputTablePanel extends JPanel {

	private String captionLabelString, singleSelectInputTableString;
	private int captionWidth, captionHeight;
	private int singleSelectInputTableWidth=500, singleSelectInputTableHeight=200;
	private int orientation;
	private int preferredLayout;
	private boolean isMandatory;
	private CLabel captionLabel;
	private CSingleSelectInputTable singleSelectInputTable;

	/**
	 * 
	 * @param isDoubleBuffered
	 */
	public CSingleSelectInputTablePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * 
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public CSingleSelectInputTablePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	/**
	 * 
	 * @param layout
	 */
	public CSingleSelectInputTablePanel(LayoutManager layout) {
		super(layout);

	}

	/**
	 * default constructor
	 */
	public CSingleSelectInputTablePanel() {
		super();
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
	 * @return singleSelectInputTable
	 */
	public CSingleSelectInputTable cGetsingleSelectInputTable() {
		return singleSelectInputTable;
	}

	/**
	 * 
	 * @param singleSelectInputTable
	 */
	public void cSetsingleSelectInputTable(CSingleSelectInputTable singleSelectInputTable) {
		this.singleSelectInputTable = singleSelectInputTable;
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
	 * @return the captionWidth
	 */
	public final int cGetCaptionWidth() {
		return captionWidth;
	}
	
	public void setColDisplayHeadings(String[] colHeadings){
		singleSelectInputTable.setColDisplayLabelProerties((colHeadings));
		System.out.println(colHeadings[0]);
	}
	
	public void setColHeadings(String[] colHeadings) {
		singleSelectInputTable.setColHeadings(colHeadings);
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
	 * @return the singleSelectInputTableWidth
	 */
	public final int cGetsingleSelectInputTableWidth() {
		return singleSelectInputTableWidth;
	}

	/**
	 * @param singleSelectInputTableWidth
	 *            the singleSelectInputTableWidth to set
	 */
	public final void cSetsingleSelectInputTableWidth(int singleSelectInputTableWidth) {
		this.singleSelectInputTableWidth = singleSelectInputTableWidth;
	}

	/**
	 * @return the singleSelectInputTableHeight
	 */
	public final int cGetsingleSelectInputTableHeight() {
		return singleSelectInputTableHeight;
	}

	/**
	 * @param singleSelectInputTableHeight
	 *            the singleSelectInputTableHeight to set
	 */
	public final void cSetsingleSelectInputTableHeight(int singleSelectInputTableHeight) {
		this.singleSelectInputTableHeight = singleSelectInputTableHeight;
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
	public final void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}
	
	public void addObject(Object object) {
		singleSelectInputTable.cAddObject(object);
	}
	
	public void addObjects(Object... objects) {
		singleSelectInputTable.cAddObjects(objects);
	}
	
	public void addObjects(List objectList) {
		singleSelectInputTable.cAddObjects(objectList);
	}
	
	public void setModel() {
		singleSelectInputTable.setModel();
	}

	public Object getSelectedObject() {
		return singleSelectInputTable.getSelectedObject();
	}
	
	public void csetCellEditor(int index, TableCellEditor tableCellEditor) {
		singleSelectInputTable.csetCellEditor(index, tableCellEditor);
	}
	
	public void cSetTableCellRender(int index,
			TableCellRenderer tableCellRenderer) {
		singleSelectInputTable.cSetTableCellRender(index, tableCellRenderer);
	}
	
	public Object cGetSelectedObjectProperty(String property) {
		return singleSelectInputTable.cGetSelectedObjectProperty(property);
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
			captionLabel = (CLabel) factory.setUI(captionLabel);
		}

		if (singleSelectInputTable == null) {
			singleSelectInputTable = (CSingleSelectInputTable) factory
					.createUIComponent(CUIComponentType.SINGLESELECTINPUTTABLE);
			singleSelectInputTable = (CSingleSelectInputTable) factory.setUI(singleSelectInputTable);
		}
		
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


	private void cSetsingleSelectInputTableSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		this.singleSelectInputTable.setPreferredSize(dimension);
		this.singleSelectInputTable.setMaximumSize(dimension);
		this.singleSelectInputTable.setMinimumSize(dimension);
		this.singleSelectInputTable.setSize(dimension);
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
		cSetConstraints(gridBagLayout, captionLabel, 1, 0, 1, 1, 0, 0, 0, 0,
				insets, 0, 0);

		this.add(captionLabel);

		if (this.orientation == CUILayoutType.HORIZONTAL) {
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				mandatoryMarker.setText("*");
				cSetConstraints(gridBagLayout, mandatoryMarker, 2, 0, 0, 0, 0,
						0, 0, 0, insets, 0, 0);
				this.add(mandatoryMarker);
			}
			cSetConstraints(gridBagLayout, singleSelectInputTable, 3, 0, 0, 0, 0, 0, 0, 0,
					insets, 0, 0);
			this.add(singleSelectInputTable);

			this.setVisible(true);

		}
		if (this.orientation == CUILayoutType.VERTICAL) {
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				mandatoryMarker.setText("*");
				cSetConstraints(gridBagLayout, mandatoryMarker, 2, 0, 0, 0, 0,
						0, 0, 0, insets, 0, 0);
				this.add(mandatoryMarker);
			}
			cSetConstraints(gridBagLayout, singleSelectInputTable, 0, 2, 0, 0, 0, 0, 0, 0,
					insets, 0, 0);
			this.add(singleSelectInputTable);
			this.setVisible(true);
		}

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
				this.cSetCaptionLabelSize(captionWidth, captionWidth);
			if (captionLabelString != null)
				captionLabel.setText(captionLabelString);
		}
		if (singleSelectInputTable != null) {
			if (singleSelectInputTableWidth != 0 && singleSelectInputTableHeight == 0)
				this.cSetsingleSelectInputTableSize(singleSelectInputTableWidth, singleSelectInputTable.getHeight());
			if (singleSelectInputTableWidth == 0 && singleSelectInputTableHeight != 0)
				this.cSetsingleSelectInputTableSize(singleSelectInputTable.getWidth(), singleSelectInputTableWidth);
			if (singleSelectInputTableWidth != 0 && singleSelectInputTableHeight != 0)
				this.cSetsingleSelectInputTableSize(singleSelectInputTableWidth, singleSelectInputTableHeight);

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
			double weighty, int ipadx, int ipady, int anchor, int fill,
			Insets insets, int gridwidth, int gridheight) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints(gridx,
				gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
				insets, ipadx, ipady);
		gridBagLayout.setConstraints(component, gridBagConstraints);
	}

	/**
	 * this function renders the components in Flow Layout
	 */
	public void cRenderFlowLayout() {
		//this.cInit();
		this.cSetComponentAttributes();
		this.add(captionLabel);
		if (isMandatory) {
			CLabel mandatoryMarker = (CLabel) new CUIFactory()
					.createUIComponent(CUIComponentType.LABEL);
			mandatoryMarker.setText("*");
			mandatoryMarker.setForeground(Color.RED);
			mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
			this.add(mandatoryMarker);
		}
		this.add(singleSelectInputTable);
	}

	/**
	 * this function renders the components in Box Layout
	 */
	public void cRenderBoxLayout() {
		//this.cInit();
		//this.cSetComponentAttributes();

		if (this.orientation == CUILayoutType.HORIZONTAL) {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box = Box.createHorizontalBox();
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setText("*");
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				box.add(mandatoryMarker);
			}
			box.add(singleSelectInputTable);
			this.add(box);
		} else {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Box box = Box.createVerticalBox();
			if (isMandatory) {
				CLabel mandatoryMarker = (CLabel) new CUIFactory()
						.createUIComponent(CUIComponentType.LABEL);
				mandatoryMarker.setText("*");
				mandatoryMarker.setForeground(Color.RED);
				mandatoryMarker.setFont(new Font("Verdana", Font.BOLD, 16));
				box.add(mandatoryMarker);
			}
			box.add(singleSelectInputTable);
			this.add(box);
		}
		this.setVisible(true);
	}

	/**
	 * this function renders the components in Border Layout
	 */

	public void cRenderBorderLayout() {
		//this.cInit();
	//	this.cSetComponentAttributes();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
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
			panel1.add(singleSelectInputTable);
			this.add(panel1, BorderLayout.CENTER);
			this.add(panel2, BorderLayout.SOUTH);
		}
		if (orientation == CUILayoutType.VERTICAL) {
			this.add(panel1, BorderLayout.NORTH);
			panel2.add(singleSelectInputTable);
			this.add(panel2, BorderLayout.CENTER);
		}

	}

	/**
	 * this function hides the text singleSelectInputTable panel
	 */

	public void cHide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();

	}


	/**
	 * this function displays the text singleSelectInputTable panel
	 */

	public void cShow() {
		this.setVisible(true);
		
		cRenderFlowLayout();
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
		if (singleSelectInputTable != null)
			singleSelectInputTable.addFocusListener(focusListener);
	}

	/**
	 * 
	 * @param mouseListener
	 */
	public void cAddMouseListner(MouseListener mouseListener) {
		if (singleSelectInputTable != null)
			singleSelectInputTable.addMouseListener(mouseListener);
	}

}