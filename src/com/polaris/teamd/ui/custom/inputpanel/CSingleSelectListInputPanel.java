package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.custom.CError;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CSingleSelectList;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;

public class CSingleSelectListInputPanel extends JPanel {

	private CLabel cLabel, errorMessageLabel;

	private String labelString,errorMessageString;

	private int labelWidth, labelHeight, listWidth, listHeight, errorMessageWidth, errorMessageheight;
	private CTextInputPanel targetUI;
	private CSingleSelectList cSingleSelectList;
	private CError cError;
	private int orientation;
	private String fieldToDisplay;
	private LinkedList objectList = new LinkedList();

	private boolean hideOnSelection;

	private int preferredLayout;
	
	public CLabel getErrorMessageLabel() {
		return errorMessageLabel;
	}

	public void setErrorMessageLabel(CLabel errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	public String getErrorMessageString() {
		return errorMessageString;
	}

	public void setErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
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

	public int getOrientation() {
		return orientation;
	}



	public CTextInputPanel getTargetUI() {
		return targetUI;
	}

	public void setTargetUI(CTextInputPanel targetUI) {
		this.targetUI = targetUI;
	}

	
	public String getFieldToDisplay() {
		return fieldToDisplay;
	}

	public void setFieldToDisplay(String fieldToDisplay) {
		this.fieldToDisplay = fieldToDisplay;
	}

	

	@SuppressWarnings("unchecked")
	public String getLabelString() {
		return labelString;
	}

	public void setLabelString(String labelString) {
		this.labelString = labelString;
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

	public int getListWidth() {
		return listWidth;
	}

	public void setListWidth(int listWidth) {
		this.listWidth = listWidth;
	}

	public int getListHeight() {
		return listHeight;
	}

	public void setListHeight(int listHeight) {
		this.listHeight = listHeight;
	}
	public boolean isHideOnSelection() {
		return cSingleSelectList.isHideOnSelection();
	}

	public void setHideOnSelection(boolean hideOnSelection) {
		this.cSingleSelectList.setHideOnSelection(hideOnSelection);
	}


	public void init() {
		CUIFactory CUIFactory = new CUIFactory();

		cLabel = (CLabel) CUIFactory.createUIComponent(CUIComponentType.LABEL);
		cLabel = (CLabel) CUIFactory.setUI(cLabel);
		cLabel = (CLabel) CUIFactory.applyBorder(cLabel);
		cError = (CError) CUIFactory.createUIComponent(CUIComponentType.ERROR);

		cSingleSelectList = (CSingleSelectList) CUIFactory
				.createUIComponent(CUIComponentType.SINGLESELECTLIST);
		cSingleSelectList = (CSingleSelectList) CUIFactory
				.setUI(cSingleSelectList);
		cSingleSelectList = (CSingleSelectList) CUIFactory
				.applyBorder(cSingleSelectList);
		cSingleSelectList.cSetFieldToDisplay(fieldToDisplay);
	}

	@SuppressWarnings("unchecked")
	public CSingleSelectListInputPanel() {

	}

	public CSingleSelectList getcSingleSelectList() {
		return cSingleSelectList;
	}

	public void setcSingleSelectList(CSingleSelectList cSingleSelectList) {
		this.cSingleSelectList = cSingleSelectList;
	}

	public void addObjects(Object... objects) {
		{

			for (Object object : objects)
				objectList.add(object);
		}
	}

	public void addObject(Object object) {
		{

			objectList.add(object);
		}
	}

	public void addObject(List objectList) {
		{
			for (int i = 0; i < objectList.size(); i++) {
				objectList.add(objectList.get(i));
			}

		}
	}

	public void cSetFieldToDisplay(String fieldToDisplay) {
		cSingleSelectList.cSetFieldToDisplay(fieldToDisplay);
	}

	public void setCaption(String caption) {
		if (cLabel != null) {
			cLabel.setText(caption);
			cLabel.setDisplayedMnemonic(caption.charAt(0));
		}
	}

	

	public Object cGetSelectedObject() {
		return cSingleSelectList.getSelectedObject();
	}

	public void setOrientation(int orientation) {
		if (orientation == 1) {
			this.orientation = CUILayoutType.HORIZONTAL;
		}
		if (orientation == 2) {
			this.orientation = CUILayoutType.VERTICAL;
		}
	}

	private void cSetLabelWidth(int width) {
		Dimension dimension = new Dimension(width, cLabel.getHeight());
		this.cLabel.setPreferredSize(dimension);
		this.cLabel.setMaximumSize(dimension);
		this.cLabel.setMinimumSize(dimension);
		this.cLabel.setSize(dimension);
	}

	private void cSetLabelHeight(int height) {
		Dimension dimension = new Dimension(cLabel.getWidth(), height);
		this.cLabel.setPreferredSize(dimension);
		this.cLabel.setMaximumSize(dimension);
		this.cLabel.setMinimumSize(dimension);
		this.cLabel.setSize(dimension);

	}

	public void cSetLabelSize(int width, int height) {
		cSetLabelWidth(width);
		cSetLabelHeight(height);
	}

	public void cSetListWidth(int width) {
		Dimension dimension = new Dimension(width,
				cSingleSelectList.getHeight());
		this.cSingleSelectList.setPreferredSize(dimension);
		this.cSingleSelectList.setMaximumSize(dimension);
		this.cSingleSelectList.setMinimumSize(dimension);
		this.cSingleSelectList.setSize(dimension);
	}

	public void cSetListHeight(int height) {
		Dimension dimension = new Dimension(cSingleSelectList.getWidth(),
				height);
		this.cSingleSelectList.setPreferredSize(dimension);
		this.cSingleSelectList.setMaximumSize(dimension);
		this.cSingleSelectList.setMinimumSize(dimension);
		this.cSingleSelectList.setSize(dimension);

	}

	public void cSetListSize(int width, int height) {
		cSetListWidth(width);
		cSetListHeight(height);
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
	private void cSetErrorLabelSize(int width, int height) {
		cSetErrorLabelHeight(height);
		cSetErrorLabelWidth(width);

	}

	public void cSetListVisibleRowCount(int rowCount) {
		cSingleSelectList.setVisibleRowCount(rowCount);
	}
	private void setLabelText(){
		cLabel.setText(getLabelString());
	}
	private void setErrorText(){
		errorMessageLabel.setText(getErrorMessageString());
	}

	private void setComponentValues() {

		if (getLabelString() != null)
			this.setLabelText();
		targetUI.getInput().setText(cSingleSelectList.cGetSelectedObjectProperty(cSingleSelectList.getSelectedRow(),getFieldToDisplay()).toString());
			if(getErrorMessageString()!=null)
				this.setErrorText();
		checkComponentParameters();

	}

	public void cRenderGridBagLayout() {

		setComponentValues();

		GridBagLayout gridBagLayout = new GridBagLayout();

		cLabel.setHorizontalAlignment(CLabel.RIGHT);
		Insets insets = new Insets(5, 5, 5, 5);

		setConstraints(cLabel, gridBagLayout, 0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 2, 2);

		this.setLayout(gridBagLayout);
		this.add(cLabel);
		if (this.orientation == 1) {
			setConstraints(cSingleSelectList, gridBagLayout, 1, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST, GridBagConstraints.BOTH, insets,
					2, 2);
			this.add(cSingleSelectList);
			setConstraints(errorMessageLabel, gridBagLayout, 2, 0, 1, 1, 0, 0,
					GridBagConstraints.WEST,GridBagConstraints.BOTH, insets, 2, 2);
			this.add(errorMessageLabel);
		}
		if (this.orientation == 2) {

			this.setConstraints(cSingleSelectList, gridBagLayout, 0, 1, 1, 1, 0, 0,
					GridBagConstraints.WEST, GridBagConstraints.BOTH, insets,
					2, 2);
			this.add(cSingleSelectList);
			setConstraints(errorMessageLabel, gridBagLayout, 0, 2, 1, 1, 0, 0,
					GridBagConstraints.WEST,GridBagConstraints.BOTH, insets, 2, 2);
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
			cSetLabelWidth(labelHeight);
		if (errorMessageWidth != 0)
			cSetErrorLabelWidth(errorMessageWidth);
		if (errorMessageheight != 0)
			cSetErrorLabelHeight(errorMessageheight);
		if (listWidth != 0)
			cSetListWidth(listWidth);
		if (listHeight != 0)
			cSetListHeight(listHeight);
	}

	public void cRenderBoxLayout() {
		setComponentValues();

		checkComponentParameters();
		JPanel panel1,panel2;
		panel1=new JPanel();
		panel2=new JPanel();
		cLabel.setHorizontalAlignment(CLabel.RIGHT);
		panel1.add(cLabel);
		if (this.orientation == 1) {
			Box box = Box.createHorizontalBox();
			panel1.add(cLabel);
			panel2.add(cSingleSelectList);
			panel2.add(errorMessageLabel);
			box.add(panel1);
			box.add(panel2);
			this.add(box);

			
		}
		if (this.orientation == 2) {
			Box box = Box.createVerticalBox();
			panel1.add(cLabel);
			panel2.add(cSingleSelectList);
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

		cLabel.setHorizontalAlignment(CLabel.RIGHT);
		this.add(cLabel);
		

		this.add(cSingleSelectList);

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
		panel1.add(cLabel);
		panel1.add(cSingleSelectList);
		panel2.add(errorMessageLabel);
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
		if (!hideOnSelection) {
			if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
				cRenderFlowLayout();
			if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
				cRenderBorderLayout();
			if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
				cRenderBoxLayout();
			if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
				cRenderGridBagLayout();
		}
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	@Override
	public void hide() {

		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	@Override
	public void show() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

}
