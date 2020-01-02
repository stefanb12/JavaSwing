package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance(){
		if(instance == null){
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
		InitStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Broj indeksa");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Telefon");
		this.kolone.add("Mejl adresa");
		this.kolone.add("Datum upisa");
		this.kolone.add("Godina studija");
		this.kolone.add("Prosecna ocena");
		this.kolone.add("Status");

	}
	
	private void InitStudente(){
		this.studenti = new ArrayList<Student>();
		
		studenti.add(new Student("RA001", "Marko", "Markovic", Student.parseDate("1.1.1998."), "Novi Sad 2", "063", "esd123@gmail.com", 
				Student.parseDate("1.7.2017."), 3, 8.5, Stanje.B));
			
	}
	
	public List<Student> getStudenti(){
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti){
		this.studenti = studenti;
	}
	
	public int getColumnCount(){
		return 11;
	}
	
	public String getColumnName(int index){
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex){
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student studenti = this.studenti.get(row);
		switch (column) {
		case 0:
			return studenti.getBrojIndeksa();
		case 1:
			return studenti.getIme();
		case 2:
			return studenti.getPrezime();
		case 3:
			return Student.parseDateToString(studenti.getDatumRodjenja());
		case 4:
			return studenti.getAdresaStanovanja();
		case 5:
			return studenti.getKontaktTelefon();
		case 6:
			return studenti.getEmailAdresa();
		case 7:
			return Student.parseDateToString(studenti.getDatumUpisa());
		case 8:
			return String.valueOf(studenti.getTrenutnaGodinaStudija());
		case 9:
			return String.valueOf(studenti.getProsecnaOcena());
		case 10:
			return String.valueOf(studenti.getStanje());
		case 11: 
			return "Prikazi";
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String brojIndeksa, String ime, String prezime, Date datumRodjenja,
			String adresaStanovanja, String kontaktTelefon, String emailAdresa,
			Date datumUpisa, int trenutnaGodinaStudija,
			double prosecnaOcena, Stanje stanje){
		this.studenti.add(new Student(brojIndeksa, ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, datumUpisa, trenutnaGodinaStudija, prosecnaOcena, stanje));
	}
	
	public void izbrisiStudenta(String brojIndeksa){
		for(Student student : studenti){
			if(student.getBrojIndeksa().equals(brojIndeksa)){
				studenti.remove(student);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String brojIndeksa, String ime, String prezime, Date datumRodjenja,
			String adresaStanovanja, String kontaktTelefon, String emailAdresa,
			Date datumUpisa, int trenutnaGodinaStudija,
			double prosecnaOcena, Stanje stanje){
		for(Student student : studenti){
			if(student.getBrojIndeksa().equals(brojIndeksa)){
				student.setBrojIndeksa(brojIndeksa);
				student.setIme(ime);
				student.setPrezime(prezime);
				student.setDatumRodjenja(datumRodjenja);
				student.setAdresaStanovanja(adresaStanovanja);
				student.setKontaktTelefon(kontaktTelefon);
				student.setEmailAdresa(emailAdresa);
				student.setDatumUpisa(datumUpisa);
				student.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				student.setProsecnaOcena(prosecnaOcena);
				student.setStanje(stanje);
			}
		}
	}

}
