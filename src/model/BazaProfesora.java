package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import view.ProfesoriJTable;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private List<Profesor> profesori= new ArrayList<Profesor>();
	private List<String> kolone;

	private BazaProfesora() {
	
		//initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rođenja");
		this.kolone.add("Adresa stavnovanja");
		this.kolone.add("Kontakt telefon");
		this.kolone.add("E-mail adresa");
		this.kolone.add("Adresa kancelarije");
		this.kolone.add("Broj lične karte");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	/*private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		
		List<Predmet> predmeti = new ArrayList<Predmet>();
		profesori.add(new Profesor("Aleksa", "Petković", Profesor.parseDate("15.01.1965."), 
				"Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, MI 105", "007198721", "Prof. dr", "Redovni profesor", predmeti));
		profesori.add(new Profesor("Jana", "Lazarević", Profesor.parseDate("25.02.1963."), 
				"Jovana Cvijića 26, Novi Sad", "021/435-891", "jana.layarevic@mailinator.com","Dositeja Obradovića 6, Novi Sad, Nastavni blok 206", "008431903", "Prof. dr", "Redovni profesor", predmeti));
		profesori.add(new Profesor("Nađa", "Aleksić", Profesor.parseDate("23.03.1973."), 
				"Gundulićeva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor", predmeti));
		profesori.add(new Profesor("Đorđe", "Spasojević", Profesor.parseDate("24.08.1978."), 
				"Šekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com","Dositeja Obradovića 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor", predmeti));
		profesori.add(new Profesor("Elena", "Milenković", Profesor.parseDate("08.11.1985."), 
				"Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent", predmeti));
		profesori.add(new Profesor("Teodor", "Mladenović", Profesor.parseDate("14.12.1983."), 
				"Jovana Subotića 33, Novi Sad", "021/441-007", "teodor.mladenovic@mailinator.com","Dositeja Obradovića 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent", predmeti));
	}*/

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
		List<Predmet> predmetiList = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet predmet : predmetiList) {
			if(predmet.getPredmetniProfesor() != null) {
				if(predmet.getPredmetniProfesor().getBrojLicneKarte().equals(brojLicneKarte)) {
					predmet.getPredmetniProfesor().setIme(ime);
					predmet.getPredmetniProfesor().setPrezime(prezime);
					predmet.getPredmetniProfesor().setDatumRodjenja(datumRodjenja);
					predmet.getPredmetniProfesor().setAdresaStanovanja(adresaStanovanja);
					predmet.getPredmetniProfesor().setKontaktTelefon(telefon);
					predmet.getPredmetniProfesor().setEmailAdresa(email);
					predmet.getPredmetniProfesor().setAdresaKancelarije(adresaKancelarije);
					predmet.getPredmetniProfesor().setBrojLicneKarte(brojLicneKarte);
					predmet.getPredmetniProfesor().setTitula(titula);
					predmet.getPredmetniProfesor().setZvanje(zvanje);
					predmet.getPredmetniProfesor().setSpisakPredmeta(predmeti);
				}
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
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet predmet : predmeti) {
			if(predmet.getPredmetniProfesor() != null)
				if(predmet.getPredmetniProfesor().getBrojLicneKarte().equals(brojLicneKarte))
					predmet.setPredmetniProfesor(null);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadProfesore(String file) {
		ObjectInputStream in = null;
		List<Profesor> profesori = new ArrayList<Profesor>();
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			profesori = (List<Profesor>) in.readObject();
			this.setProfesori(profesori);
			ProfesoriJTable.azurirajPrikaz();
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
	
	public void saveProfesore(String file) {
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(this.getProfesori());
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
