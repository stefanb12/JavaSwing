package contoller;

import java.util.Date;

import view.StudentiJTable;

import model.Stanje;
import model.Student;
import model.BazaStudenata;

public class StudentiController {
	
	private static StudentiController instance = null;

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController(){}
	
	public void dodajStudenta(String brojIndeksa, String ime, String prezime, Date datumRodjenja,
			String adresaStanovanja, String kontaktTelefon, String emailAdresa,
			Date datumUpisa, int trenutnaGodinaStudija,
			double prosecnaOcena, Stanje stanje){
			BazaStudenata.getInstance().dodajStudenta(brojIndeksa, ime, prezime, datumRodjenja, 
				adresaStanovanja, kontaktTelefon, emailAdresa, datumUpisa, 
				trenutnaGodinaStudija, prosecnaOcena, stanje);
			StudentiJTable.azurirajPrikaz();
	}
	
	public void izmeniStudenta(Student student) {
		if (StudentiJTable.rowSelectedIndex < 0)
			return;
		BazaStudenata.getInstance().izmeniStudenta(student.getBrojIndeksa(), student.getIme(), 
				student.getPrezime(), student.getDatumRodjenja(), 
				student.getAdresaStanovanja(), student.getKontaktTelefon(),
				student.getEmailAdresa(),student.getDatumUpisa(),
				student.getTrenutnaGodinaStudija(), student.getProsecnaOcena(), student.getStanje());
		StudentiJTable.azurirajPrikaz();
	}
	
	public void izbrisiStudenta() {
    	if (StudentiJTable.rowSelectedIndex < 0) 
			return;
    	Student student = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		StudentiJTable.azurirajPrikaz();
    }
	

}
