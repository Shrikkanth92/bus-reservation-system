package com.polaris.teamd.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.common.PropertyFileProcessing;
import com.polaris.teamd.common.utils.UIUtil;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CMenuButton;
import com.polaris.teamd.ui.custom.CToolBar;

public class AppPanel extends JPanel {

	private CToolBar toolBar1, toolBar2,toolBar3;
	private JPanel panel1, panel2, panel3, panel4;
	private CUIFactory factory = new CUIFactory();
	private CButton logOutButton,exitButton;
	private PropertyFileProcessing processor;
	private int red, blue, green;
	private CLabel copyRightsLabel;

	public AppPanel(String role) {

		setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		logOutButton = (CButton) factory.createUIComponent(CUIComponentType.BUTTON);
		exitButton = (CButton) factory.createUIComponent(CUIComponentType.BUTTON);
		
		toolBar1 = (CToolBar) factory
		.createUIComponent(CUIComponentType.TOOLBAR);
		toolBar1.setBackground(new Color(242, 198, 121));
		toolBar2 = (CToolBar) factory
		.createUIComponent(CUIComponentType.TOOLBAR);

		toolBar3= (CToolBar) factory
		.createUIComponent(CUIComponentType.TOOLBAR);

		toolBar1 = buildMenuforRole(role, toolBar1, 198, 50);

		copyRightsLabel= (CLabel) factory.createUIComponent(CUIComponentType.LABEL);
		copyRightsLabel.setText("Copyrights reserved.Done by TeamD 2014");
		processor = new PropertyFileProcessing(new File(
		"resources/ui/ui.properties"));
		final String path = processor.getStringProperty("ui.panel.background");
		red = processor.getIntProperty("ui.menu.button.background.red");
		green = processor.getIntProperty("ui.menu.button.background.green");
		blue = processor.getIntProperty("ui.menu.button.background.blue");
		Color color = new Color(red, green, blue);

		logOutButton.setText("Log Out");
		logOutButton.cSetIcon("logout.png");
		logOutButton.setBackground(color);

		exitButton.cSetIcon("exit.jpg");
		exitButton.setText("Exit");
		exitButton.setBackground(color);

		panel1 = new JPanel() {
			public void paint(java.awt.Graphics g) {
				super.paint(g);
				Image image = UIUtil.getScaledImage(path, this.getWidth(),
						this.getHeight());
				g.drawImage(image, 0, 0, null);
			};
		};

		panel2 = new JPanel(new BorderLayout()) {
			public void paint(java.awt.Graphics g) {
				super.paint(g);
				Image image = UIUtil.getScaledImage(path, this.getWidth(),
						this.getHeight());
				g.drawImage(image, 0, 0, null);
			};
		};
		panel3 = new JPanel();
		ApplicationCache.put("CONTENTSCREEN", panel3);
		panel4 = new JPanel(new BorderLayout());

		toolBar1.setFloatable(false);
		toolBar2.setFloatable(false);
		toolBar2.setEnabled(false);
		toolBar2.add(logOutButton);
		toolBar2.addSeparator(new Dimension(10, 10));
		toolBar2.add(exitButton);

		toolBar3.setFloatable(false);
		toolBar3.add(copyRightsLabel);

		copyRightsLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel1.add(toolBar1);
		panel2.add(toolBar2, BorderLayout.EAST);
		panel4.add(panel2, BorderLayout.NORTH);
		panel4.add(panel3, BorderLayout.CENTER);


		splitPane.setLeftComponent(panel1);
		splitPane.setRightComponent(panel4);
		splitPane.setDividerSize(0);
		this.setVisible(true);
		this.add(splitPane);
		this.add(toolBar3,BorderLayout.SOUTH);

	}

	public CToolBar buildMenuforRole(String role, CToolBar userToolBar,
			int width, int height) {

		processor = new PropertyFileProcessing(new File(
		"resources/applicationRoles.properties"));
		String[] toolBarButtons = processor.getIndexedPropertyValues(role
				.toLowerCase());
		userToolBar.setName(role.toUpperCase() + "FRAME");
		userToolBar.setOrientation(CToolBar.VERTICAL);
		userToolBar.addSeparator(new Dimension(20, 20));
		String[] actions = processor.getIndexedPropertyValues(role
				.toLowerCase() + ".action");
		String[] toolTiptext = processor.getIndexedPropertyValues(role
				.toLowerCase() + ".tooltiptext");
		for (int i = 0; i < toolBarButtons.length; i++) {
			CMenuButton button = (CMenuButton) factory
			.createUIComponent(CUIComponentType.MENUBUTTON);
			try {
				Class actionClass = Class.forName(actions[i]);
				Object object = actionClass.newInstance();
				button.setAction((Action) object);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			button.setText(toolBarButtons[i]);
			button.setToolTipText(toolTiptext[i]);
			button.setBackground(new Color(232, 140, 42));
			button.setHorizontalAlignment(SwingConstants.CENTER);
			button.setPreferredSize(new Dimension(width, height));
			button.setMaximumSize(new Dimension(width, height));

			factory.setAnimation(new ColorChangingListener(), button);
			factory.setAnimation(new BorderChangingListener(), button);
			factory.setAnimation(new FontChangingListener(), button);

			userToolBar.addSeparator(new Dimension(20, 10));
			userToolBar.add(button);
			userToolBar.setEnabled(false);
		}
		return userToolBar;

	}
}
