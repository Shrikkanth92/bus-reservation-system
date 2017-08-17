package com.polaris.teamd.ui.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * 
 * @author Shrikanth
 * 
 *  This custom class is for creating jtable
 */
public class CTable extends JTable {

	/**
	 * This is a default constructor
	 */
	public CTable() {
		super();
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param numRows
	 * @param numColumns
	 */
	public CTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param rowData
	 * @param columnNames
	 */
	public CTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param dm
	 * @param cm
	 * @param sm
	 */
	public CTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param dm
	 * @param cm
	 */
	public CTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public CTable(TableModel dm) {
		super(dm);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param rowData
	 * @param columnNames
	 */
	public CTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}

	/**
	 * This function sets the preferred width for the given column index
	 * 
	 * @param columnIndex
	 * @param width
	 */
	public void cSetColumnWidth(int columnIndex, int width) {

		TableColumnModel columnModel = super.getColumnModel();
		columnModel.getColumn(columnIndex).setPreferredWidth(width);
	}

	/**
	 * This function sets the background color for the table header
	 * 
	 * @param color
	 */
	public void cSetTableHeadColor(Color color) {
		JTableHeader header = super.getTableHeader();
		header.setBackground(color);
	}

	/**
	 * This function sets the height of the table header
	 * 
	 * @param height
	 */
	public void cSetTableHeadHeight(int height) {
		JTableHeader header = super.getTableHeader();
		header.setPreferredSize(new Dimension(this.getWidth(), height));
	}

	/**
	 * This function sets the color for odd rows
	 * 
	 * @param color
	 */
	public void cSetOddRowColor(Color color) {
	}

	/**
	 * This function sets the color for even rows
	 * 
	 * @param color
	 */
	public void cSetEvenRowColor(Color color) {
	}

}
