package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.polaris.teamd.common.utils.UIUtil;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.custom.inputpanel.CInputPanel;

/**
 * This class is to add the input panels to the form
 * @author
 *
 */

public class CForm extends JPanel {
	private ArrayList<JPanel> inputPanelList;
	private ArrayList<CoOrdinates> coords = new ArrayList<CForm.CoOrdinates>();
	private ArrayList<Size> sizes = new ArrayList<CForm.Size>();
	private JPanel panel;
	private CFormHeader formHeader;
	private CActionPanel actionPanel;
	private CUIFactory factory = new CUIFactory();
	private CLabel status = new CLabel("Status");
	private Box[] boxes;
	private CButton closeButton = (CButton) factory
			.createUIComponent(CUIComponentType.BUTTON);
	private JPanel cFormFooter = new JPanel();

	/**
	 * This is the non parameterized constructor
	 */
	public CForm() {
	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param formLabel
	 */
	public CForm(String formLabel) {
		super();
		cInit(formLabel);
	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param formLabel
	 * @param buttonCaptions
	 */
	public CForm(String formLabel, String... buttonCaptions) {
		super();
		cInit(formLabel, buttonCaptions);
	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param isDoubleBuffered
	 */
	public CForm(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param layout
	 * @param isDoubleBuffered
	 */

	public CForm(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param layout
	 */
	public CForm(LayoutManager layout) {
		super(layout);

	}

	/**
	 * This is the parameterized constructor
	 * 
	 * @param cInputPanel
	 */
	public CForm(CInputPanel cInputPanel) {
		super();
	}

	/**
	 * This method returs a cbutton object
	 * 
	 * @return
	 */
	public CButton getCloseButton() {
		return closeButton;
	}

	/**
	 * This method initializes the cbutton object
	 * 
	 * @param closeButton
	 */
	public void setCloseButton(CButton closeButton) {
		this.closeButton = closeButton;
	}

	/**
	 * This class sets the positon for the input panels
	 * 
	 * @author
	 * 
	 */
	class CoOrdinates implements Comparable<CoOrdinates> {
		int xPos, yPos;

		/**
		 * This is the parameterized constructor
		 */
		public CoOrdinates() {
			super();
		}

		/**
		 * This is the parameterized constructor
		 * 
		 * @param xPos
		 * @param yPos
		 */
		public CoOrdinates(int xPos, int yPos) {
			super();
			this.xPos = xPos;
			this.yPos = yPos;
		}

		/**
		 * This method returns the x cordinate position
		 * 
		 * @return
		 */
		public int getxPos() {
			return xPos;
		}

		/**
		 * This method sets the x coordinate position
		 * 
		 * @param xPos
		 */
		public void setxPos(int xPos) {
			this.xPos = xPos;
		}

		/**
		 * This method returns y coordinate position
		 * 
		 * @return
		 */
		public int getyPos() {
			return yPos;
		}

		/**
		 * This method sets the y coordinate position
		 * 
		 * @param yPos
		 */
		public void setyPos(int yPos) {
			this.yPos = yPos;
		}

		/**
		 * This method compares the x and y coordinate position
		 */
		@Override
		public int compareTo(CoOrdinates o) {
			return this.yPos - o.yPos;
		}

	}

	/**
	 * This class is to set the size for the input panel
	 * 
	 * @author
	 * 
	 */
	class Size {
		int width, height;

		/**
		 * This is the non parameterized constructor
		 */
		public Size() {
			super();
		}

		/**
		 * This is the parameterized constructor
		 * 
		 * @param width
		 * @param height
		 */
		public Size(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}

		/**
		 * This method returns the width value
		 * 
		 * @return
		 */
		public int getWidth() {
			return this.width;
		}

		/**
		 * This method sets the width of the input panel
		 * 
		 * @param width
		 */
		public void setWidth(int width) {
			this.width = width;
		}

		/**
		 * This method returns the height value
		 * 
		 * @return
		 */
		public int getHeight() {
			return this.height;
		}

		/**
		 * This method sets the height value to the panel
		 * 
		 * @param height
		 */
		public void setHeight(int height) {
			this.height = height;
		}

	}

	/**
	 * This method is to set the header for the form
	 * 
	 * @param formCaption
	 */
	public void cInit(String formCaption) {
		inputPanelList = new ArrayList<JPanel>();
		formHeader = new CFormHeader();
		formHeader.cSetText(formCaption);
		// status = new CLabel(statusCaption);
		// actionPanel = new CActionPanel();
		// panel = new CInputPanel();
		// panel.setLayout(new GridLayout());
	}

	/**
	 * This method initializes the input panel components
	 * 
	 * @param formCaption
	 * @param buttonCaptions
	 */
	public void cInit(String formCaption, String... buttonCaptions) {
		inputPanelList = new ArrayList<JPanel>();
		formHeader = new CFormHeader();
		formHeader.cSetText(formCaption);
		actionPanel = new CActionPanel();
		actionPanel.cAdd(buttonCaptions);
		// actionPanel = actionPanel.csetCaption();
		// panel = new CInputPanel();
		panel.setLayout(new GridLayout());
	}

	/**
	 * This method is to set the caption for status bar
	 * 
	 * @param statusCaption
	 */
	public void cSetStatus(String statusCaption) {
		status = new CLabel(statusCaption);
	}

	/**
	 * This method returns the status
	 * 
	 * @return
	 */
	public CLabel getStatus() {
		return status;
	}

	/**
	 * This method sets the position for the frame
	 * 
	 * @param index
	 * @param row
	 * @param column
	 */
	public void setPosition(int index, int row, int column) {
		CoOrdinates coOrdinates = coords.get(index);
		coOrdinates.setxPos(column);
		coOrdinates.setyPos(row);
	}

	/**
	 * This method sets the size of the panels
	 * 
	 * @param index
	 * @param width
	 * @param height
	 */
	public void cSetSize(int index, int width, int height) {
		System.out.println("***--->" + width + "  " + height);
		Size size = sizes.get(index);
		size.setWidth(width);
		size.setHeight(height);
		System.out.println(sizes.get(index).getWidth());
	}

	/**
	 * This method is to hide the input panel from the form
	 * 
	 * @param index
	 */

	public void hide(int index) {
		inputPanelList.get(index).setVisible(false);
		refresh();
	}

	/**
	 * This method is to show the input panel in the form
	 * 
	 * @param index
	 */
	public void show(int index) {
		inputPanelList.get(index).setVisible(true);
		refresh();
	}

	/**
	 * This method refreshes the form
	 */
	public void refresh() {
		invalidate();
		validate();
	}

	/**
	 * This method returns the form header
	 * 
	 * @return
	 */
	public CFormHeader getCFormHeader() {
		return this.formHeader;
	}

	/**
	 * This method adds the input panels to the form
	 * 
	 * @param inputPanel
	 */
	public void cAddInputPanel(JPanel inputPanel) {
		inputPanelList.add(inputPanel);
		coords.add(new CoOrdinates());
		sizes.add(new Size());
		System.out.println(inputPanelList.size() + "," + coords.size() + ","
				+ sizes.size());
	}

	/**
	 * This method calculates the no of rows in the form
	 * 
	 * @return
	 */
	public int calculateRows() {
		Collections.sort(coords);
		CoOrdinates maxRowCordinate = Collections.max(coords);
		System.out.println(maxRowCordinate);
		int maxRow = maxRowCordinate.getyPos();
		System.out.println("Max Rows : " + (maxRow + 1));
		boxes = new Box[maxRow + 1];
		for (int i = 0; i < maxRow + 1; i++) {
			boxes[i] = Box.createHorizontalBox();
			// boxes[i].setAlignmentY(Box.TOP_ALIGNMENT);
		}
		return maxRow;

	}

	/**
	 * This method returns the footer for the form
	 * 
	 * @return
	 */
	public JPanel getcFormFooter() {
		return cFormFooter;
	}

	/**
	 * This method sets the footer for the form
	 * 
	 * @param cFormFooter
	 */

	public void setcFormFooter(JPanel cFormFooter) {
		this.cFormFooter = cFormFooter;
	}

	public JPanel preparecFormFooter() {
		cFormFooter.setLayout(new BorderLayout());
		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CForm.this.setVisible(false);
			}
		});

		cFormFooter.add(status, BorderLayout.WEST);
		cFormFooter.add(closeButton, BorderLayout.EAST);
		return cFormFooter;
	}

	/**
	 * This method is to display the form
	 * 
	 * @return
	 */
	public CForm render() {
		// calculateRows();
		// System.out.println("totsl boxes " + boxes.length);
		Box[] boxes = new Box[3];
		boxes[0] = Box.createVerticalBox();
		boxes[1] = Box.createVerticalBox();
		boxes[2] = Box.createVerticalBox();
		boxes[0].setSize(600, 400);
		boxes[1].setSize(600, 400);
		boxes[2].setSize(600, 400);

		setLayout(new BorderLayout());
		this.add(getCFormHeader(), BorderLayout.NORTH);

		JPanel panel = new JPanel();
		// BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		// panel.setLayout(boxLayout);

		int index = 0;

		for (JPanel inputPanel : inputPanelList) {
			System.out.println("iterating");
			System.out.println(coords.get(index).getyPos());
			// panel.add(inputPanel);
			int w = sizes.get(index).getWidth();
			int h = sizes.get(index).getHeight();
			System.out.println(w + "," + h);
			inputPanel.setMinimumSize(new Dimension(w, h));
			inputPanel.setPreferredSize(new Dimension(w, h));
			inputPanel.setMaximumSize(new Dimension(w, h));
			inputPanel.setSize(new Dimension(w, h));
			// inputPanel.cRender();
			inputPanel.setBorder(UIUtil.createSimpleBorder());
			boxes[coords.get(index).getxPos()].add(inputPanel);
			// panel.add(inputPanel);
			index++;

		}

		for (int i = 0; i < boxes.length; i++) {
			panel.add(boxes[i]);
		}

		this.add(panel, BorderLayout.CENTER);

		// JPanel jPanel = preparecFormFooter();
		// this.add(jPanel, BorderLayout.SOUTH);

		// this.add(cActionPanel.csetCaption(), BorderLayout.SOUTH);
		// this.add(status, BorderLayout.SOUTH);
		return this;
	}

	/**
	 * This method is to render the form in flowlayout
	 * 
	 * @return
	 */
	public CForm renderFlowLayout() {

		setLayout(new BorderLayout());
		this.add(getCFormHeader(), BorderLayout.NORTH);

		JPanel jPanel = new JPanel(new FlowLayout());
		for (JPanel cInputPanel : inputPanelList) {
			// cInputPanel.render();
			jPanel.add(cInputPanel);
			System.out.println("Form rendering in loop");

		}
		this.add(jPanel, BorderLayout.CENTER);

		JPanel jPanel1 = preparecFormFooter();
		this.add(jPanel1, BorderLayout.SOUTH);

		return this;
	}
	public CForm renderHorizontalBox() {
		//calculateRows();
		//System.out.println("totsl boxes " + boxes.length);
		Box[] boxes=new Box[3];
		boxes[0]=Box.createHorizontalBox();
		boxes[1]=Box.createHorizontalBox();
		boxes[2]=Box.createHorizontalBox();
		boxes[0].setSize(600, 1400);
		boxes[1].setSize(600, 1400);
		boxes[2].setSize(600, 1400);

		setLayout(new BorderLayout());
		this.add(getCFormHeader(), BorderLayout.NORTH);

		JPanel panel = new JPanel();
		//BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		int index = 0;

		for (JPanel inputPanel : inputPanelList) {
			System.out.println("iterating");
			System.out.println(coords.get(index).getyPos());
			//panel.add(inputPanel);
			int w = sizes.get(index).getWidth();
			int h = sizes.get(index).getHeight();
			System.out.println(w + "," + h);
			inputPanel.setMinimumSize(new Dimension(w, h));
			inputPanel.setPreferredSize(new Dimension(w, h));
			inputPanel.setMaximumSize(new Dimension(w, h));
			inputPanel.setSize(new Dimension(w, h));
			//inputPanel.cRender();
			inputPanel.setBorder(UIUtil.createSimpleBorder());
			boxes[coords.get(index).getyPos()].add(inputPanel);
			//panel.add(inputPanel);
			index++;

		}

		for (int i = 0; i < boxes.length; i++) {
			panel.add(boxes[i]);
		}

		this.add(panel, BorderLayout.CENTER);
		
		//JPanel jPanel = preparecFormFooter();
		//this.add(jPanel, BorderLayout.SOUTH);

		// this.add(cActionPanel.csetCaption(), BorderLayout.SOUTH);
		// this.add(status, BorderLayout.SOUTH);
		return this;
	}
	/**
	 * This method is to display the form in gridbag layout
	 * 
	 * @return
	 */
	public CForm renderGridBagLayout() {
		setLayout(new BorderLayout());
		this.add(getCFormHeader(), BorderLayout.NORTH);
		JPanel jPanel = new JPanel();
		int index = 0;
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		for (JPanel cInputPanel : inputPanelList) {
			//cInputPanel.cRender();
			gbc.gridx = 0;
			gbc.gridy = index++;
			gbc.weightx = 0.1;
			gbc.weighty = 0.2;

			gbc.anchor = GridBagConstraints.LINE_START;

			gridBagLayout.setConstraints(cInputPanel, gbc);
			jPanel.add(cInputPanel);
		}
		
		
		this.add(jPanel, BorderLayout.CENTER);
		
		JPanel jPanel1 = preparecFormFooter();
		this.add(jPanel1, BorderLayout.SOUTH);
		return this;

	}
	public CForm render1(int wrap) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Box box=Box.createHorizontalBox();
		box.add(getCFormHeader());
		this.add(box);
		int count=inputPanelList.size();
		Box[] horizontalBoxes=new Box[count];
		for(int i=0;i<count;i++)
			horizontalBoxes[i]=Box.createHorizontalBox();
		Box[] panelBoxes=new Box[count];
		for(int i=0;i<count;i++){
			panelBoxes[i]=Box.createVerticalBox();
			panelBoxes[i].setSize(200, 30);
		}
		JPanel panel = new JPanel();
		int horizontalCount=0;
		int index = 0;
		int wrapFlag=1;
		for (JPanel inputPanel : inputPanelList) {
			System.out.println("iterating");
			System.out.println(coords.get(index).getyPos());
			int w = sizes.get(index).getWidth();
			int h = sizes.get(index).getHeight();
			System.out.println(w + "," + h);
			inputPanel.setMinimumSize(new Dimension(w, h));
			inputPanel.setPreferredSize(new Dimension(w, h));
			inputPanel.setMaximumSize(new Dimension(w, h));
			inputPanel.setSize(new Dimension(w, h));
			inputPanel.setBorder(UIUtil.createSimpleBorder());
			panelBoxes[index].add(inputPanel);
			horizontalBoxes[horizontalCount].add(panelBoxes[index]);
			System.out.println("hor"+horizontalCount);
//			if(index%wrap!=0){
//				
//			System.out.println("horizontal added"+horizontalCount+", "+index);
////				verticalBox.add(horizontalBoxes[horizontalCount]);
//				++horizontalCount;
//			}
			if(wrapFlag==wrap){
				wrapFlag=0;
				++horizontalCount;
			}
			wrapFlag++;
			index++;
		}
		for(Box box2:horizontalBoxes)
			this.add(box2);
		return this;
	}
	public ArrayList<JPanel> cGetInputPanels() {
		return inputPanelList;
	}

	public JPanel getInputPanel(int index) {
		return inputPanelList.get(index);
	}
}
