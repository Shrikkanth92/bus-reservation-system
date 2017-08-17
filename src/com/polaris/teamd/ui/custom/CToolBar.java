package com.polaris.teamd.ui.custom;

import javax.swing.JToolBar;

/**
 * 
 * @author
 * 
 *  This custom class is for creating jtoolbar
 */
public class CToolBar extends JToolBar {

	/**
	 * This is a default constructor
	 */
	public CToolBar() {
		super();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param orientation
	 */
	public CToolBar(int orientation) {
		super(orientation);

	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param name
	 * @param orientation
	 */
	public CToolBar(String name, int orientation) {
		super(name, orientation);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param name
	 */
	public CToolBar(String name) {
		super(name);

	}

}
