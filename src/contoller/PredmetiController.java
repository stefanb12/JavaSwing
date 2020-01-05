package contoller;

import java.util.List;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.PredmetiJTable;

public class PredmetiController {

	private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {}
	
	public void dodajPredmet(String sifra, String naziv, int semestar, int godina, Profesor profesor, List<Student> studenti) {
		BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godina, profesor, studenti);
		PredmetiJTable.azurirajPrikaz();
	}
	
	public void izmeniPredmet(Predmet predmet) {
		if (PredmetiJTable.rowSelectedIndex < 0)
			return;
		BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifraPredmeta(), predmet.getNazivPredmeta(), 
			predmet.getSemestar(), predmet.getGodinaStudija(), predmet.getPredmetniProfesor(), predmet.getSpisakStudenata());
		PredmetiJTable.azurirajPrikaz();
	}
	
    public void izbrisiPredmet() {
    	if (PredmetiJTable.rowSelectedIndex < 0) 
			return;
    	Predmet predmet = BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifraPredmeta());
		PredmetiJTable.azurirajPrikaz();
    }
    
    public void dodajProfesoraNaPredmet(String brojLicneKarte) {
    	if (PredmetiJTable.rowSelectedIndex < 0)
			return;
    	BazaPredmeta.getInstance().dodajProfesoraNaPredmet(brojLicneKarte);
    	PredmetiJTable.azurirajPrikaz();
    }
    
    public void obrisiProfesoraSaPredmeta() {
    	if (PredmetiJTable.rowSelectedIndex < 0)
			return;
    	BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex).setPredmetniProfesor(null);
		PredmetiJTable.azurirajPrikaz();
    }
}
