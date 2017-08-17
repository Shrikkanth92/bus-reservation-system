package com.polaris.teamd.ui.custom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author
 * 
 * This custom class is for creating jbuttons
 */

public class CButton extends JButton {
	/**
	 * This is a default constructor
	 */
	public CButton() {
		super();

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param a
	 */
	public CButton(Action a) {
		super(a);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param icon
	 */
	public CButton(Icon icon) {
		super(icon);

	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param icon
	 */
	public CButton(String text, Icon icon) {
		super(text, icon);

	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CButton(String text) {
		super(text);

	}
	
	public void cSetIcon(String fileName) {
		Image image;
		ImageIcon icon = null;
		try {
			image = ImageIO.read(new File(fileName)).getScaledInstance(16, 16,
					Image.SCALE_SMOOTH);
			icon = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setIcon(icon);

	}

}
