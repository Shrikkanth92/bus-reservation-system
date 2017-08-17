package com.polaris.teamd.ui.custom;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class AppFrame2 extends JFrame {
	CSimpleDatePicker cSimpleDatePicker;
	
	public AppFrame2() {
		cSimpleDatePicker=new CSimpleDatePicker();
		addComponent(cSimpleDatePicker);
		showFrame("JLIST DEMO");

	}

	public void addComponent(JComponent jComponent) {
		this.getContentPane().add(jComponent);
	}
	public void setFlowLayout(){
		this.getContentPane().setLayout(new FlowLayout());
	}
	public void setBorderLayout(){
		this.getContentPane().setLayout(new BorderLayout());
	}
	public void setGridLayout(){
		this.getContentPane().setLayout(new GridLayout());
	}
	public void setCardLayout(){
		this.getContentPane().setLayout(new CardLayout());
	}
	public void setGridBagLayout(){
		this.getContentPane().setLayout(new GridBagLayout());
	}
	public void showFrame(String title){
		this.setTitle(title);
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AppFrame2();
	}
}