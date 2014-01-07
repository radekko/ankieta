package com.ankieta;

import java.awt.EventQueue;

public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Store s = new Store();
				s.prepareOsoba();
			}
		});
	}
}
