package com.ankieta;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;

public class OsobaTableModel extends AbstractTableModel {

	public String[] m_colNames = { "Imie", "Nazwisko", "Wiek"};

    public Class[] m_colTypes = { String.class, String.class, Integer.class };

    List<Osoba> osoby = new ArrayList<Osoba>();

    public OsobaTableModel(Osoba osoba) {
    	osoby.add(osoba);
    }
    public int getColumnCount() {
      return m_colNames.length;
    }
    public int getRowCount() {
      return osoby.size();
    }
    public void setValueAt(Object value, int row, int col) {
      Osoba osoba = (Osoba) (osoby.get(row));

      switch (col) {
      case 0:
        osoba.setImie((String) value);
        break;
      case 1:
        osoba.setNazwisko((String) value);
        break;
      case 2:
        osoba.setWiek(Integer.valueOf((String) value));
        break;
      }
    }

    public String getColumnName(int col) {
      return m_colNames[col];
    }

    public Class getColumnClass(int col) {
      return m_colTypes[col];
    }
    public Object getValueAt(int row, int col) {
      Osoba osoba = (Osoba) (osoby.get(row));

      switch (col) {
      case 0:
        return osoba.getImie();
      case 1:
        return osoba.getNazwisko();
      case 2:
        return osoba.getWiek();
      }

      return new String();
    }
  }

