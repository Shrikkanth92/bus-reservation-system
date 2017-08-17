package com.polaris.teamd.ui;

public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.polaris.teamd.app.ApplicationCache");
		new AppFrame1();
	}

}
