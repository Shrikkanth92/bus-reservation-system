package com.polaris.teamd.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.staff.CCancellationRefund;

public class CCancellationRefundAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CCancellationRefund();
		target.removeAll();
		target.add(mypanel);
		System.out.println("Cancellation Refund Action");
	}

}
