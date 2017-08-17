package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CMultiCheck;

public class CMultiCheckInputPanel extends JPanel {
	private CLabel commonLabel,mandatoryLabel;
	private CMultiCheck multiCheck;
	private int orientation;
	private boolean isMandatory;
	private String labelString,mandatoryMarker;
	private int labelWidth,labelHeight,multiCheckHeight,multiChecktWidth;
	private int preferredLayout;

	public CMultiCheckInputPanel() {
		labelString="";
		mandatoryMarker="*";
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

	public int getMultiCheckHeight() {
		return multiCheckHeight;
	}

	public void setMultiCheckHeight(int multiCheckHeight) {
		this.multiCheckHeight = multiCheckHeight;
	}

	public int getMultiChecktWidth() {
		return multiChecktWidth;
	}

	public void setMultiChecktWidth(int multiChecktWidth) {
		this.multiChecktWidth = multiChecktWidth;
	}

	public CLabel cGetCommonLabel() {
		return commonLabel;
	}


	public void cSetCommonLabel(CLabel commonLabel) {
		this.commonLabel = commonLabel;
	}


	public CLabel cGetMandatoryLabel() {
		return mandatoryLabel;
	}


	public void cSetMandatoryLabel(CLabel mandatoryLabel) {
		this.mandatoryLabel = mandatoryLabel;
	}


	public CMultiCheck cGetMultiCheck() {
		return multiCheck;
	}


	public void cSetMultiCheck(CMultiCheck multiCheck) {
		this.multiCheck = multiCheck;
	}


	public int cGetOrientation() {
		return orientation;
	}


	public void cSetOrientation(int orientation) {
		this.orientation = orientation;
	}


	public boolean isMandatory() {
		return isMandatory;
	}


	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}


	public String cSetLabelString() {
		return labelString;
	}


	public void cSetLabelString(String labelString) {
		this.labelString = labelString;
	}


	public String cGetMandatoryMarker() {
		return mandatoryMarker;
	}


	public void cSetMandatoryMarker(String mandatoryMarker) {
		this.mandatoryMarker = mandatoryMarker;
	}


	public final void cSetSelectedObjects(Object... selectedObjects) {
			multiCheck.cSetSelectedObjects(selectedObjects);
	}

	public Object cGetSelectedObject() {
		return multiCheck.cGetSelectedObject();
	}

	private void cSetLabelSize(int width, int height) {
		Dimension dimension=new Dimension(width, height);
		commonLabel.setPreferredSize(dimension);
		commonLabel.setMaximumSize(dimension);
		commonLabel.setMinimumSize(dimension);
		commonLabel.setSize(width, height);
	}
	
	private void cSetMultiCheckSize(int width, int height) {
		Dimension dimension=new Dimension(width, height);
		multiCheck.setPreferredSize(dimension);
		multiCheck.setMaximumSize(dimension);
		multiCheck.setMinimumSize(dimension);
		multiCheck.setSize(width, height);
	}

	/**
	 * This function is used to set the dimension of the components inside the multiCheckInputPanel
	 */
	private void cSetComponentAttributes(){	
		if (commonLabel != null) {
			if (labelWidth != 0 && labelHeight == 0)
				cSetLabelSize(labelWidth, 15);
			if (labelWidth == 0 && labelHeight != 0)
				cSetLabelSize(50, labelHeight);
			if (labelWidth != 0 && labelHeight != 0)
				cSetLabelSize(labelWidth, labelHeight);
			commonLabel.setText(labelString);
		}
		if(multiCheck!=null){
			if(multiCheckHeight!=0&&multiChecktWidth==0)
				cSetMultiCheckSize(50, multiCheckHeight);
			if(multiCheckHeight==0&&multiChecktWidth!=0)
				cSetMultiCheckSize(multiChecktWidth, 15);
			if(multiCheckHeight!=0&&multiChecktWidth!=0)
				cSetMultiCheckSize(multiChecktWidth, multiCheckHeight);
		}
	}		
	public void cInit(){
		CUIFactory cUIFactory=new CUIFactory();
		if(commonLabel==null){
			commonLabel = (CLabel) cUIFactory.createUIComponent(CUIComponentType.LABEL);
			commonLabel = (CLabel) cUIFactory.setUI(commonLabel);
		}
		if(multiCheck==null){
			multiCheck=(CMultiCheck) cUIFactory.createUIComponent(CUIComponentType.MULTICHECKBOX);
			multiCheck = (CMultiCheck) cUIFactory.setUI(multiCheck);
		}
		if (isMandatory) {
			mandatoryLabel = (CLabel) cUIFactory.createUIComponent(CUIComponentType.LABEL);
			mandatoryLabel = (CLabel) cUIFactory.setUI(mandatoryLabel);
			mandatoryLabel.setText(mandatoryMarker);
			mandatoryLabel.setForeground(Color.RED);
			mandatoryLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		}
	}
	
