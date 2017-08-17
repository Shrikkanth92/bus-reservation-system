/**
 * 
 */
package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.Dimension;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class CEmptyPanel extends JPanel {
	private int width, height;

	/**
	 * 
	 */
	public CEmptyPanel() {
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void cRender() {
		Dimension dimension = new Dimension(width, height);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setMinimumSize(dimension);
		this.setSize(dimension);
	}
}
