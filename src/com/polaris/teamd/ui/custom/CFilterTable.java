package com.polaris.teamd.ui.custom;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;

public class CFilterTable extends CSingleSelectInputTable {
	
	
	public CFilterTable() {
		super();
	}

	public CFilterTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public CFilterTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	public CFilterTable(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);
	}

	public CFilterTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public CFilterTable(TableModel dm) {
		super(dm);
	}

	public CFilterTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}
	

}
