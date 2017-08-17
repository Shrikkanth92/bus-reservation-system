package com.polaris.teamd.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

/**
 * 
 * @author shrikkanth.ramesh
 * 
 *         This class is a listener class used to change the color.
 */
public class ColorChangingListener implements MouseListener {
	private Color color;

	/**
	 * This method is used to perform an action on mouse clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * This method is used to perform an action on mouse pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * This method is used to perform an action on mouse released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * This method is used to perform an action on mouse entered.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		JComponent component = (JComponent) e.getSource();
		color = component.getBackground();
		component.setBackground(new Color(235, 198, 89));

	}

	/**
	 * This method is used to perform an action on mouse exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		JComponent component = (JComponent) e.getSource();
		component.setBackground(color);
	}

}
