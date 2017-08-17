package com.polaris.teamd.ui.custom;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;

public class CEditorPane extends JEditorPane{

	public CEditorPane() {
		super();
	}

	public CEditorPane(String type, String text) {
		super(type, text);
	}

	public CEditorPane(String url) throws IOException {
		super(url);
	}

	public CEditorPane(URL initialPage) throws IOException {
		super(initialPage);
	}

}
