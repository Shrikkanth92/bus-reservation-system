package com.polaris.teamd.ui.custom;

import javax.swing.JTextArea;
import javax.swing.text.Document;

/**
 * 
 * @author
 * 
 *  This custom class is for creating jtextarea
 */
public class CTextArea extends JTextArea {

	/**
	 * This is a default constructor
	 */
	public CTextArea() {
		super();
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param doc
	 * @param text
	 * @param rows
	 * @param columns
	 */
	public CTextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param doc
	 */
	public CTextArea(Document doc) {
		super(doc);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param rows
	 * @param columns
	 */
	public CTextArea(int rows, int columns) {
		super(rows, columns);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 * @param rows
	 * @param columns
	 */
	public CTextArea(String text, int rows, int columns) {
		super(text, rows, columns);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CTextArea(String text) {
		super(text);
	}

}
