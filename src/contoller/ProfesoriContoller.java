package contoller;

import model.BazaProfesora;
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
	
	public void izbrisiProfesora() {
    	if (ProfesoriJTable.rowSelectedIndex < 0) 
			return;
    	Profesor profesor = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(profesor.getBrojLicneKarte());
		ProfesoriJTable.azurirajPrikaz();
    }
}
