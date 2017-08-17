package com.polaris.teamd.ui.custom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author
 * 
 *  This custom class is for creating jlabel
 */
public class CLabel extends JLabel {
	/**
	 * This is a default constructor
	 */
	public CLabel() {
		super();
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param image
	 * @param horizontalAlignment
	 */
	public CLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param image
	 */
	public CLabel(Icon image) {
		super(image);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 * @param icon
	 * @param horizontalAlignment
	 */
	public CLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param horizontalAlignment
	 */
	public CLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CLabel(String text) {
		super(text);
	}
	
	public void cSetIcon(String fileName) {
		Image image;
		ImageIcon icon = null;
		try {
			image = ImageIO.read(new File(fileName)).getScaledInstance(300,300,
					Image.SCALE_SMOOTH);
			icon = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setIcon(icon);

	}
}
