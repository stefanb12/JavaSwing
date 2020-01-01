package contoller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.MainFrame;
import view.PredmetiJTable;
import view.dijalozi.DijalogDodajPredmet;
import view.dijalozi.DijalogDodajProfesora;
import view.dijalozi.DijalogDodajProfesoraNaPredmet;
import view.dijalozi.DijalogDodajStudenta;
import view.dijalozi.DijalogDodajStudentaNaPredmet;
import view.dijalozi.DijalogIzmeniPredmet;
import view.dijalozi.DijalogIzmeniProfesora;
import view.dijalozi.DijalogIzmeniStudenta;
import view.dijalozi.DijalogObrisiStudenta;

public class DijaloziController {

	private static DijaloziController instance = null;

	public static DijaloziController getInstance() {
		if (instance == null) {
			instance = new DijaloziController();
		}
		return instance;
	}
	
	public DijaloziController() {}
	
	public void dijaloziDodavanje() {
		if(view.TabbedPane.indexTaba == 0){
			DijalogDodajStudenta dialogStudent = new DijalogDodajStudenta(MainFrame.getInstance(), "Dodavanje studenta", true);
			dialogStudent.setVisible(true);
		}else if(view.TabbedPane.indexTaba == 1) {
			DijalogDodajProfesora dijalog = new DijalogDodajProfesora(MainFrame.getInstance(), "Dodavanje profesora", true);
			dijalog.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 2) {
			DijalogDodajPredmet dijalog = new DijalogDodajPredmet(MainFrame.getInstance(), "Dodavanje predmeta", true);
			dijalog.setVisible(true);
		}
	}
	
	public void dijaloziIzmena() {
		if(view.TabbedPane.indexTaba == 0){
			DijalogIzmeniStudenta dialogStudent = new DijalogIzmeniStudenta(MainFrame.getInstance(), "Izmena studenta", true);
			dialogStudent.setVisible(true);
		}else if(view.TabbedPane.indexTaba == 1) {
			DijalogIzmeniProfesora dialog = new DijalogIzmeniProfesora(MainFrame.getInstance(), "Izmena profesora", true);
			dialog.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 2) {
			if(PredmetiJTable.rowSelectedIndex == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite predmet koji zelite da izmenite.");
			} else {
				DijalogIzmeniPredmet dijalog = new DijalogIzmeniPredmet(MainFrame.getInstance(), "Izmena predmeta", true);
				dijalog.setVisible(true);
			}
		}	
	}
	
	public void dijaloziBrisanje() {
		if(view.TabbedPane.indexTaba == 0){
			DijalogObrisiStudenta dialogStudent = new DijalogObrisiStudenta(MainFrame.getInstance(), "Brisanje studenta", true);
			dialogStudent.setVisible(true);
		} else if(view.TabbedPane.indexTaba == 1) {
				int answer = JOptionPane
					.showConfirmDialog(MainFrame.getInstance(),
							"Da li ste sigurni da zelite da obrisete profesora?",
							"Brisanje profesora", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/obrisi.png"));
				if(answer == JOptionPane.YES_OPTION) {
					// Brisanje profesora
				}
		} else if(view.TabbedPane.indexTaba == 2) {
			if(PredmetiJTable.rowSelectedIndex == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite predmet koji zelite da obrisete.");
		} else {
			int answer = JOptionPane
				.showConfirmDialog(MainFrame.getInstance(),
						"Da li ste sigurni da zelite da obrisete predmet?",
						"Brisanje predmeta", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/obrisi.png"));
			if(answer == JOptionPane.YES_OPTION) {
				// Brisanje predmeta
				PredmetiController.getInstance().izbrisiPredmet();
			}
		}
		}
	}
	
	public void dijalogDodavanjeProfesoraNaPredmet() {
		DijalogDodajProfesoraNaPredmet dijalog = new DijalogDodajProfesoraNaPredmet(MainFrame.getInstance(), "Predmet - dodavanje profesora", true);
		dijalog.setVisible(true);
	} 
	
	public void dijalogDodavanjeStudentaNaPredmet() {
		DijalogDodajStudentaNaPredmet dijalog = new DijalogDodajStudentaNaPredmet(MainFrame.getInstance(), "Predmet - dodavanje studenta", true);
		dijalog.setVisible(true);
	}

}
