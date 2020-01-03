package contoller;

import java.util.Date;
import java.util.List;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.ProfesoriJTable;

public class ProfesoriContoller {

private static ProfesoriContoller instance = null;
	
	public static ProfesoriContoller getInstance() {
		if (instance == null) {
			instance = new ProfesoriContoller();
		}
		return instance;
	}
	
	private ProfesoriContoller() {}
	
	public void dodajProfesora(String ime, String prezime,Date datumRodjenja, String adresaStanovanja, String telefon,
			String email,String adresaKancelarije, String brojLicneKarte, String titula, String zvanje, List<Predmet> predmeti){
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, 
				adresaKancelarije, brojLicneKarte, titula, zvanje, predmeti);
		ProfesoriJTable.azurirajPrikaz();
	}
	
	public void izmeniProfesora(Profesor profesor){
		if(ProfesoriJTable.rowSelectedIndex < 0)
			return;
		BazaProfesora.getInstance().izmeniProfesora(profesor.getIme(), profesor.getPrezime(), 
				profesor.getDatumRodjenja(), profesor.getAdresaStanovanja(), 
				profesor.getKontaktTelefon(), profesor.getEmailAdresa(), profesor.getAdresaKancelarije(), 
				profesor.getBrojLicneKarte(), profesor.getTitula(), profesor.getZvanje(), profesor.getSpisakPredmeta());
		ProfesoriJTable.azurirajPrikaz();
	}
	
	public void izbrisiProfesora() {
    	if (ProfesoriJTable.rowSelectedIndex < 0) 
			return;
    	Profesor profesor = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(profesor.getBrojLicneKarte());
		ProfesoriJTable.azurirajPrikaz();
    }
}
