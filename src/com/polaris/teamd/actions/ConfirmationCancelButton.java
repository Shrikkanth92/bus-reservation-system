package com.polaris.teamd.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ConfirmationCancelButton extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cancel button is clicked");
	}

}
