package com.polaris.teamd.ui.custom;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.polaris.teamd.common.utils.ReflectionUtil;

public class CMultiCheck extends JPanel {

	private LinkedList<Object> objectList = new LinkedList<Object>();
	private CCheck[] checkBoxes;
	private String caption;
	private LinkedList selectedObjectList;

	/**
	 * <b>This is no argument constructor for CMultiCheck class</b>
	 */
	public CMultiCheck() {
		super();
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param DoubleBuffered
	 *            -initializes the boolean member variable
	 */

	public CMultiCheck(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param layout
	 *            and DoubleBuffered -initializes the layout and boolean member
	 *            variable
	 */
	public CMultiCheck(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param layout
	 *            -initializes the LayoutManager member variable
	 */

	public CMultiCheck(LayoutManager layout) {
		super(layout);
	}

	/**
	 * <b>This function adds object to arrayList</b>
	 * 
	 * @param object
	 *            -initializes the object member variable
	 */

	public void cAddObject(Object object) {
		objectList.add(object);
	}

	public void cAddObjects(Object... objects) {
		for (int i = 0; i < objects.length; i++)
			objectList.add(objects[i]);
	}

	/**
	 * <b>This function is to set caption</b>
	 * 
	 * @param caption
	 *            -initializes the String member variable
	 */
	public void cSetCaption(String caption) {
		this.caption = caption;
	}

	public void cSetSelectedObjects(Object... selectedObjects) {
		selectedObjectList = new LinkedList();
		for (int i = 0; i < selectedObjects.length; i++)
			selectedObjectList.add(selectedObjects[i]);
	}

	public int cGetNumberOfChecks(){
		return checkBoxes.length;
	}
	/**
	 * <b>This function is to render the functions of the bean class</b>
	 * 
	 */
	public void cRender() {
		checkBoxes = new CCheck[objectList.size()];
		int index = 0;
		for (Object element : objectList) {
			Class c = element.getClass();
			Object invokedResult = ReflectionUtil.invokeGetterMethod(element,
					ReflectionUtil.formMethodName(element.toString(),"get"));
			checkBoxes[index] = new CCheck(invokedResult.toString());
			if (selectedObjectList.contains(invokedResult))
				checkBoxes[index].setSelected(true);
			this.add(checkBoxes[index++]);
		}
		this.setLayout(new GridLayout(objectList.size(), 1));
	}

	/**
	 * <b>This function is to get the selected object</b>
	 * 
	 * @return <b>the index of the object</b>
	 */

	public Object cGetSelectedObject() {
		int index = 0;
		Collection<Object> collection = new LinkedList<Object>();
		for (CCheck checkBox : checkBoxes) {
			if (checkBox.isSelected()) 		collection.add(objectList.get(index));
			index++;
		}
		return collection;
	}

	/**
	 * <b>This function is to get the particular element of the object</b>
	 * 
	 * @param element
	 *            -initializes the string member variable
	 * @return <b>the index of the element</b>
	 */

	public Object cGetSelectedObjectProperty(String element) {
		int index = 0;
		Collection<Object> collection = new LinkedList<Object>();
		for (CCheck checkBox : checkBoxes) {
			if (checkBox.isSelected())
					collection.add(ReflectionUtil.invokeGetterMethod(objectList.get(index),
							ReflectionUtil.formMethodName(element, "get")));
			index++;
		}	
		return collection;
	}

	public void addActionListener(ActionListener actionListener) {
		for(CCheck ccheck:checkBoxes)
			ccheck.addActionListener(actionListener);
	}
}
