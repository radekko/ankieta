package com.ankieta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodajNazwisko extends JFrame implements Operation, ActionListener{
	private Osoba osoba;
	private JTextField nazwiskoTf;
	private JButton nextJb;
	private JButton prevJb;

	public DodajNazwisko(Osoba osoba) {
		this.osoba = osoba;
		initializeDialog();
	}
	
	private void initializeDialog(){
		this.setTitle("Dodaj nazwisko");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel nazwiskoPanel = new JPanel();
		nazwiskoTf = new JTextField(30);
		nextJb = new JButton("next");
		nextJb.addActionListener(this);
		prevJb = new JButton("prev");
		prevJb.addActionListener(this);

		nazwiskoPanel.add(nazwiskoTf);
		nazwiskoPanel.add(prevJb);
		nazwiskoPanel.add(nextJb);
		
		this.add(nazwiskoPanel);
		this.setVisible(true);
	}

	@Override
	public Osoba getOsoba() {
		return osoba;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextJb) {
			osoba.setNazwisko(nazwiskoTf.getText());
			Operation dodajWiek = new DodajWiek(osoba);
			DodajNazwisko.this.osoba = dodajWiek.getOsoba();
			System.out.println(osoba);
			this.dispose();
		}
		else if (e.getSource() == prevJb) {
			osoba.setNazwisko("");
			new DodajImie(osoba);
			this.dispose();
		}
	}
}
