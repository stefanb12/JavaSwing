package contoller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.MainFrame;
import view.PredmetiJTable;
import view.ProfesoriJTable;
import view.StudentiJTable;
import view.dijalozi.DijalogDodajPredmet;
import view.dijalozi.DijalogDodajProfesora;
import view.dijalozi.DijalogDodajStudenta;
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
			if(StudentiJTable.rowSelectedIndex == -1){
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite studenta kojeg zelite da izmenite.");
			}else {
				DijalogIzmeniStudenta dialogStudent = new DijalogIzmeniStudenta(MainFrame.getInstance(), "Izmena studenta", true);
				dialogStudent.setVisible(true);
			}
		}else if(view.TabbedPane.indexTaba == 1) {
			if(ProfesoriJTable.rowSelectedIndex == -1){
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite profesora kojeg zelite da izmenite.");
			}else{
				DijalogIzmeniProfesora dialog = new DijalogIzmeniProfesora(MainFrame.getInstance(), "Izmena profesora", true);
				dialog.setVisible(true);
			}
		} else if(view.TabbedPane.indexTaba == 2) {
			if(PredmetiJTable.rowSelectedIndex == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite predmet koji želite da izmenite.");
			} else {
				DijalogIzmeniPredmet dijalog = new DijalogIzmeniPredmet(MainFrame.getInstance(), "Izmena predmeta", true);
				dijalog.setVisible(true);
			}
		}	
	}
	
	public void dijaloziBrisanje() {
		if(view.TabbedPane.indexTaba == 0){
			if(StudentiJTable.rowSelectedIndex == -1){
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izabarite studenta kojeg zelite da obrisete.");
			}else{
				DijalogObrisiStudenta dialogStudent = new DijalogObrisiStudenta(MainFrame.getInstance(), "Brisanje studenta", true);
				dialogStudent.setVisible(true);
				}
		} else if(view.TabbedPane.indexTaba == 1) {
			if(ProfesoriJTable.rowSelectedIndex == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite profesora kojeg želite da obrisete.");
			} else {
				int answer = JOptionPane
						.showConfirmDialog(MainFrame.getInstance(),
								"Da li ste sigurni da želite da obrisete profesora?",
								"Brisanje profesora", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/obrisi.png"));
				if(answer == JOptionPane.YES_OPTION) {
					// Brisanje profesora
					ProfesoriContoller.getInstance().izbrisiProfesora();
				}
			}
		} else if(view.TabbedPane.indexTaba == 2) {
			if(PredmetiJTable.rowSelectedIndex == -1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite predmet koji želite da obrisete.");
			} else {
				int answer = JOptionPane
						.showConfirmDialog(MainFrame.getInstance(),
								"Da li ste sigurni da želite da obrisete predmet?",
								"Brisanje predmeta", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/obrisi.png"));
				if(answer == JOptionPane.YES_OPTION) {
					// Brisanje predmeta
					PredmetiController.getInstance().izbrisiPredmet();
				}
			}
		}
	}

}
