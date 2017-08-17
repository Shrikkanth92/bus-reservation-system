package com.polaris.teamd.ui.custom;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.ls.LSInput;

import com.polaris.teamd.common.utils.UIUtil;

/**
 * 
 * @author shrikanth.ramesh
 * 
 */
public class CErrors extends JPanel {
	private ArrayList<String> list = new ArrayList<String>();

	/**
	 * This is a default constructor
	 */
	public CErrors() {
		super();
	}

	/**
	 * This is a parameterized constructor with one parameter
	 */
	public CErrors(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * This is a parameterized constructor with three parameters
	 * 
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public CErrors(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * This is a parameterized constructor with one parameter
	 */
	public CErrors(LayoutManager layout) {
		super(layout);
	}

	/**
	 * This function adds the message to the list and prints it
	 * 
	 * @param message
	 *            - The message parameter takes the message as a string
	 */
	public void cAddMessage(String message) {
		list.add(message);
		System.out.println(list);
	}

	/**
	 * This function adds the message to the list and prints it
	 * 
	 * @param arrayList
	 *            - The message parameter takes the message in the form of
	 *            arraylist
	 */
	public void cAddMessage(ArrayList<String> arrayList) {
		list.addAll(arrayList);
		System.out.println(list);
	}

	/**
	 * This function adds the message to the list and prints it
	 * 
	 * @param message
	 *            - The message parameter takes the message in the form of
	 *            ellipsis type of string
	 */
	public void cAddMessage(String... message) {
		for (int i = 0; i < message.length; i++)
			list.add(message[i]);
		System.out.println(list);
	}

	/**
	 * This function sets the icon to the label and sets the preferred size and
	 * border for the label
	 */
	public void cRender() {

		ImageIcon icon = cCreateIcon();
		CLabel[] labels = new CLabel[list.size()];
		this.setLayout(new GridLayout(list.size(), 1));
		for (int i = 0; i < list.size(); i++) {
			labels[i] = new CLabel(list.get(i));
			labels[i].setIcon(icon);
			this.add(labels[i]);
		}
		this.setPreferredSize(new Dimension(this.getWidth(), (list.size() * 25)));
		this.setBorder(UIUtil.createSimpleBorder());
	}

	/**
	 * This function creates an image icon using the image read from the
	 * property file
	 * 
	 * @return- This function returns the created image icon
	 */
	public ImageIcon cCreateIcon() {
		Image image;
		ImageIcon icon = null;
		try {

			image = ImageIO.read(new File("bullet.jpg"));
			Image image2 = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			icon = new ImageIcon(image2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return icon;

	}

}
