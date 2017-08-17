package com.polaris.teamd.ui.custom;

import java.util.Calendar;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CDateGenerator extends AbstractTableModel implements TableModel{
	
	private int month, year, noOfDays;
	int [][] monthDates;
	TableModelListener tableModelListener;
	

	public int[][] getMonthDates() {
		monthDates=getDates();
		return monthDates;
	}



	public final int getMonth() {
		return month;
	}

	public final void setMonth(int month) {
		
		this.month = month;
	
		//System.out.println(month);
		monthDates=getDates();
		if(tableModelListener!=null)
			tableModelListener.tableChanged(new TableModelEvent(this));
		
	}

	public final int getYear() {
		return year;
	}

	public final void setYear(int year) {

		this.year = year;
		monthDates=getDates();
		if(tableModelListener!=null)
			tableModelListener.tableChanged(new TableModelEvent(this));

	}

	public CDateGenerator(int year, int month) {
		super();

		setYear(year);
		setMonth(month);
		monthDates=getDates();
		
	}

	public int[][] getDates() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(this.year, this.month, 1);
		
		noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int row = 0, col = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int[][] dates = new int[6][7];
		for (int i = 1; i <= noOfDays; i++) {
			dates[row][col++] = i;
			if (col == 7) {
				row++;
				col = 0;
			}
		}

		return dates;
	}



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 6;
	}



	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}



	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0)
			return "Sun";
		if(columnIndex==1)
			return "Mon";
		if(columnIndex==2)
			return "Tue";
		if(columnIndex==3)
			return "Wed";
		if(columnIndex==4)
			return "Thu";
		if(columnIndex==5)
			return "Fri";
		if(columnIndex==6)
			return "Sat";
		
		
		return null;
	}



	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}



	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		monthDates=getDates();
		if(monthDates[rowIndex][columnIndex]!=0)
			return monthDates[rowIndex][columnIndex];
		else
			return " ";
	}



	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void addTableModelListener(TableModelListener l) {
		tableModelListener=l;
		
		
	}



	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}



	
}
