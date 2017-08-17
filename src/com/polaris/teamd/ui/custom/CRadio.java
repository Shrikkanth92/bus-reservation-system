package com.polaris.teamd.ui.custom;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

/**
 * 
 * @author ManoChitra and Nireesha
 * 
 *  This custom class is for creating jradiobutton
 */

public class CRadio extends JRadioButton {
	/**
	 * This is a default constructor
	 */
	public CRadio() {
		super();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param a
	 */
	public CRadio(Action a) {
		super(a);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param icon
	 * @param selected
	 */
	public CRadio(Icon icon, boolean selected) {
		super(icon, selected);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param icon
	 */
	public CRadio(Icon icon) {
		super(icon);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param selected
	 */
	public CRadio(String text, boolean selected) {
		super(text, selected);

	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 * @param icon
	 * @param selected
	 */
	public CRadio(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param icon
	 */
	public CRadio(String text, Icon icon) {
		super(text, icon);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CRadio(String text) {
		super(text);

	}

}
