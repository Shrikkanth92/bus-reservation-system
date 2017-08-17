package com.polaris.teamd.ui.custom.inputpanel;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.FocusListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JPanel;

import com.polaris.teamd.app.ApplicationCache;

public abstract class CInputPanel extends JPanel {

	public CInputPanel() {
		super();

	}

	public CInputPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);

	}

	public CInputPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);

	}

	public CInputPanel(LayoutManager layout) {
		super(layout);

	}

	abstract public void addValidators(FocusListener focusListener);
	
	abstract public void cSetErrorMessage(String message);
	abstract public void cClearErrorMessage() ;
	
	
	abstract public void cSetTargetBean(String propertyKey) ;
	abstract public void cSetTarget() ;

	abstract public void cSetTargetProperty(String propertyName) ;

	

	abstract public void setData(Object object) ;
	abstract public void cRender();
	abstract public void setColumnLength(int columnLength);
	abstract public void cRender(int top,int left,int bottom,int right);
	abstract public void cSetLabelSize(int width, int height);
	abstract public void cSetInputSize(int width, int height) ;
	abstract public void cSetErrorLabelSize(int width, int height) ;
	abstract public void hide() ;
	abstract public void hideError() ;

	abstract public void show() ;
}
