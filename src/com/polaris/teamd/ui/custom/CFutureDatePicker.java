package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class CFutureDatePicker extends CDatePicker{
	CSpinner monthSpinner,yearSpinner;
	CTextInputPanel targetUI;
	ArrayList<String> monthNames=new ArrayList<String>();
	private ArrayList<String> newMonthNames=new ArrayList<String>();
	int currentMonth;
	int currentYear;
	int currentDate;
	final int yearLowerBound;
	int monthLowerBound;
	
	CTable calendarTable;
	CDateGenerator dateGenerator;
	JScrollPane jScrollPane;
	JPanel panel2=new JPanel(new BorderLayout());
	SpinnerModel monthModel;
	JPanel headerPanel=new JPanel();
	public CFutureDatePicker() {
		super();
		
		
		
		
		monthNames.add("JAN");
		monthNames.add("FEB");
		monthNames.add("MAR");
		monthNames.add("APRIL");
		monthNames.add("MAY");
		monthNames.add("JUNE");
		monthNames.add("JULY");
		monthNames.add("AUG");
		monthNames.add("SEP");
		monthNames.add("OCT");
		monthNames.add("NOV");
		monthNames.add("DEC");
		
		
		
		Calendar calendar=Calendar.getInstance();
		currentDate=calendar.get(Calendar.DATE);
		currentMonth=calendar.get(Calendar.MONTH);
		monthLowerBound=currentMonth;
		currentYear=calendar.get(Calendar.YEAR);
		yearLowerBound=currentYear;
		dateGenerator=new CDateGenerator(currentYear, currentMonth);
		
	
		monthModel=new SpinnerListModel(monthNames);
		
		
		monthSpinner=new CSpinner(monthModel);
		monthSpinner.setValue(monthNames.get(currentMonth));
		
		monthSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				CSpinner ms=(CSpinner) e.getSource();
				String spinnerMonthName=(String) ms.getValue();
				currentMonth=monthNames.indexOf(spinnerMonthName);
				if(yearLowerBound==currentYear){
					if(currentMonth < monthLowerBound)   
						monthSpinner.setValue(monthNames.get(monthLowerBound));
				}
				
				dateGenerator.setMonth(currentMonth);
				calendarTable.repaint();
			}
		});
		SpinnerNumberModel yearModel=new SpinnerNumberModel(currentYear, currentYear, 5000, 1);
		yearModel.setValue(currentYear);
		yearModel.setStepSize(1);
		yearSpinner=new CSpinner(yearModel);
		yearSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				CSpinner ms=(CSpinner) e.getSource();
				currentYear=(Integer) ms.getValue();
				if(currentYear==yearLowerBound)
					monthSpinner.setValue(monthNames.get(monthLowerBound));
				
				dateGenerator.setYear(currentYear);
				calendarTable.repaint(); 
				
			}
		});
		
		
		calendarTable=new CTable(dateGenerator);
		jScrollPane=new JScrollPane(calendarTable);
		calendarTable.setRowSelectionAllowed(false);
		calendarTable.setCellSelectionEnabled(true);
		calendarTable.setSelectionBackground(Color.ORANGE);
		
		
		calendarTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				CTable cTable=(CTable) e.getSource();
				int r=cTable.getSelectedRow();
				int c=cTable.getSelectedColumn();
				Object obj=cTable.getValueAt(r, c);
				String str=obj.toString()+"/"+monthSpinner.getValue()+"/"+yearSpinner.getValue();
				CText targetTextBox=targetUI.getInput();
				targetTextBox.setText(str);
				remove(panel2);
				
				invalidate();
				validate();
				repaint();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		setLayout(new BorderLayout());
		//add(targetUI,BorderLayout.NORTH);
		
		
		
	
		headerPanel.add(monthSpinner);
		headerPanel.add(yearSpinner);
		panel2.add(headerPanel,BorderLayout.NORTH);
		panel2.add(jScrollPane);
		
		
		this.add(panel2,BorderLayout.CENTER);
			
	
		}
	
	public CTextInputPanel getTargetUI() {
		return targetUI;
	}
	public void setTargetUI(CTextInputPanel targetUI) {
		this.targetUI = targetUI;
		targetUI.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				add(panel2, BorderLayout.CENTER);
				invalidate();
				validate();
				repaint();
				
			}
		});
	}
}
