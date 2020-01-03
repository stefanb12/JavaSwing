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
		profesori.add(new Profesor("Milan", "Petrovic", Profesor.parseDate("2.1.1965"), 
				"Josifa Runjanina 3", "064 321 7123", "milan@gmail ","Novi sad", "1523", "Profesor", "Doktor", predmeti));
		profesori.add(new Profesor("Predrag", "Stevanovic", Profesor.parseDate("12.3.1971"), 
				"Safarikova 32", "062 576 5342", "predrag@gmail ","Novi sad", "5123", "Profesor", "Doktor", predmeti));
		profesori.add(new Profesor("Jovan", "Milanovic", Profesor.parseDate("1.2.1970"), 
				"Alekse Santica 53", "063 412 4381", "jovan@gmail ","Beograd", "1231", "Profesor", "Doktor", predmeti));
		profesori.add(new Profesor("Ivana", "Mitrovic", Profesor.parseDate("21.4.1969"), 
				"Jevrejska 10", "064 247 953", "ivana@gmail ","Beograd", "4231", "Profesor", "Doktor", predmeti));

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
