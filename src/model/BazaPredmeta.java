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
	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		Profesor profesor1 = new Profesor("Milan", "Petrovic", Profesor.parseDate("2.1.1965"), 
				"Josifa Runjanina 3", "064 321 7123", "milan@gmail ","", "1231231", "Profesor", "Doktor", null);
		Profesor profesor2 = new Profesor("Jovan", "Milanovic", Profesor.parseDate("1.2.1970"), 
				"Alekse Santica 53", "063 412 4381", "jovan@gmail ","Beograd", "1231231", "Profesor", "Doktor", null);
		Profesor profesor3 = new Profesor("Predrag", "Stevanovic", Profesor.parseDate("12.3.1971"), 
				"Safarikova 32", "062 576 5342", "predrag@gmail ","Beograd", "1231231", "Profesor", "Doktor", null);
		Profesor profesor4 = new Profesor("Ivana", "Mitrovic", Profesor.parseDate("21.4.1969"), 
				"Jevrejska 10", "064 247 953", "ivana@gmail ","Beograd", "1231231", "Profesor", "Doktor", null);
		List<Student> studenti1 = new ArrayList<Student>();
		List<Student> studenti2 = new ArrayList<Student>();
		predmeti.add(new Predmet("RW123", "Metode optimizacije", 4, 2, profesor1, studenti1));
		predmeti.add(new Predmet("32DF3", "Algebra", 1, 1, profesor2, studenti1));
		predmeti.add(new Predmet("E24RE", "Programski prevodioci", 5, 3, profesor3, studenti2));
		predmeti.add(new Predmet("M3282", "Elektrotehnika", 2, 1, profesor4, studenti2));

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
