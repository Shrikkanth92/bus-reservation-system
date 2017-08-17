package com.polaris.teamd.ui.custom;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.polaris.teamd.common.PropertyFileProcessing;

/**
 * 
 * @author shrikkanth.ramesh
 *
 */
public class CError extends JLabel {

	/**
	 * This is a default constructor
	 */
	public CError() {
		super();
		cMakeIcon();
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param image
	 * @param horizontalAlignment
	 */
	public CError(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		cMakeIcon();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param image
	 */
	public CError(Icon image) {
		super(image);
		cMakeIcon();
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 * @param icon
	 * @param horizontalAlignment
	 */
	public CError(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		cMakeIcon();
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param horizontalAlignment
	 */
	public CError(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		cMakeIcon();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param text
	 */
	public CError(String text) {
		super(text);
		cMakeIcon();
	}

	/**
	 * This function creates and sets an image icon and calls the setforeground
	 * color function
	 */
	private void cMakeIcon() {
		ImageIcon icon = cCreateIcon(cGetPropertyValue());
		this.setIcon(icon);
		cSetForegroundColor();
	}

	/**
	 * This function creates an image icon
	 * 
	 * @param propertyValue
	 *            - The image file is read using the propertyValue parameter
	 * 
	 * @return- This function returns the icon of the image file
	 */
	public ImageIcon cCreateIcon(String propertyValue) {
		Image image;
		ImageIcon icon = null;
		try {

			image = ImageIO.read(new File(propertyValue));
			Image image2 = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			icon = new ImageIcon(image2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * This function gets the property value of the image from the property file
	 * 
	 * @return- This function returns the property value of the required image
	 */
	public String cGetPropertyValue() {
		PropertyFileProcessing processor = new PropertyFileProcessing(new File(
				"resources/ui/ui.properties"));
		String propertyValue = processor.getStringProperty("ui.error.image");
		return propertyValue;
	}

	/**
	 * This function sets the font color for the message
	 */
	public void cSetForegroundColor() {
		this.setForeground(Color.RED);
	}
}
