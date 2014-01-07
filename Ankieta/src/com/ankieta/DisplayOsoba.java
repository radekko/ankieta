package com.ankieta;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayOsoba extends JFrame implements Operation{

	private Osoba osoba;
	
	public DisplayOsoba(Osoba osoba) throws HeadlessException {
		this.osoba = osoba;
		initialize();
	}
	
	private void initialize() {
		this.setTitle("Dodaj wiek");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel osobaPanel = new JPanel();
		OsobaTableModel model = new OsobaTableModel(osoba);
		JTable osobaTab = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(osobaTab);
		osobaPanel.add(scrollPane);
		
		this.add(osobaPanel);
		this.setVisible(true);
	}
	
	@Override
	public Osoba getOsoba() {
		return osoba;
	}

}
