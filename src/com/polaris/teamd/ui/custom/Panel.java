package com.polaris.teamd.ui.custom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.polaris.teamd.ui.custom.CLabel;

public class Panel extends JPanel {
	
	private JLabel label;
	public Panel() {
		setLayout(new BorderLayout());
		label=new JLabel("Work in progress...");
		label.setFont(new Font("Arial", Font.BOLD,40 ));
		this.setPreferredSize(new Dimension(1000, 800));
		this.setMinimumSize(new Dimension(1000, 800));
		this.setSize(new Dimension(1000, 800));
		this.add(label,BorderLayout.NORTH);
		
		
		
	}

}
