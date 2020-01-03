package model;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable {
	
	private static final long serialVersionUID = 3602205603825194210L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private int semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private List<Student> spisakStudenata;
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija,
			Profesor predmetniProfesor, List<Student> spisakStudenata) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.spisakStudenata = spisakStudenata;
	}
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
	
	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", predmetniProfesor=" + predmetniProfesor + ", spisakStudenata="
				+ spisakStudenata + "]";
	}
			
}
