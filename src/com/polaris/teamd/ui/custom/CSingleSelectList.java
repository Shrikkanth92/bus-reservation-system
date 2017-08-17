package com.polaris.teamd.ui.custom;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import com.polaris.teamd.app.CExceptionHandler;
import com.polaris.teamd.common.exception.CException;
import com.polaris.teamd.common.exception.CExceptionTypes;
import com.polaris.teamd.common.exception.CPropertyNotFoundException;
import com.polaris.teamd.common.exception.CResourceNotFoundException;
import com.polaris.teamd.common.utils.ReflectionUtil;
import com.polaris.teamd.ui.custom.CMultiSelectList.InnerListModel;
import com.polaris.teamd.ui.custom.CSingleSelectInputTable.InnerTableModel;

/**
 * 
 * @author 
 * @version Java 1.6
 */
public class CSingleSelectList<E> extends CList {
	private LinkedList objectList = new LinkedList();
	InnerListModel listModel=new InnerListModel();
	private String labelProperty;
	private int selectedRow;
	public String getLabelProperty() {
		return labelProperty;
	}

	public void setLabelProperty(String labelProperty) {
		this.labelProperty = labelProperty;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public boolean isHideOnSelection() {
		return hideOnSelection;
	}

	public void setHideOnSelection(boolean hideOnSelection) {
		this.hideOnSelection = hideOnSelection;
	}

	private boolean hideOnSelection;
	public CSingleSelectList(ListModel dataModel) {
		super(dataModel);
	}

	public CSingleSelectList() {
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
				selectedRow = getSelectedIndex();
				if(hideOnSelection)
					getParent().setVisible(false);
				getParent().getParent().invalidate();
				getParent().getParent().validate();
			}
		});
	}

	public void addObjects(Object... objects) {
		{
					
			
			for(Object object:objects)
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
					
			
			for(int i=0;i<objectList.size();i++){
				objectList.add(objectList.get(i));
			}
				
			
		}
	}

	public CSingleSelectList(Vector<?> listData) {
		super(listData);
	}

	public Object getSelectedObject() {
		return objectList.get(selectedRow);
	}

	
	public void cSetFieldToDisplay(String field) {
		this.labelProperty = field;
	}

	public String cGetFieldToDisplay() {
		return labelProperty;
	}

	public Object cGetSelectedObjectProperty(int index, String caption) {
		Object selectedObject=objectList.get(selectedRow);
		 String methodName = ReflectionUtil.formMethodName(caption, "get");
		Object res = ReflectionUtil.invokeGetterMethod(selectedObject,
				methodName);
		return res;
	}

	class InnerListModel implements ListModel {

		
		public InnerListModel() {

		}

		@Override
		public int getSize() {
			return objectList.size();
		}

		@Override
		public Object getElementAt(int index) {
			Object element = objectList.get(index);
			String methodName = ReflectionUtil.formMethodName(
					cGetFieldToDisplay(), "get");
			return ReflectionUtil.invokeGetterMethod(element, methodName);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
		}
	
		
	}
}
