package com.polaris.teamd.ui.custom;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 * 
 * @author Gowtham and Javeed
 * 
 * This custom class is for creating jcheckbox
 */

public class CCheck extends JCheckBox {

	/**
	 * This is a default constructor
	 */
	public CCheck() {
		super();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param a
	 *            - The parameter is of Action type
	 */
	public CCheck(Action a) {
		super(a);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param icon
	 *            - The parameter is of Icon type
	 * @param selected
	 *            - The parameter is of boolean type
	 */
	public CCheck(Icon icon, boolean selected) {
		super(icon, selected);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param icon
	 *            - The parameter is of Icon type
	 */
	public CCheck(Icon icon) {
		super(icon);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param selected
	 *            
	 */
	public CCheck(String text, boolean selected) {
		super(text, selected);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 *           
	 * @param icon
	 *           
	 * @param selected
	 *           
	 */
	public CCheck(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 *           
	 * @param icon
	 *           
	 */
	public CCheck(String text, Icon icon) {
		super(text, icon);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 *            
	 */
	public CCheck(String text) {
		super(text);

	}

	/**
	 * 
	 * @return - This function returns the boolean vale
	 */
	public boolean cGetValue() {
		return this.isSelected();
	}
}
