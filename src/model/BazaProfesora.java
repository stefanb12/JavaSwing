package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private List<Profesor> profesori;
	private List<String> kolone;

	private BazaProfesora() {
	
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Adresa stavnovanja");
		this.kolone.add("Telefon");
		this.kolone.add("E-mail adresa");
		this.kolone.add("Adresa kancelarije");
		this.kolone.add("Broj licne karte");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");

	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		
		List<Predmet> predmeti = new ArrayList<Predmet>();
		profesori.add(new Profesor("Pera", "Peric", Profesor.parseDate("1.1.2001"), 
				"Novi sad 1", "064", "sdasd@gmail ","Beograd", "1231231", "Doktor", "Nastavnik", predmeti));
		profesori.add(new Profesor("Pera", "Peric", Profesor.parseDate("1.1.2001"), 
				"Novi sad 1", "064", "sdasd@gmail ","Beograd", "1231231", "Doktor", "Nastavnik", predmeti));
		profesori.add(new Profesor("Pera", "Peric", Profesor.parseDate("1.1.2001"), 
				"Novi sad 1", "064", "sdasd@gmail ","Beograd", "1231231", "Doktor", "Nastavnik", predmeti));

	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 10;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return Profesor.parseDateToString(profesor.getDatumRodjenja());
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getKontaktTelefon();
		case 5:
			return profesor.getEmailAdresa();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrojLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		default:
			return null;
		}
	}
		
	public void dodajProfesora(String ime, String prezime,Date datumRodjenja, String adresaStanovanja, String telefon,
			String email,String adresaKancelarije, String brojLicneKarte, String titula, String zvanje, List<Predmet> predmeti) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije,
				brojLicneKarte, titula, zvanje, predmeti));
	}

	public void izmeniProfesora(String ime, String prezime,Date datumRodjenja, String adresaStanovanja, String telefon,
			String email,String adresaKancelarije, String brojLicneKarte, String titula, String zvanje, List<Predmet> predmeti) {
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesor.setIme(ime);
				profesor.setPrezime(prezime);
				profesor.setDatumRodjenja(datumRodjenja);
				profesor.setAdresaStanovanja(adresaStanovanja);
				profesor.setKontaktTelefon(telefon);
				profesor.setEmailAdresa(email);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setBrojLicneKarte(brojLicneKarte);
				profesor.setTitula(titula);
				profesor.setZvanje(zvanje);
				profesor.setSpisakPredmeta(predmeti);
			}
		}
	}
	
	public void izbrisiProfesora(String brojLicneKarte) {
		for (Profesor profesor : profesori) {
			if (profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesori.remove(profesor);
				break;
			}
		}
	}

}
