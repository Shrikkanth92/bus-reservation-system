package com.polaris.teamd.ui.custom;


import java.awt.FlowLayout;


import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.polaris.teamd.common.PropertyFileProcessing;
import com.polaris.teamd.ui.CUIComponentType;
import com.polaris.teamd.ui.CUIFactory;

public class UserFrame extends JFrame{
	
	CToolBar userToolBar;
	
	public UserFrame() {
		CUIFactory factory=new CUIFactory();
		PropertyFileProcessing processor = new PropertyFileProcessing(new File("resources/applicationRoles.properties"));
		
		setFlowLayout();
		
		userToolBar =(CToolBar) factory.createUIComponent(CUIComponentType.TOOLBAR);
		String[] toolBarButtons=processor.getIndexedPropertyValues("user");
		
		for(int i=0; i< toolBarButtons.length ; i++)
		{
			CButton button = new CButton(toolBarButtons[i]);
			userToolBar.add(button);
		}
		
		addComponent(userToolBar);
		showFrame("User AppFrame");
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
