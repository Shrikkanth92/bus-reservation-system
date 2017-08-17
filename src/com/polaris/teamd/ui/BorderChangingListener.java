package com.polaris.teamd.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.border.Border;

import com.polaris.teamd.common.utils.UIUtil;

/**
 * 
 * @author shrikkanth.ramesh
 * 
 *         This class is a listener class used to change the border.
 */
public class BorderChangingListener implements MouseListener {
	private Border border;

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
		border = component.getBorder();
		component.setBorder(UIUtil.createSimpleBorder());

	}

	/**
	 * This method is used to perform an action on mouse exited.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		JComponent component = (JComponent) e.getSource();
		component.setBorder(border);
	}

}
