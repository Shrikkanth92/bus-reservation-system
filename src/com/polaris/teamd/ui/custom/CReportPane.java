package com.polaris.teamd.ui.custom;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;

public class CReportPane extends JEditorPane {

	public CReportPane() {
		super();
	}

	public CReportPane(String type, String text) {
		super(type, text);
	}

	public CReportPane(String url) throws IOException {
		super(url);
	}

	public CReportPane(URL initialPage) throws IOException {
		super(initialPage);
	}

}
