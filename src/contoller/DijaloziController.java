package contoller;

import javax.swing.JFrame;

import view.dijalozi.DijalogDodajPredmet;
import view.dijalozi.DijalogDodajProfesora;
import view.dijalozi.DijalogDodajProfesoraNaPredmet;
import view.dijalozi.DijalogDodajStudentaNaPredmet;
import view.dijalozi.DijalogIzmeniPredmet;
import view.dijalozi.DijalogIzmeniProfesora;
import view.dijalozi.DijalogObrisiPredmet;
import view.dijalozi.DijalogObrisiProfesora;

public class DijaloziController {

	private static DijaloziController instance = null;

	public static DijaloziController getInstance() {
		if (instance == null) {
			instance = new DijaloziController(null);
		}
		return instance;
	}
	
	public DijaloziController(final JFrame parent) {}
	
	public void dijaloziDodavanje(final JFrame parent) {
		if(view.TabbedPane.indexTaba == 1) {
			DijalogDodajProfesora dijalog = new DijalogDodajProfesora(parent, "Dodavanje profesora", true);
			dijalog.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 2) {
			DijalogDodajPredmet dijalog = new DijalogDodajPredmet(parent, "Dodavanje predmeta", true);
			dijalog.setVisible(true);
		}
	}
	
	public void dijaloziIzmena(final JFrame parent) {
		if(view.TabbedPane.indexTaba == 1) {
			DijalogIzmeniProfesora dialog = new DijalogIzmeniProfesora(parent, "Izmena profesora", true);
			dialog.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 2) {
			DijalogIzmeniPredmet dijalog = new DijalogIzmeniPredmet(parent, "Izmena predmeta", true);
			dijalog.setVisible(true);
		}	
	}
	
	public void dijaloziBrisanje(final JFrame parent) {
		if(view.TabbedPane.indexTaba == 1) {
			DijalogObrisiProfesora dijalog = new DijalogObrisiProfesora(parent, "Brisanje profesora", true);
			dijalog.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 2) {
			DijalogObrisiPredmet dijalog = new DijalogObrisiPredmet(parent, "Brisanje predmeta", true);
			dijalog.setVisible(true);
		}
	}
	
	public void dijalogDodavanjeProfesoraNaPredmet(final JFrame parent) {
		DijalogDodajProfesoraNaPredmet dijalog = new DijalogDodajProfesoraNaPredmet(parent, "Predmet - dodavanje profesora", true);
		dijalog.setVisible(true);
	} 
	
	public void dijalogDodavanjeStudentaNaPredmet(final JFrame parent) {
		DijalogDodajStudentaNaPredmet dijalog = new DijalogDodajStudentaNaPredmet(parent, "Predmet - dodavanje studenta", true);
		dijalog.setVisible(true);
	}

}
