package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.CLayoutPreferences;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;
import com.polaris.teamd.ui.CUILayoutType;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CFilterTable;
import com.polaris.teamd.ui.custom.CText;

/**
 * FilterTableInputTablePanel contains a search Panel(label,textBox,button) and
 * a singleSelectTable
 * 
 * @author ManiBalaSambandam
 * 
 */
public class CFilterTableInputPanel extends JPanel {
	private CLabel searchLabel;
	private CText searchInput;
	private CButton searchButton;
	private CSingleSelectInputTable table;
	private TableRowSorter<TableModel> rowSorter;
	private TableModel model;
	private int orientation;
	private String selectPropertyName;
	private CTextInputPanel targetPanel;
	private String labelString, inputString, buttonString;
	private int labelWidth, labelHeight, inputWidth, inputHeight, buttonWidth,
			buttonHeight, tableWidth, tableHeight;
	private int preferredLayout;

	public CFilterTableInputPanel() {
		super();
	}

	public CLabel getSearchLabel() {
		return searchLabel;
	}

	public void setSearchLabel(CLabel searchLabel) {
		this.searchLabel = searchLabel;
	}

	public CText getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(CText searchInput) {
		this.searchInput = searchInput;
	}

	public CButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(CButton searchButton) {
		this.searchButton = searchButton;
	}

	public CSingleSelectInputTable getTable() {
		return table;
	}

	public void setTable(CFilterTable table) {
		this.table = table;
	}

	public String getSelectPropertyName() {
		return selectPropertyName;
	}

	public void setSelectPropertyName(String selectPropertyName) {
		this.selectPropertyName = selectPropertyName;
	}

	public CTextInputPanel getTargetPanel() {
		return targetPanel;
	}

	public void setTargetPanel(CTextInputPanel targetPanel) {
		this.targetPanel = targetPanel;
	}

	public String getLabelString() {
		return labelString;
	}

	public void setLabelString(String labelString) {
		this.labelString = labelString;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getButtonString() {
		return buttonString;
	}

	public void setButtonString(String buttonString) {
		this.buttonString = buttonString;
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

	public int getButtonWidth() {
		return buttonWidth;
	}

	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}

	public int getButtonHeight() {
		return buttonHeight;
	}

	public void setButtonHeight(int buttonHeight) {
		this.buttonHeight = buttonHeight;
	}

	public int getTableWidth() {
		return tableWidth;
	}

	public void setTableWidth(int tableWidth) {
		this.tableWidth = tableWidth;
	}

	public int getTableHeight() {
		return tableHeight;
	}

	public void setTableHeight(int tableHeight) {
		this.tableHeight = tableHeight;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

	public int getPreferredLayout() {
		return preferredLayout;
	}

	public void setPreferredLayout(int preferredLayout) {
		this.preferredLayout = preferredLayout;
	}

	public void cAddObject(Object object) {
		cAddObject(object);
	}

	public void cAddObjects(Object... objects) {
		for (Object e : objects) {
			cAddObject(e);
		}
	}

	public void cAddObjects(Collection<Object> objectList) {
		for (Object e : objectList)
			cAddObject(e);
	}

	public Object cGetSelectedObject() {
		return cGetSelectedObject();
	}

	public void cSetColumnWidth(int columnIndex, int width) {
		cSetColumnWidth(columnIndex, width);
	}

	public void cSetAllRowHeights(int height) {
		cSetAllRowHeights(height);
	}

	public void cSetRowHeight(int rowIndex, int height) {
		cSetRowHeight(rowIndex, height);
	}

	public void csetCellEditor(int index, TableCellEditor tableCellEditor) {
		csetCellEditor(index, tableCellEditor);
	}

	public void cSetTableCellRender(int index,
			TableCellRenderer tableCellRenderer) {
		cSetTableCellRender(index, tableCellRenderer);
	}

	private void cSetLabelSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		searchLabel.setPreferredSize(dimension);
		searchLabel.setMaximumSize(dimension);
		searchLabel.setMinimumSize(dimension);
		searchLabel.setSize(width, height);
	}

	private void cSetInputSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		searchInput.setPreferredSize(dimension);
		searchInput.setMaximumSize(dimension);
		searchInput.setMinimumSize(dimension);
		searchInput.setSize(dimension);
	}

