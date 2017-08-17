package com.polaris.teamd.ui.custom;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
/**
 * 
 * @author 
 *
 * This custom class is for creating jmenubutton
 */
public class CMenuButton extends JButton {

	/**
	 * This is a default constructor
	 */
	public CMenuButton() {
		super();

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param a
	 */
	public CMenuButton(Action a) {
		super(a);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param icon
	 */
	public CMenuButton(Icon icon) {
		super(icon);

	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param icon
	 */
	public CMenuButton(String text, Icon icon) {
		super(text, icon);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CMenuButton(String text) {
		super(text);

	}

}
