package view;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 8449811006505001306L;
	
	public static int indexTaba = 0;
	public static boolean tabPredmeti = false;
	
	public TabbedPane() {
		
		JScrollPane panelStudenti = new JScrollPane();
		JScrollPane panelProfesori = new JScrollPane(new ProfesoriJTable());
		JScrollPane panelPredmeti = new JScrollPane(new PredmetiJTable());
		
		this.add("Studenti", panelStudenti);
		this.add("Profesori", panelProfesori);
		this.add("Predmeti", panelPredmeti);

		prikaziDodatneBtn(tabPredmeti);
		
		this.addChangeListener(new ChangeListener() {
		
			@Override
			public void stateChanged(ChangeEvent e) {
				indexTaba = getSelectedIndex();	
                if(indexTaba == 2) {
                	tabPredmeti = true;
                	prikaziDodatneBtn(tabPredmeti);
                } else {    
                	tabPredmeti = false;
                	prikaziDodatneBtn(tabPredmeti);  
                }
			}
		});
	}
	
	public void prikaziDodatneBtn(Boolean tabPredmeti) {
		Toolbar.dodajStudentaNaPredmet.setVisible(tabPredmeti);
		Toolbar.dodajProfesoraNaPredmet.setVisible(tabPredmeti);
		Toolbar.obrisiProfesoraSaPredmeta.setVisible(tabPredmeti);
		
	}
}
