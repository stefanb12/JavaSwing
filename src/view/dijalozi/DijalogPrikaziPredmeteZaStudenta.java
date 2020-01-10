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
import model.BazaStudenata;
import model.Predmet;

public class DijalogPrikaziPredmeteZaStudenta extends JDialog{

	private static final long serialVersionUID = -8653241725775521417L;
	
	@SuppressWarnings("unchecked")
	public DijalogPrikaziPredmeteZaStudenta(Frame parent, String title, boolean modal, int rowSelectedIndeks) {
		super(parent, title, modal);
		
		setSize(300,240);
		setLocationRelativeTo(parent);
		
		String brojIndeksa = BazaStudenata.getInstance().getRow(rowSelectedIndeks).getBrojIndeksa();
		List<Predmet> odgovarajuciPredmeti =  BazaPredmeta.getInstance().predmetiZaStudenta(brojIndeksa);
		
		Object[] prikazi;
		if(odgovarajuciPredmeti.isEmpty()){
			prikazi = new Object[1];
			prikazi[0] = "Nije ni na jednom predmetu"; 
		}else{
			prikazi = new Object[odgovarajuciPredmeti.size()];	
			int i = 0;
			for(Predmet predmet : odgovarajuciPredmeti) {
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
