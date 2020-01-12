package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//enum Stanje { B, S };

public class Student implements Serializable {
	
	private static final long serialVersionUID = -1514410461557780916L;
	
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private Date datumUpisa;
	private int trenutnaGodinaStudija;
	private double prosecnaOcena;
	private Stanje stanje;
	private List<Predmet> spisakPredmeta = new ArrayList<Predmet>();
	
	public Student() {}
	
	public Student(String brojIndeksa, String ime, String prezime, Date datumRodjenja,
			String adresaStanovanja, String kontaktTelefon, String emailAdresa, 
			Date datumUpisa, int trenutnaGodinaStudija, double prosecnaOcena, 
			Stanje stanje, List<Predmet> spisakPredmeta) {
		super();
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.stanje = stanje;
		this.spisakPredmeta = spisakPredmeta;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmailAdresa() {
		return emailAdresa;
	}
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public Date getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public Stanje getStanje() {
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}	
	public List<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}
	public void setSpisakPredmeta(List<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
	public static String parseDateToString(Date date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
			return dateFormat.format(date);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd.MM.yyyy.").parse(date);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public String toString() {
		return "Student [brojIndeksa=" + brojIndeksa + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", emailAdresa="
				+ emailAdresa + ", datumUpisa=" + datumUpisa
				+ ", trenutnaGodinaStudija=" + trenutnaGodinaStudija + ", prosecnaOcena=" + prosecnaOcena + ", stanje="
				+ stanje + ", spisakPredmeta=" + spisakPredmeta + "]";
	}

}
