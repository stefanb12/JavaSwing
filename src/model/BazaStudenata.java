package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import view.StudentiJTable;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance(){
		if(instance == null){
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti= new ArrayList<Student>();
	private List<String> kolone;
	
	private BazaStudenata() {
		//InitStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Broj indeksa");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rođenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Kontakt telefon");
		this.kolone.add("E-mail adresa");
		this.kolone.add("Datum upisa");
		this.kolone.add("Godina studija");
		this.kolone.add("Prosečna ocena");
		this.kolone.add("Status");

	}
	
	/*private void InitStudente(){
		this.studenti = new ArrayList<Student>();
		
		List<Predmet> predmeti = new ArrayList<Predmet>();
		studenti.add(new Student("RA 1/2019", "Luka", "Jovanović", Student.parseDate("01.01.2000."), "Karađorđeva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", 
				Student.parseDate("01.07.2019."), 1, 9.2, Stanje.B, predmeti));
		studenti.add(new Student("RA 5/2019", "Sofija", "Petrović", Student.parseDate("16.05.2000."), "Milosa Pocerca 55, Šabac", "015/343-356", "sofija.petrovic@mailinator.com", 
				Student.parseDate("11.07.2019."), 1, 8.5, Stanje.B, predmeti));
		studenti.add(new Student("RA 3/2019", "Stefan", "Nikolić", Student.parseDate("18.03.2000."), "Knez Mihajlova 16, Beograd", "011/9234-857", "stefan.nikolic@mailinator.com", 
				Student.parseDate("03.07.2019."), 1, 8.7, Stanje.B, predmeti));
		studenti.add(new Student("RA 2/2019", "Dunja", "Ilić", Student.parseDate("11.11.2000."), "Petefi Šandora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", 
				Student.parseDate("01.07.2019."), 1, 7.3, Stanje.S, predmeti));
		studenti.add(new Student("RA 4/2019", "Lazar", "Đorđević", Student.parseDate("03.12.2000."), "Josip Broz Tito 13, Subotica", "024/333-559", "lazar.djordjevic@mailinator.com", 
				Student.parseDate("06.07.2019."), 1, 8.1, Stanje.S, predmeti));
		
		studenti.add(new Student("RA 3/2018", "Sara", "Pavlović", Student.parseDate("03.12.1999."), "Vojvode Mišića 23, Šabac", "015/313-061", "sara.pavlovic@mailinator.com", 
				Student.parseDate("01.07.2018."), 2, 9.3, Stanje.B, predmeti));
		studenti.add(new Student("RA 15/2018", "Vuk", "Marković", Student.parseDate("03.12.1999."), "Temerinska 133, Novi Sad", "021/351-091", "vuk.markovic@mailinator.com", 
				Student.parseDate("11.07.2018."), 2, 8.7, Stanje.B, predmeti));
		studenti.add(new Student("RA 133/2017", "Teodora","Popović", Student.parseDate("03.12.1998."), "Surepova 15, Šabac", "015/324-500", "teodora.popovic@mailinator.com", 
				Student.parseDate("03.07.2017."), 2, 7.7, Stanje.S, predmeti));
		studenti.add(new Student("RA 122/2017", "Filip", "Stojanović", Student.parseDate("03.12.1998."), "Francuska 113, Beograd", "011/2333-900", "filip.stojanovic@mailinator.com", 
				Student.parseDate("02.07.2017."), 2, 8.0, Stanje.S, predmeti));
		studenti.add(new Student("RA 201/2017", "Ana", "Živković", Student.parseDate("03.12.1998."), "Kralja Petra 20, Novi Sad", "021/231-114", "ana.yivkovic@mailinator.com", 
				Student.parseDate("04.07.2017."), 2, 7.1, Stanje.S, predmeti));
		
		studenti.add(new Student("RA 1/2017", "Viktor", "Janković", Student.parseDate("03.12.1998."), "Gogoljeva 3, Novi Sad", "021/135-463", "viktor.jankovic@mailinator.com", 
				Student.parseDate("01.07.2017."), 3, 8.8, Stanje.B, predmeti));
		studenti.add(new Student("RA 5/2017", "Petra", "Todorović", Student.parseDate("03.12.1998."), "Njegoševa 2, Novi Sad", "021/903-463", "petra.todorovic@mailinator.com", 
				Student.parseDate("12.07.2017."), 3, 9.0, Stanje.B, predmeti));
		studenti.add(new Student("RA 33/2017", "Andrej", "Stanković", Student.parseDate("03.12.1998."), "Radoja Domanovića 5, Novi Sad", "021/731-067", "andrej.stankovic@mailinator.com", 
				Student.parseDate("19.07.2017."), 3, 6.9, Stanje.B, predmeti));
		studenti.add(new Student("RA 152/2016", "Mila", "Ristić", Student.parseDate("03.12.1997."), "Vojvode Stepe 183, Beograd", "011/4333-800", "mila.ristic@mailinator.com", 
				Student.parseDate("15.07.2016."), 3, 7.9, Stanje.S, predmeti));
		studenti.add(new Student("RA 104/2016", "Pavle", "Kostić", Student.parseDate("03.12.1997."), "Crnotravska 13, Beograd", "011/3130-007", "pavle.kostic@mailinator.com", 
				Student.parseDate("06.07.2016."), 3, 7.7, Stanje.S, predmeti));
		
		studenti.add(new Student("RA 1/2016", "Lena", "Kovačević", Student.parseDate("03.12.1997."), "Bulevar Oslobođenja 143, Novi Sad", "021/5333-801", "lena.kovacevic@mailinator.com", 
				Student.parseDate("01.07.2016."), 4, 9.8, Stanje.B, predmeti));
		studenti.add(new Student("RA 5/2016", "Filip", "Živković", Student.parseDate("03.12.1997."), "1300 Kaplara, Šabac", "015/333-500", "filip.zivkovic@mailinator.com", 
				Student.parseDate("21.07.2016."), 4, 9.3, Stanje.B, predmeti));
		studenti.add(new Student("RA 33/2015", "Tara", "Dimitrijević", Student.parseDate("03.12.1996."), "Milovana Glišića, Valjevo", "014/303-007", "tara.dimitrijevic@mailinator.com", 
				Student.parseDate("23.07.2015."), 4, 8.5, Stanje.S, predmeti));
		studenti.add(new Student("RA 102/2015", "Vasilije", "Micić", Student.parseDate("03.12.1996."), "Vuka Karadžića, Loznica", "015/101-909", "vasilije.micic@mailinator.com", 
				Student.parseDate("04.07.2015."), 4, 8.2, Stanje.S, predmeti));
		studenti.add(new Student("RA 244/2016", "Lenka", "Jović", Student.parseDate("03.12.1997."), "Bulevar Mihajla Pupina, Novi Sad", "021/431-500", "lenka.jovic@mailinator.com", 
				Student.parseDate("07.07.2016."), 4, 7.9, Stanje.S, predmeti));
	}*/
	
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
			double prosecnaOcena, Stanje stanje, List<Predmet> predmeti){
		this.studenti.add(new Student(brojIndeksa, ime, prezime, datumRodjenja, 
				adresaStanovanja, kontaktTelefon, emailAdresa, datumUpisa, 
				trenutnaGodinaStudija, prosecnaOcena, stanje, predmeti));
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
	
	@SuppressWarnings("unchecked")
	public void loadStudente(String file) {
		ObjectInputStream in = null;
		List<Student> studenti = new ArrayList<Student>();
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			studenti = (List<Student>) in.readObject();
			this.setStudenti(studenti);
			StudentiJTable.azurirajPrikaz();
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
	
	public void saveStudente(String file) {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(this.getStudenti());
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
