package com.polaris.teamd.ui.custom;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

/**
 * 
 * @author
 * 
 *  This custom class is for creating jlist
 */

public class CList extends JList {

	/**
	 * This is a default constructor
	 */
	public CList() {
		super();

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param dataModel
	 */
	public CList(ListModel dataModel) {
		super(dataModel);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param listData
	 */
	public CList(Object[] listData) {
		super(listData);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param listData
	 */
	public CList(Vector<?> listData) {
		super(listData);

	}

}
