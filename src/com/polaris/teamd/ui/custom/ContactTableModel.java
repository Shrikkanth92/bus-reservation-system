package com.polaris.teamd.ui.custom;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ContactTableModel extends AbstractTableModel {

	ArrayList<Contacts> contactList = new ArrayList<Contacts>();
	{
		contactList.add(new Contacts("Jas", "9600012467"));
		contactList.add(new Contacts("ani", "9043118777"));
		contactList.add(new Contacts("shri", "9894406296"));
		contactList.add(new Contacts("ak", "9940527843"));
		contactList.add(new Contacts("poornima", "9840012345"));
		contactList.add(new Contacts("vishwa", "9600024717"));
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return contactList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return contactList.get(rowIndex).getName();
		if (columnIndex == 1)
			return contactList.get(rowIndex).getPhone();
		return null;
	}
	public void remove(Contacts contacts)
	{
		contactList.remove(contacts);
	}
	@Override
	public void fireTableDataChanged() {
		
		super.fireTableDataChanged();
	
	}
}
