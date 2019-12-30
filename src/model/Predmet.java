package model;

import java.util.List;

public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	private int semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private List<Student> spisakStudenata;
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	public List<Student> getSpisakStudenata() {
		return spisakStudenata;
	}
	public void setSpisakStudenata(List<Student> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}
	
		
}
