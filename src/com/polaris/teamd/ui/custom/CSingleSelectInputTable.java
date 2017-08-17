package com.polaris.teamd.ui.custom;

import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.polaris.teamd.common.utils.ReflectionUtil;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;
/*
 * CSingleSelectInputTable is an extended version of CTable where a selection of a record gives an object corresponding to it 
 */
public class CSingleSelectInputTable extends CTable {
	private LinkedList<Object> objectList = new LinkedList<Object>();
	private InnerTableModel tableModel;
	private int selectedObjectIndex;
	private String[] colHeadings;
	private String[] colDisplayLabelProerties;
	private Object selectedObject;
	private boolean hideOnSelection;
	private CTextInputPanel target;
	private String selectPropertyName;
	
	public CSingleSelectInputTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public CSingleSelectInputTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	public CSingleSelectInputTable(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);
	}

	public CSingleSelectInputTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public CSingleSelectInputTable(TableModel dm) {
		super(dm);
	}

	public CSingleSelectInputTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}
	
	public CSingleSelectInputTable() {
		super();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectedObjectIndex(getSelectedRow());
				selectedObject = objectList.get(selectedObjectIndex);
				if(hideOnSelection)	getParent().setVisible(false);
				target.getInput().setText((String) cGetSelectedObjectProperty(selectPropertyName));
				getParent().getParent().invalidate();
				getParent().getParent().validate();
			}
		});
	}
	
	public Object getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}

	public int getSelectedObjectIndex() {
		return selectedObjectIndex;
	}

	public void setSelectedObjectIndex(int selectedRow) {
		this.selectedObjectIndex = selectedRow;
	}

	public String[] getColHeadings() {
		return colHeadings;
	}

	public void setColHeadings(String[] colHeadings) {
		this.colHeadings = colHeadings;
		System.out.println(colHeadings[0]);
	}

	public String[] getColDisplayLabelProerties() {
		return colDisplayLabelProerties;
	}

	public void setColDisplayLabelProerties(String[] colDisplayLabelProerties) {
		this.colDisplayLabelProerties = colDisplayLabelProerties;
	}

	public void setColHeadings(int index, String colHeading) {
		this.colHeadings[index] = colHeading;
	}

	public String getColHeadings(int index) {
		return colHeadings[index];
	}

	public void setColDisplayLabelProperties(int index, String colHeading) {
		this.colDisplayLabelProerties[index] = colHeading;
	}

	public String getColDisplayLabelProperties(int index) {
		return colDisplayLabelProerties[index];
	}

	public boolean isHideOnSelection() {
		return hideOnSelection;
	}

	public void setHideOnSelection(boolean hideOnSelection) {
		this.hideOnSelection = hideOnSelection;
	}

	public CTextInputPanel getTarget() {
		return target;
	}

	public void setTarget(CTextInputPanel target) {
		this.target = target;
	}

	public String getSelectPropertyName() {
		return selectPropertyName;
	}

	public void setSelectPropertyName(String selectPropertyName) {
		this.selectPropertyName = selectPropertyName;
	}

	public void cAddObject(Object object) {
		objectList.add(object);
	}

	public void cAddObjects(Object... objects) {
		for (Object object : objects) 
			objectList.add(object);
	}

	public void cAddObjects(List objects) {
		for (int i = 0; i < objects.getItemCount(); i++) 
			objectList.add(objects.getItem(i));
	}

	public Object cGetSelectedObject() {
		return selectedObject;
	}

	public Object cGetSelectedObjectProperty(String property) {
		String methodName = ReflectionUtil.formMethodName(property, "get");
		return ReflectionUtil.invokeGetterMethod(selectedObject,
				methodName);
	}

	public void csetCellEditor(int index, TableCellEditor tableCellEditor) {
		TableColumnModel columnModel = this.getColumnModel();
		TableColumn tableColumn = columnModel.getColumn(index);
		tableColumn.setCellEditor(tableCellEditor);
	}

	public void cSetTableCellRender(int index,
			TableCellRenderer tableCellRenderer) {
		TableColumnModel columnModel = this.getColumnModel();
		TableColumn tableColumn = columnModel.getColumn(index);
		tableColumn.setCellRenderer(tableCellRenderer);
	}

	public void setModel() {
		this.setModel(new InnerTableModel());
	}
	/**
	 * InnerTableModel is a table model for the singleSelectInputTable 
	 */

	class InnerTableModel extends AbstractTableModel {
		public InnerTableModel() {
		}

		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			Object object = objectList.get(rowIndex);
			String methodName = ReflectionUtil.formMethodName(
					getColHeadings(colIndex), "get");
			return ReflectionUtil.invokeGetterMethod(object, methodName);
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int colIndex) {
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public int getRowCount() {
			return objectList.size();
		}

		@Override
		public String getColumnName(int colIndex) {
			System.out.println("nnnnnnnnnn"+colHeadings[colIndex]);
			return colHeadings[colIndex];
		}

		@Override
		public int getColumnCount() {
			return colHeadings.length;
		}

		@Override
		public Class<?> getColumnClass(int colIndex) {
//			String methodName = ReflectionUtil.formMethodName(
//					colHeadings[colIndex], "get");
//			Method method = ReflectionUtil.findMethod(objectList.getClass(),
//					methodName);
			return Object.class;
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
		}
	};
}