	private void cSetButtonSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		searchButton.setPreferredSize(dimension);
		searchButton.setMaximumSize(dimension);
		searchButton.setMinimumSize(dimension);
		searchButton.setSize(dimension);
	}

	private void cSetTableSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		table.setPreferredSize(dimension);
		table.setMaximumSize(dimension);
		table.setMinimumSize(dimension);
		table.setSize(width, height);
	}

	/**
	 * This function is used to set the dimension of the components inside the
	 * filterTableInputPanel
	 */
	private void cSetComponentAttributes() {
		if (searchLabel != null) {
			if (labelWidth != 0 && labelHeight == 0)
				cSetLabelSize(labelWidth, 15);
			if (labelWidth == 0 && labelHeight != 0)
				cSetLabelSize(50, labelHeight);
			if (labelWidth != 0 && labelHeight != 0)
				cSetLabelSize(labelWidth, labelHeight);
			searchLabel.setText(labelString);
		}
		if (searchInput != null) {
			if (inputWidth != 0 && inputHeight == 0)
				this.cSetInputSize(inputWidth, searchInput.getHeight());
			if (inputWidth == 0 && inputHeight != 0)
				this.cSetInputSize(searchInput.getWidth(), inputHeight);
			if (inputWidth != 0 && inputHeight != 0)
				this.cSetInputSize(inputWidth, inputHeight);
			searchInput.setText(inputString);
		}
		if (searchButton != null) {
			if (buttonWidth != 0 && buttonHeight == 0)
				this.cSetButtonSize(buttonWidth, searchButton.getHeight());
			if (buttonWidth == 0 && buttonHeight != 0)
				this.cSetButtonSize(searchButton.getWidth(), buttonHeight);
			if (buttonWidth != 0 && buttonHeight != 0)
				this.cSetButtonSize(buttonWidth, buttonHeight);
			searchButton.setText(buttonString);
		}
		if (table != null) {
			if (tableWidth != 0 && tableHeight == 0)
				this.cSetTableSize(tableWidth, table.getHeight());
			if (tableWidth == 0 && tableHeight != 0)
				this.cSetTableSize(table.getWidth(), tableHeight);
			if (tableWidth != 0 && tableHeight != 0)
				this.cSetTableSize(tableWidth, tableHeight);
		}
	}

	/**
	 * This function initializes the components if not set by the user
	 */
	public void cInit() {
		CUIFactory cuiFactory = new CUIFactory();
		if (searchLabel == null) {
			searchLabel = (CLabel) cuiFactory
					.createUIComponent(CUIComponentType.LABEL);
			searchLabel = (CLabel) cuiFactory.setUI(searchLabel);
		}
		if (searchInput == null) {
			searchInput = (CText) cuiFactory
					.createUIComponent(CUIComponentType.TEXT);
			searchInput = (CText) cuiFactory.setUI(searchInput);
			searchInput.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					CText field = (CText) e.getSource();
					String str = field.getText();
					if (str.length() > 0)
						rowSorter.setRowFilter(RowFilter.regexFilter(str));
					else
						rowSorter.setRowFilter(null);
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
		}
		if (searchButton == null) {
			searchButton = (CButton) cuiFactory
					.createUIComponent(CUIComponentType.BUTTON);
			searchButton = (CButton) cuiFactory.setUI(searchButton);
			searchButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str = searchInput.getText();
					if (str.length() > 0)
						rowSorter.setRowFilter(RowFilter.regexFilter(str));
					else
						rowSorter.setRowFilter(null);
				}
			});
		}
		if (table == null) {
			table = (CSingleSelectInputTable) cuiFactory
					.createUIComponent(CUIComponentType.SINGLESELECTINPUTTABLE);
			table = (CSingleSelectInputTable) cuiFactory.setUI(table);
			rowSorter = new TableRowSorter<TableModel>(model);
			table.setRowSorter(rowSorter);
		}
	}

	/**
	 * This function renders the filterTableInputPanel in FlowLayout
	 */
	public void cRenderFlowLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 25, 25);
		this.setLayout(flowLayout);
		this.add(searchLabel);
		this.add(searchInput);
		this.add(searchButton);
		this.add(table);
		this.setVisible(true);
	}

	/**
	 * This function is used to define the constraint fields for the given
	 * GridBagConstraints variable
	 * 
	 */
	private void cSetGBConstraints(GridBagConstraints gbc, int gridx,
			int gridy, double weightx, double weighty, int gridwidth,
			int gridheight) {
		System.out.println("1");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridheight = gridheight;
		gbc.gridwidth = gridwidth;
	}

	/**
	 * This function gives a searchPanel which contains a label,a textBox and a
	 * button
	 */

	private JPanel cGetSearchPanel() {
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchLabel.setHorizontalAlignment(CLabel.RIGHT);
		searchPanel.add(searchLabel);
		searchPanel.add(searchInput);
		searchPanel.add(searchButton);
		return searchPanel;
	}

	/**
	 * This function renders the filterTableInputPanel in GridBagLayout
	 */
	public void cRenderGridBagLayout() {
		this.cInit();
		this.cSetComponentAttributes();

		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints filterPanelConstraints = new GridBagConstraints();

		JPanel searchPanel = cGetSearchPanel();
		this.setLayout(gridBagLayout);
		cSetGBConstraints(filterPanelConstraints, 0, 0, 1, 1, 1, 1);
		gridBagLayout.setConstraints(searchPanel, filterPanelConstraints);
		this.add(searchPanel);
		if (this.orientation == CUILayoutType.VERTICAL) {
			cSetGBConstraints(filterPanelConstraints, 0, 1, 1, 1,
					table.getColumnCount(), 15);
			gridBagLayout.setConstraints(table, filterPanelConstraints);
			this.add(table);
		} else {
			cSetGBConstraints(filterPanelConstraints, 1, 0, 1, 1,
					table.getColumnCount(), 15);
			gridBagLayout.setConstraints(table, filterPanelConstraints);
			this.add(table);
		}
		this.setVisible(true);
		System.out.println("rendered");
	}

	/**
	 * This function renders the filterTableInputPanel in BoxLayout
	 */
	public void cRenderBoxLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		if (this.orientation == CUILayoutType.VERTICAL) {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box = Box.createVerticalBox();
			box.add(cGetSearchPanel(), Box.TOP_ALIGNMENT);
			box.add(table, Box.TOP_ALIGNMENT);
			this.add(box);
		} else {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			Box box = Box.createHorizontalBox();
			box.add(cGetSearchPanel(), Box.TOP_ALIGNMENT);
			box.add(table, Box.TOP_ALIGNMENT);
			this.add(box);
		}
		this.setVisible(true);
	}

	/**
	 * This function renders the filterTableInputPanel in BorderLayout
	 */
	public void cRenderBorderLayout() {
		this.cInit();
		this.cSetComponentAttributes();
		JPanel searchPanel = cGetSearchPanel();
		this.setLayout(new BorderLayout());
		if (this.orientation == CUILayoutType.VERTICAL) {
			this.add(searchPanel, BorderLayout.NORTH);
			this.add(table, BorderLayout.CENTER);
		} else {
			JPanel combinedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,
					25, 25));
			combinedPanel.add(searchPanel);
			combinedPanel.add(table);
			this.add(combinedPanel, BorderLayout.CENTER);
		}
	}

	public void cShow() {
		this.setVisible(true);
		invalidate();
		validate();
		repaint();
	}

	public void cHide() {
		this.setVisible(false);
		invalidate();
		validate();
		repaint();
	}

	public void cRefresh() {
		this.removeAll();
		if (preferredLayout == CLayoutPreferences.BOXLAYOUT)
			cRenderBoxLayout();
		if (preferredLayout == CLayoutPreferences.GRIDBAGLAYOUT)
			cRenderGridBagLayout();
		if (preferredLayout == CLayoutPreferences.FLOWLAYOUT)
			cRenderFlowLayout();
		if (preferredLayout == CLayoutPreferences.BORDERLAYOUT)
			cRenderBorderLayout();
	}

	public void cAddFocusListener(FocusListener focusListener) {
		if (table != null)
			table.addFocusListener(focusListener);
	}

	public void cAddMouseListener(MouseListener mouseListener) {
		if (table != null)
			table.addMouseListener(mouseListener);
	}

	// public void cAddActionListener(ActionListener actionListener){
	// if(table!=null) table.addActionListener(actionListener);
	// }

	@Override
	public void show() {
	}

}
