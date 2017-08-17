package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.polaris.teamd.ui.custom.inputpanel.CFilterTableInputPanel;

public class AppFrame extends JFrame{
		CFilterTableInputPanel filterTable;
		ContactTableModel tableModel = new ContactTableModel();
		
			public AppFrame() {
				
				filterTable = new CFilterTableInputPanel();
				filterTable.cInit();
			//	filterTable=filterTable.cRender();
				filterTable.cRenderBorderLayout();
				addComponent(filterTable);
				showFrame("FilterTable Demo");
			}
			

			public void addComponent(JComponent component) {
				this.getContentPane().add(component);
			}

			public void setFlowLayout() {
				this.getContentPane().setLayout(new FlowLayout());
			}

			public void showFrame(String title)
			{
				this.setTitle(title);
				this.setSize(300, 300);
				this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		
}
