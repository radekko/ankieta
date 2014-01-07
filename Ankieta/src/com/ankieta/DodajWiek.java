package com.ankieta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodajWiek extends JFrame implements Operation, ActionListener{
	private Osoba osoba;
	private JTextField wiekTf;
	private JButton nextJb;
	private JButton prevJb;

	public DodajWiek(Osoba osoba) {
		this.osoba = osoba;
		initializeDialog();
	}
	
	private void initializeDialog(){
		this.setTitle("Dodaj wiek");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel imiePanel = new JPanel();
		wiekTf = new JTextField(30);
		nextJb = new JButton("next");
		nextJb.addActionListener(this);
		prevJb = new JButton("prev");
		prevJb.addActionListener(this);

		imiePanel.add(wiekTf);
		imiePanel.add(prevJb);
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
			osoba.setWiek(Integer.valueOf(wiekTf.getText()));
			System.out.println(osoba);
			new DisplayOsoba(osoba); 
			this.dispose();
		}
		else if (e.getSource() == prevJb) {
			osoba.setWiek(0);
			new DodajNazwisko(osoba);
			this.dispose();
		}
	}
}
