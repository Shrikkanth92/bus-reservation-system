package com.polaris.teamd.ui.custom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ListSelectionModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
/**
 * 
 * @author manochitra.sridharan
 *
 * @param <E>
 */
public class CMultiselectInputTable<E> extends CTable {
	/**
	 * 
	 */
	
	ArrayList<E> arrayList = new ArrayList<E>();

	InnerTableModel tableModel;
/**
 * This is the parameterized constructor
 * @param colCount
 * @param colName
 * @param objcts
 */
	public CMultiselectInputTable(int[] colCount, String[] colName,
			E... objcts) {
		super();
		tableModel = (InnerTableModel) createTableModel(colCount, colName,
				objcts[0].getClass());
		for (int i = 0; i < objcts.length; i++)
			arrayList.add(objcts[i]);

	}
/**
 * This method creates the instance of the inner table 
 * @param colCount
 * @param colName
 * @param c
 * @return
 */
	public InnerTableModel createTableModel(int[] colCount, String[] colName,
			Class c) {
		tableModel = new InnerTableModel(colCount, colName, c);
		return tableModel;
	}
/**
 * This is the parameterized constructor
 * @param numRows
 * @param numColumns
 */
	public CMultiselectInputTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}
/**
 * This is the parameterized constructor
 * @param rowData
 * @param columnNames
 */
	public CMultiselectInputTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}
/**
 * This is the parameterized constructor
 * @param dm
 * @param cm
 * 
 * 
 * @param sm
 */
	public CMultiselectInputTable(TableModel dm, TableColumnModel cm,
			ListSelectionModel sm) {
		super(dm, cm, sm);
	}
/**
 * 
 * @param dm
 * @param cm
 */
	public CMultiselectInputTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}
/**
 * This is the parameterized constructor
 * @param dm
 */
	public CMultiselectInputTable(TableModel dm) {
		super(dm);
	}
/**
 * This is the parameterized constructor
 * @param rowData
 * @param columnNames
 */
	public CMultiselectInputTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
	}
/**
 * This method is to add objects to the arraylist
 * @param e
 */
	public void cAddObject(E e) {

		tableModel.cAddObject(e);
		System.out.println(e);
	}
/**
 * This method is to get the selected objects
 * @param row
 * @return
 */
	public Object cGetSelectedObject(int row) {

		return tableModel.cGetSelectedObject(row);

	}
	/**
	 * This method is to get the specified property of the selected object
	 * @param row
	 * @param caption
	 * @return
	 */
	public Object cGetSelectedObjectProperty(int row,String caption) {
		return tableModel.cInvokeMethod(caption, arrayList.get(row));
	}
	public Object cGetSelectedObjectsProperties(int[] rows,String caption) 
		{
			return tableModel.cGetSelectedObjectsProperties(rows, caption);
		}
	/**
	 * This inner class is to create the model object
	 * @author manochitra.sridharan
	 *
	 */

	class InnerTableModel extends AbstractTableModel {
		Field[] fields;
		Class c;

		int[] columnIndex;
		String[] columnName;
/**
 * This is the parameterized constructor for the inner class
 * @param x
 * @param name
 * @param c
 */
		public InnerTableModel(int[] x, String[] name, Class c) {
			columnIndex = x;
			columnName = name;
			this.c = c;
		}

/**
 * This method is to add objects to the array
 * @param e
 */
		public void cAddObject(E e) {
			arrayList.add(e);

			fields = c.getDeclaredFields();
			columnIndex = new int[fields.length];
			columnName = new String[fields.length];

		}
/**
 * This method is to get the selected field to be displayed from the user
 */
		public void setColumn() {

		}
/**
 * This method is to get the value to be displayed in the table
 */
		@Override
		public Object getValueAt(int rowIndex, int colIndex) {
			E e = arrayList.get(rowIndex);
			// Object temp=null;
			return cInvokeMethod(columnName[colIndex], e);

		}
		
/**
 * This method is to set the modified data to the table
 */
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			

		}
/**
 * This method is to decide whether the table is editable or not
 */
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
/**
 * This method is to get the number of rows to be printed in the table
 */
		@Override
		public int getRowCount() {
			return arrayList.size();
		}
/**
 * This method is to get the column name to be displayed in the table
 */
		@Override
		public String getColumnName(int colIndex) {
			return columnName[colIndex];
		}
/**
 * This method is to get the count of columns to be displayed
 */
		@Override
		public int getColumnCount() {
			return columnIndex.length;
		}
/**
 * This method is to get the class of the corresponding columns
 */
		@Override
		public Class<?> getColumnClass(int colIndex) {
			String filedTodisplay = columnName[colIndex];
			Object obj = cInvokeMethod(filedTodisplay, arrayList.get(0));
			return obj.getClass();
		}

		@Override
		public void addTableModelListener(TableModelListener l) {

		}
/**
 * This method is to get the correspnding method name from the field name
 * @param caption
 * @return
 */
		public String cGetMethodName(String caption) {

			StringBuffer sb = new StringBuffer(caption);
			char a = caption.charAt(0);

			if ((int) a >= 97 && (int) a <= 122) {
				int b = a - 32;
				char c1 = (char) b;
				sb = new StringBuffer(caption);
				sb.deleteCharAt(0);
				sb.insert(0, c1);
			}
			String methodName = "get" + sb.toString();

			return methodName;
		}
/**
 * This method is to invoke the corresponding method
 * @param caption
 * @param element
 * @return
 */
		public Object cInvokeMethod(String caption, Object element) {
			Method method;
			Object result = null;
			String methodToInvoke;
			try {
				methodToInvoke = cGetMethodName(caption);

				method = c.getMethod(methodToInvoke);
				result = method.invoke(element);

			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			}

			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return result;
		}
/**
 * This method is to get the selected object from the table
 * @param row
 * @return
 */
		public Object cGetSelectedObject(int row) {

			E e = arrayList.get(row);
			return e;

		}
/**
 * This method is to get the value of the given property 
 * @param rows
 * @param caption
 * @return
 */
		public Object cGetSelectedObjectsProperties(int[] rows,String caption) {
			Collection collections=new ArrayList();	
			for(int i=0;i<rows.length;i++)
			{
				collections.add(cInvokeMethod(caption, arrayList.get(rows[i])));
			}
			
			return collections;
		

		}
	};

}
