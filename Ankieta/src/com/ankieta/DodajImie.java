package com.ankieta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DodajImie extends JFrame implements Operation, ActionListener {
	private Osoba osoba;
	private JTextField imieTf;
	private JButton nextJb;
	

	public DodajImie(Osoba osoba) {
		this.osoba = osoba;
		initializeDialog();
	}
	
	private void initializeDialog(){
		this.setTitle("Dodaj imie");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel imiePanel = new JPanel();
		imieTf = new JTextField(30);
		nextJb = new JButton("next");
		nextJb.addActionListener(this);

		imiePanel.add(imieTf);
		imiePanel.add(nextJb);
		
		this.add(imiePanel);
		this.setVisible(true);
	}

	@Override
	public Osoba getOsoba() {
		return osoba;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextJb) {
			osoba.setImie(imieTf.getText());
			Operation dodajNazwisko = new DodajNazwisko(osoba);
			DodajImie.this.osoba = dodajNazwisko.getOsoba();
			System.out.println(osoba);
			this.dispose();
		}
	}
	
}
