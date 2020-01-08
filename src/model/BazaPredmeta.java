package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import view.MainFrame;
import view.PredmetiJTable;

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
		List<Student> studenti = new ArrayList<Student>();
		predmeti.add(new Predmet("RW123", "Metode optimizacije", 4, 2, profesor1, studenti));
		predmeti.add(new Predmet("32DF3", "Algebra", 1, 1, profesor2, studenti));
		predmeti.add(new Predmet("E24RE", "Programski prevodioci", 5, 3, profesor3, studenti));
		predmeti.add(new Predmet("M3282", "Elektrotehnika", 2, 1, profesor4, studenti));
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
	
	public void dodajProfesoraNaPredmet(String brojLicneKarte) {
		Predmet predmet = getRow(PredmetiJTable.rowSelectedIndex);
    	List<Profesor> profesori = BazaProfesora.getInstance().getProfesori();
    	boolean postoji = false;
    	for(Profesor profesor : profesori) {
    		if(profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
    			predmet.setPredmetniProfesor(profesor);
    			postoji = true;
    			break;
    		} 
    	}
    	if(!postoji) 
    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne postoji profesor sa brojem licne karte koju ste uneli!",
    				"Neuspešno dodavanje", JOptionPane.ERROR_MESSAGE);
	}
	
	public List<Predmet> predmetiZaProfesora(String brojLicneKarte) {
		List<Predmet> pronadjeniPredmeti = new ArrayList<Predmet>();
    	for(Predmet predmet : this.predmeti) {
    		if(predmet.getPredmetniProfesor() != null)
    			if(predmet.getPredmetniProfesor().getBrojLicneKarte().equals(brojLicneKarte)) 
    				pronadjeniPredmeti.add(predmet);
    	}
    	return pronadjeniPredmeti;
	}
	
	public List<Predmet> predmetiZaStudenta(String brojIndeksa) {
		List<Predmet> odgovarajuciPredmeti = new ArrayList<Predmet>();
    	for(Predmet predmet : this.predmeti) {
    		if(predmet.getSpisakStudenata() == null){
    			return odgovarajuciPredmeti;
    		}else{
    		for(Student student : predmet.getSpisakStudenata()){
    			if(student.getBrojIndeksa().equals(brojIndeksa)){
    				odgovarajuciPredmeti.add(predmet);
    			}
    		}
    	}
    	}
    	return odgovarajuciPredmeti;
	}

	
	public void dodajStudentaNaPredmet(String brojIndeksa){
		   if (PredmetiJTable.rowSelectedIndex < 0)
				return;
	   	Predmet predmet = BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex);
	   	List<Student> studenti = BazaStudenata.getInstance().getStudenti();
	   	List<Student> odgovarajuci = predmet.getSpisakStudenata();
	   	for(Student student : studenti) {
	   		if(student.getBrojIndeksa().equals(brojIndeksa) && student.getTrenutnaGodinaStudija() == predmet.getGodinaStudija()) {
	   			odgovarajuci.add(student);
	   			predmet.setSpisakStudenata(odgovarajuci);
	   			break;
	   		} 
	   	}
	}

	@SuppressWarnings("unchecked")
	public void loadPredmete(String file) {
		ObjectInputStream in = null;
		List<Predmet> predmeti = new ArrayList<Predmet>();
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			predmeti = (List<Predmet>) in.readObject();
			this.setPredmeti(predmeti);	
			PredmetiJTable.azurirajPrikaz();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void savePredmete(String file) {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(this.getPredmeti());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