	/**
	 * This function renders the multiCheckInputPanel in FlowLayout
	 */
	public void cRenderFlowLayout(){
		this.cInit();
		this.cSetComponentAttributes();
		FlowLayout flowLayout=new FlowLayout(FlowLayout.LEFT,0,0);
		this.setLayout(flowLayout);
		this.add(commonLabel);
		if(isMandatory) this.add(mandatoryLabel);
		this.add(multiCheck);
		this.setVisible(true);
	}
	/**
	 * This function is used to define the constraint fields for the given GridBagConstraints  variable
	 * 
	 */
	private void cSetGBConstraints(GridBagConstraints gbc,int gridx,int gridy,double weightx,double weighty,int gridwidth,int gridheight){

		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx=gridx;
		gbc.gridy=gridy;
		gbc.weightx=weightx;
		gbc.weighty=weighty;
		gbc.gridheight=gridheight;
		gbc.gridwidth=gridwidth;		 
	}

	/**
	 * This function gives a labelPanel which contains a label and a marker
	 */
	
	private JPanel cGetLabelPanel(){
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		commonLabel.setHorizontalAlignment(CLabel.RIGHT);
		labelPanel.add(commonLabel);
		if(isMandatory) 
			labelPanel.add(mandatoryLabel);			
		return labelPanel;
	}
	/**
	 * This function renders the multiCheckInputPanel in GridBagLayout
	 */
	public void cRenderGridBagLayout() {

		this.cInit();
		this.cSetComponentAttributes();

		GridBagLayout gridBagLayout = new GridBagLayout();		
		GridBagConstraints multiTextConstraints = new GridBagConstraints();

		JPanel labelPanel = cGetLabelPanel();
		this.setLayout(gridBagLayout);
		cSetGBConstraints(multiTextConstraints, 0, 0, 1, 1, 1, 1);
		gridBagLayout.setConstraints(labelPanel, multiTextConstraints);
		this.add(labelPanel);
		if (this.orientation == CUILayoutType.VERTICAL) {
			System.out.println("in vertical");
			cSetGBConstraints(multiTextConstraints, 0,1 , 1, 1 ,1 ,multiCheck.cGetNumberOfChecks() );
			gridBagLayout.setConstraints(multiCheck, multiTextConstraints);			
			this.add(multiCheck);
		} else {
			cSetGBConstraints(multiTextConstraints, 1, 0, 1, 1, 1, 1);
			gridBagLayout.setConstraints(multiCheck, multiTextConstraints);
			this.add(multiCheck);
		}		
		this.setVisible(true);
		System.out.println("rendered");
	}
	
	
	/**
	 * This function renders the multiCheckInputPanel in BoxLayout
	 */
	public void cRenderBoxLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		if (this.orientation == CUILayoutType.VERTICAL) {	
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box=Box.createVerticalBox();
			box.add(commonLabel,Box.TOP_ALIGNMENT);
			if (isMandatory) box.add(mandatoryLabel,Box.TOP_ALIGNMENT);
			box.add(multiCheck,Box.TOP_ALIGNMENT);
			this.add(box);
		} else {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box=Box.createHorizontalBox();
			box.add(commonLabel,Box.TOP_ALIGNMENT);
			if (isMandatory) box.add(mandatoryLabel,Box.TOP_ALIGNMENT);
			box.add(multiCheck,Box.TOP_ALIGNMENT);
		}
		this.setVisible(true);
	}
	
	/**
	 * This function renders the multiCheckInputPanel in BorderLayout
	 */
	public void cRenderBorderLayout(){
		this.cInit();
		this.cSetComponentAttributes();
		JPanel labelPanel=cGetLabelPanel();
		this.setLayout(new BorderLayout());
		if(this.orientation==CUILayoutType.VERTICAL){
			this.add(labelPanel,BorderLayout.NORTH);
			this.add(multiCheck,BorderLayout.CENTER);
		}else{
			JPanel combinedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 25));
			combinedPanel.add(labelPanel);
			combinedPanel.add(multiCheck);
			this.add(combinedPanel,BorderLayout.CENTER);
		}		
	}
	
	public void cShow(){
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}
	
	public void cHide(){
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}
	
	public void cRefresh(){
		this.removeAll();
		if(preferredLayout==CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if(preferredLayout==CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
		if(preferredLayout==CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if(preferredLayout==CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
	}
	
	public void cAddFocusListener(FocusListener focusListener){
		if(multiCheck!=null) multiCheck.addFocusListener(focusListener);
	}
	
	public void cAddMouseListener(MouseListener mouseListener){
		if(multiCheck!=null) multiCheck.addMouseListener(mouseListener);
	}

	public void cAddActionListener(ActionListener actionListener){
		if(multiCheck!=null) multiCheck.addActionListener(actionListener);
	}

	@Override
	public String toString() {
		return "CMultiCheckInputPanel [commonLabel=" + commonLabel
				+ ",\n mandatoryLabel=" + mandatoryLabel + ", multiCheck="
				+ multiCheck + ", orientation=" + orientation
				+ ",\n isMandatory=" + isMandatory + ", labelString="
				+ labelString + ", mandatoryMarker=" + mandatoryMarker
				+ ", \nlabelWidth=" + labelWidth + ", labelHeight=" + labelHeight
				+ ", multiCheckHeight=" + multiCheckHeight
				+ ", multiChecktWidth=" + multiChecktWidth
				+ ", preferredLayout=" + preferredLayout + "]";
	}


}
