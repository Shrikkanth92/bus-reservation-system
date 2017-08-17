package com.polaris.teamd.reports;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.polaris.teamd.common.utils.IOUtil;
import com.polaris.teamd.ui.custom.CEditorPane;

public abstract class CReport {
	String fileName;
	public void generateReportTo(String fileName) {
	this.fileName=fileName;
	}
	abstract void generateReport(Object...param);
		public void showReport(JPanel jpanel){
		JScrollPane scrollpane=new JScrollPane(jpanel);
		try {
			CEditorPane editorPane=new CEditorPane(fileName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		}
}
