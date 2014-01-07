package com.ankieta;

public class Store {

	private Osoba osoba;
	
	public void prepareOsoba(){
		Operation dodajImie = new DodajImie(new Osoba());
		osoba = dodajImie.getOsoba();
	}
	
	public Osoba getOsoba() {
		return osoba;
	}
	
}
