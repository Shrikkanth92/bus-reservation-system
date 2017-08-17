package com.polaris.teamd.ui.custom;

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
 * @author Shrikanth
 * 
 */
public class CInfo extends JLabel {
	private int status;

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * This is a parameterized constructor with one parameter
	 * 
	 * @param status
	 */
	public CInfo(int status) {
		super();
		cMakeIcon(status);

	}

	/**
	 * This is a default constructor
	 */
	public CInfo() {
		super();
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param image
	 * @param horizontalAlignment
	 * @param status
	 */
	public CInfo(Icon image, int horizontalAlignment, int status) {
		super(image, horizontalAlignment);
		cMakeIcon(status);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param image
	 * @param status
	 */
	public CInfo(Icon image, int status) {
		super(image);
		cMakeIcon(status);
	}

	/**
	 * This is a parameterized constructor with four parameters
	 * 
	 * @param text
	 * @param icon
	 * @param horizontalAlignment
	 * @param status
	 */
	public CInfo(String text, Icon icon, int horizontalAlignment, int status) {
		super(text, icon, horizontalAlignment);
		cMakeIcon(status);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param text
	 * @param horizontalAlignment
	 * @param status
	 */
	public CInfo(String text, int horizontalAlignment, int status) {
		super(text, horizontalAlignment);
		cMakeIcon(status);
	}

	/**
	 * This is a parameterized constructor with two parameters
	 * 
	 * @param text
	 * @param status
	 */
	public CInfo(String text, int status) {
		super(text);
		cMakeIcon(status);
	}

	/**
	 * This function sets the status for setting an icon
	 * 
	 * @param status
	 *            - The status parameter will be used to know the status of the
	 *            icon
	 */
	private void cMakeIcon(int status) {
		setStatus(status);
		ImageIcon icon = cCreateIcon(cGetPropertyValue());
		this.setIcon(icon);
	}

	/**
	 * This function selects the property value of the image in the property
	 * file
	 * 
	 * @return- This function returns the property value of the image in the
	 *          property file
	 */
	public String cGetPropertyValue() {
		PropertyFileProcessing processor = new PropertyFileProcessing();
		processor.setPropertyFile(new File("resources/ui/ui.properties"));
		String property = cSelectProperty();
		String propertyValue = processor.getStringProperty(property);
		return propertyValue;
	}

	/**
	 * This function selects the property from the property file
	 * 
	 * @return- This function returns the property in the property file
	 */
	public String cSelectProperty() {
		String property = null;
		if (status == 0)
			property = "ui.info.image.failure";
		else if (status == 1)
			property = "ui.info.image.success";

		return property;

	}

	/**
	 * This function creates an image icon using the image read from the
	 * property file
	 * 
	 * @param propertyValue
	 *            - This property value is used to read the image from the
	 *            property file
	 * @return-This function returns an image icon
	 */
	public ImageIcon cCreateIcon(String propertyValue) {
		Image image;
		ImageIcon icon = null;
		try {

			image = ImageIO.read(new File(propertyValue));
			Image image2 = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			icon = new ImageIcon(image2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return icon;

	}

}
