
package com.polaris.teamd.ui.custom;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import com.polaris.teamd.common.utils.ReflectionUtil;

/**
 * @author mohamedjaveed.b
 */
public class CCombo extends JComboBox {
	private LinkedList objectList = new LinkedList();
	private String displayLabelProperty;
	private int visibleRowCount;
	private Object selectedObject;

	public CCombo() {
		super();

	}

	public CCombo(ComboBoxModel aModel) {
		super(aModel);
	}

	public CCombo(Object[] items) {
		super(items);
	}

	public CCombo(Vector items) {
		super(items);
	}

	public LinkedList getObjectList() {
		return objectList;
	}

	public void setObjectList(LinkedList objectList) {
		this.objectList = objectList;
	}

	public String getDisplayLabelProperty() {
		return displayLabelProperty;
	}

	public void setDisplayLabelProperty(String displayLabelProperty) {
		this.displayLabelProperty = displayLabelProperty;
	}

	public int getVisibleRowCount() {
		return visibleRowCount;
	}

	public void setVisibleRowCount(int visibleRowCount) {
		this.visibleRowCount = visibleRowCount;
	}

	public Object getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}

	public void addObject(Object object) {
		this.objectList.add(object);
	}

	public void addObjects(Object... objects) {
		for (Object object : objectList) {
			addObject(object);
		}
	}

	public void addObjects(List objectList) {
		for (Object object : objectList) {
			addObject(object);
		}
	}

	public void removeObject(Object object) {
		this.objectList.remove(object);
	}

	public void setModel() {
		super.setModel(new InnerCombo());
	}


	public Object getSelectedObjectProperty(String objectProperty) {
		String invokedMethod = ReflectionUtil.formMethodName(objectProperty,
				"get");
		return ReflectionUtil.invokeGetterMethod(getSelectedObject(),
				invokedMethod);
	}

	public void getSelectedObjectProperty() {

	}

	class InnerCombo implements ComboBoxModel {
		public InnerCombo() {
		}

		/**
		 * This method returns the size of the items to be displayed in the
		 * combo box
		 */
		@Override
		public int getSize() {
			return objectList.size();
		}

		/**
		 * This method returns the element to be displayed in the combo box
		 */
		@Override
		public Object getElementAt(int index) {
			Object element = objectList.get(index);
			String methodName = ReflectionUtil.formMethodName(
					getDisplayLabelProperty(), "get");
			Object result = ReflectionUtil.invokeGetterMethod(element,
					methodName);
			return result;
		}

		@Override
		public void addListDataListener(ListDataListener l) {

		}

		@Override
		public void removeListDataListener(ListDataListener l) {

		}

		/**
		 * This method is to set the item selected by the user
		 */
		@Override
		public void setSelectedItem(Object anItem) {
			selectedObject = anItem;

		}

		/**
		 * This method returns the value of the selected item
		 */
		@Override
		public Object getSelectedItem() {
			return selectedObject;
		}

	}

}
