package com.polaris.teamd.ui.custom;

import java.awt.GridLayout;

import java.awt.LayoutManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.polaris.teamd.common.utils.ReflectionUtil;

/**
 * 
 * @author Manochitra
 * @version Java 1.6
 */

public class CRadioGroup<E> extends JPanel {

	private LinkedList<E> objectList = new LinkedList<E>();
	private CRadio[] radioButtons;
	private String caption;
	private Object selectedObject;

	/**
	 * <b>This is no argument constructor for CRadioGroup class</b>
	 */
	public CRadioGroup() {
		super();
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param DoubleBuffered
	 *            -initializes the boolean member variable
	 */
	public CRadioGroup(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param layout
	 *            and DoubleBuffered -initializes the layout and boolean member
	 *            variable
	 */

	public CRadioGroup(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * <b>This constructor is parameterized constructor</b>
	 * 
	 * @param layout
	 *            -initializes the LayoutManager member variable
	 */
	public CRadioGroup(LayoutManager layout) {
		super(layout);
	}

	/**
	 * <b>This function adds object to objectList</b>
	 * 
	 * @param object
	 *            -initializes the object member variable
	 */
	public void cAddObject(E e) {
		objectList.add(e);
	}

	public void cAddObjects(E... objects) {
		for (int i = 0; i < objects.length; i++)
			objectList.add(objects[i]);
	}
	public void cAddObjects(List objectList) {
		for (Object object : objectList) {
			objectList.add(object);
		}
	}
	
	public void removeObject(Object object) {
		objectList.remove(object);
	}


	/**
	 * <b>This function is to set caption</b>
	 * 
	 * @param caption
	 *            -initializes the String member variable
	 */
	public void cSetCaptionProperty(String caption) {
		this.caption = caption;
	}

	public void cSetSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}

	/**
	 * <b>This function is to render the functions of the bean class</b>
	 * 
	 */
	public void cRender() {
		radioButtons = new CRadio[objectList.size()];
		ButtonGroup buttonGroup = new ButtonGroup();
		ButtonModel buttonModel = new DefaultButtonModel();
		int index = 0;
		for (Object element : objectList) {
			Class c = element.getClass();
			try {
				StringBuffer methodName = cGetFlip(caption);
				Method captionMethod = c.getMethod(methodName.toString());
				Object invokedResult = captionMethod.invoke(element);
				radioButtons[index] = new CRadio(invokedResult.toString());
				if (invokedResult.toString().equals(selectedObject.toString())) {
					radioButtons[index].setSelected(true);
				}
				buttonGroup.add(radioButtons[index]);

				this.add(radioButtons[index++]);

			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		this.setLayout(new GridLayout(objectList.size(), 1));

	}

	/**
	 * <b>This function is to flip the first character of the caption</b>
	 * 
	 * @param caption
	 *            -initializes the string member variable
	 * @return <b>the methodName</b>
	 */
	public StringBuffer cGetFlip(String caption) {
		StringBuffer methodName = new StringBuffer();
		methodName.append("get")
				.append(Character.toUpperCase(caption.charAt(0)))
				.append(caption.substring(1));
		return methodName;
	}

	/**
	 * <b>This function is to get the selected object</b>
	 * 
	 * @return <b>the index of the object</b>
	 */

	public Object cGetSelectedObject() {
		int index = 0;
		for (CRadio radioButton : radioButtons) {

			if (radioButton.isSelected()) {

				return objectList.get(index);
			}
			index++;

		}
		return null;
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
//		StringBuffer methodName = new StringBuffer();
		
		String methodName1 = ReflectionUtil.formMethodName(element, "get");
		Object objectProperty = ReflectionUtil.invokeGetterMethod(
				selectedObject, methodName1);
		return objectProperty;

		
//		for (CRadio radioButton : radioButtons) {
//
//			if (radioButton.isSelected()) {
//
//				try {
//
//					return objectList.get(index).getClass()
//							.getMethod(cGetFlip(element).toString())
//							.invoke(objectList.get(index));
//				} catch (SecurityException e) {
//					e.printStackTrace();
//				} catch (NoSuchMethodException e) {
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//				}
//			}
//			index++;
//
//		}
//		return null;
	}
}
