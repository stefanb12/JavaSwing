package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {
	
		initPredmete();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina");
		this.kolone.add("Profesor");
		//this.kolone.add("Studenti"); // U ovoj kolini treba da bude Btn "Prikazi" 
	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		Profesor profesor = new Profesor("Pera", "Peric", Profesor.parseDate("1.1.2001"), 
				"Novi sad 1", "064", "sdasd@gmail ","Beograd", "1231231", "Doktor", "Nastavnik", new ArrayList<Predmet>());
		List<Student> studenti = new ArrayList<Student>();
		predmeti.add(new Predmet("1wd1342", "OISIS", 7, 3, profesor, studenti));
		predmeti.add(new Predmet("11hhh1sdf3", "MATA", 4, 2, profesor, studenti));
		predmeti.add(new Predmet("1wdkk23", "NANS", 4, 2, profesor, studenti));

	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getSemestar());
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			if(predmet.getPredmetniProfesor() != null)  
				return predmet.getPredmetniProfesor().getIme() + " " + predmet.getPredmetniProfesor().getPrezime();
			else 
				return "Nema profesora";
		default:
			return null;
		}
	}
		
	public void dodajPredmet(String sifra, String naziv, int semestar, int godina, Profesor profesor, List<Student> studenti) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar, godina, profesor, studenti));
	}

	public void izmeniPredmet(String sifra, String naziv, int semestar, int godina, Profesor profesor, List<Student> studenti) {
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifra)) {
				predmet.setSifraPredmeta(sifra);
				predmet.setNazivPredmeta(naziv);
				predmet.setSemestar(semestar);
				predmet.setGodinaStudija(godina);
				predmet.setPredmetniProfesor(profesor);
				predmet.setSpisakStudenata(studenti);
			}
		}
	}
	
	public void izbrisiPredmet(String sifra) {
		for (Predmet predmet : predmeti) {
			if (predmet.getSifraPredmeta().equals(sifra)) {
				predmeti.remove(predmet);
				break;
			}
		}
	}

}
