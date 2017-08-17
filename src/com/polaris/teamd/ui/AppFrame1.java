package com.polaris.teamd.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;
import com.polaris.teamd.bean.CLogin;
import com.polaris.teamd.db.impl.CLoginDAOImpl;
import com.polaris.teamd.service.CLoginService;
import com.polaris.teamd.service.CLoginServiceImpl;
import com.polaris.teamd.ui.custom.CActionPanel;
import com.polaris.teamd.ui.custom.CButton;
import com.polaris.teamd.ui.custom.CForm;
import com.polaris.teamd.ui.custom.CLabel;
import com.polaris.teamd.ui.custom.CPassword;
import com.polaris.teamd.ui.custom.CText;
import com.polaris.teamd.ui.custom.inputpanel.CPasswordInputPanel;
import com.polaris.teamd.ui.custom.inputpanel.CTextInputPanel;

public class AppFrame1 extends JFrame {

	private AppPanel appPanel;
	private CForm cLoginForm;
	private String roleType;
	private CLoginService loginService;
	private CLabel loginLabel;
	public AppFrame1() {
		loginService = new CLoginServiceImpl();
		cLoginForm = new CUIFactory()
				.createForm("resources/forms/login/cloginform.properties");
		new CUIFactory().setFormUI(cLoginForm);
		
		cLoginForm.setPosition(0, 8, 0);
		cLoginForm.cSetSize(0, 500, 70);
		cLoginForm.setPosition(1, 9, 0);
		cLoginForm.cSetSize(1, 500, 70);
		cLoginForm.setPosition(2, 10, 0);
		cLoginForm.cSetSize(2, 500, 70);
		cLoginForm.render();
		
//		loginLabel = (CLabel) new CUIFactory().createUIComponent(CUIComponentType.LABEL);
//		loginLabel.cSetIcon("login.jpg");
		
		
		CTextInputPanel cTextInputPanel=(CTextInputPanel) cLoginForm.getInputPanel(0);
		cTextInputPanel.cRenderFlowLayout();
		
		//cLoginForm.getInputPanel(1).setSize(250, 30);
		CPasswordInputPanel passwordInputPanel=(CPasswordInputPanel) cLoginForm.getInputPanel(1);
		cLoginForm.setBorder(BorderFactory.createLineBorder(Color.orange));
		passwordInputPanel.cRenderFlowLayout();
		this.getContentPane().add(cLoginForm,BorderLayout.CENTER);
		
		
		 CActionPanel actionPanel =(CActionPanel) cLoginForm.getInputPanel(2);
		 actionPanel.cRender();
		// CButton loginButton=actionPanel.getButtonAt(0);
		// loginButton.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// roleType = "staff";
		// appPanel= new AppPanel(roleType);
		// appPanel.setVisible(true);
		// addComponent(appPanel);
		// remove(cLoginForm);
		// appPanel.setSize(1600,800);
		// appPanel.setPreferredSize(new Dimension(1600, 800));
		// appPanel.setMaximumSize(new Dimension(1600, 800));
		// invalidate();
		// validate();
		// repaint();
		//
		// }
		// });

		 
		CButton loginButton = actionPanel.getButtonAt(0);

		final CText cText = ((CTextInputPanel) cLoginForm.getInputPanel(0)).getInput();
				

		final CPassword cText2 = ((CPasswordInputPanel) cLoginForm
				.getInputPanel(1)).cGetInput();

		System.out.println(loginButton.getText());
		
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Login pressed");
				// roleType = "admin";
				String loginId = cText.getText();
				String password = new String(cText2.getPassword());
				CLogin cLogin = new CLogin(loginId, password);
				String type = null;
				
				if (loginService.authenticate(cLogin)) {
					System.out.println("USER FOUND");
					remove(cLoginForm);
					int roleType = ((CLogin) ApplicationCache.getValue("Current Login")).getRoleId();
					System.out.println(((CLogin) ApplicationCache.getValue("Current Login")));
					if(roleType==1) 	type= "admin";
					if(roleType==2)		type="staff";
					appPanel = new AppPanel(type);
					addComponent(appPanel);
					
					invalidate();
					validate();
				}
				else{
					System.out.println("User not found");
				}
			}
		});

		showFrame("XYZ Travel Agency");
	}

	public void addComponent(JComponent component) {
		this.getContentPane().add(component);
	}

	public void setFlowLayout() {
		this.getContentPane().setLayout(new FlowLayout());
	}

	public void showFrame(String title) {
		this.setTitle(title);
		Image image = null;
		try {
			image = ImageIO.read(new File("menuicon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setIconImage(image);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
