package com.polaris.teamd.ui.custom;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class CEditableTable extends JTable {

	public CEditableTable() {
		super();
	}

	public CEditableTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public CEditableTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	public CEditableTable(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);
	}

	public CEditableTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public CEditableTable(TableModel dm) {
		super(dm);
	}

	public CEditableTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}

}
