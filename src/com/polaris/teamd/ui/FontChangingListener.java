package com.polaris.teamd.ui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import com.polaris.teamd.common.utils.UIUtil;

/**
 * 
 * @author shrikkanth.ramesh
 * 
 *         This class is a listener class used to change the font.
 */
public class FontChangingListener implements MouseListener {
	private Font font;

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
		font = component.getFont();
		component.setFont(UIUtil.getFont("Arial", "Bold", 16));

	}

	/**
	 * This method is used to perform an action on mouse exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		JComponent component = (JComponent) e.getSource();
		component.setFont(font);

	}

}
