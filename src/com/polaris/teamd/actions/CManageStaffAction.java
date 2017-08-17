package com.polaris.teamd.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.ui.admin.CAddStaff;
import com.polaris.teamd.ui.admin.CManageStaff;
import com.polaris.teamd.ui.custom.Panel;

public class CManageStaffAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel target = ApplicationCache.get("CONTENTSCREEN");
		JPanel mypanel =  new CManageStaff();
		target.removeAll();
		//target.add(mypanel);
		target.add(new Panel());
		target.invalidate();
		target.validate();
		target.setVisible(true);
		System.out.println("Add Staff Action");
	}

}
