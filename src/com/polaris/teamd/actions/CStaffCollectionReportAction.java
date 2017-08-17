package com.polaris.teamd.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.custom.Panel;
import com.polaris.teamd.ui.staff.CStaffCollectionReport;

public class CStaffCollectionReportAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel = new CStaffCollectionReport();
		target.removeAll();
		//target.add(mypanel);
		target.add(new Panel());
		target.invalidate();
		target.validate();
		target.setVisible(true);
		System.out.println("Staff Collection Report Action");
	}

}
