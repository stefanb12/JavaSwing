package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;

public class DijalogPrikaziPredmeteZaProfesora extends JDialog {

	private static final long serialVersionUID = -6381888239523009805L;

	@SuppressWarnings("unchecked")
	public DijalogPrikaziPredmeteZaProfesora(Frame parent, String title, boolean modal, int rowSelectedIndeks) {
		super(parent, title, modal);
		
		setSize(300,240);
		setLocationRelativeTo(parent);
		
		String brojLicneKarte = BazaProfesora.getInstance().getRow(rowSelectedIndeks).getBrojLicneKarte();
		List<Predmet> predmetiZaProfesora =  BazaPredmeta.getInstance().predmetiZaProfesora(brojLicneKarte);
		
		BazaProfesora.getInstance().getRow(rowSelectedIndeks).setSpisakPredmeta(predmetiZaProfesora);
		List<Predmet> predmetiZaPrikaz = BazaProfesora.getInstance().getRow(rowSelectedIndeks).getSpisakPredmeta();
		
		Object[] prikazi;
		if(predmetiZaPrikaz.isEmpty()) {
			prikazi = new Object[1];
			prikazi[0] = "Ne predaje ni na jednom predmetu"; 
		} else {
			prikazi = new Object[predmetiZaPrikaz.size()];	
			int i = 0;
			for(Predmet predmet : predmetiZaPrikaz) {
				prikazi[i] = predmet.getNazivPredmeta();
				i++;
			}
		}
	
		@SuppressWarnings({ "rawtypes" })
		JList list = new JList(prikazi);
		
		list.setListData(prikazi);
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);
		panel.setSize(280,220);
		this.add(panel, BorderLayout.CENTER);
		
		JPanel panelBottom = new JPanel();
		JButton zatvori = new JButton("Zatvori");
		panelBottom.add(zatvori);
		this.add(panelBottom, BorderLayout.SOUTH);
		
		zatvori.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});	
	}

}
