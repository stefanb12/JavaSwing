package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import view.MainFrame;

import model.BazaPredmeta;
import model.Predmet;
import model.Student;

public class DijalogListaStudenataNaPredmetu extends JDialog{

	private static final long serialVersionUID = -398263103792085858L;
	
	public DijalogListaStudenataNaPredmetu(Frame parent, String title, boolean modal, int rowSelectedIndeks){
		super(parent, title, modal);
		
		final Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndeks);
		
		setSize(400,250);
		setLocationRelativeTo(parent);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		final DefaultListModel<String> listaIndeksa = new DefaultListModel<>();
		if(predmet.getSpisakStudenata() == null){
			listaIndeksa.addElement("Nema studenata na ovom predmetu");
		}else if(predmet.getSpisakStudenata().size() == 0){
			listaIndeksa.addElement("Nema studenata na ovom predmetu");
		}else{
			for(Student student : predmet.getSpisakStudenata()){
				if(listaIndeksa.contains(student.getBrojIndeksa())){
					
				}else{
				listaIndeksa.addElement(student.getBrojIndeksa());
				}
			}
		}
		final JList<String> lista = new JList<String>(listaIndeksa); 
		
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setVisibleRowCount(-1);

		JScrollPane listScroller = new JScrollPane(lista);
		listScroller.setPreferredSize(new Dimension(250, 80));
		panel.add(listScroller);
		
		JPanel panelBottom = new JPanel();
		JButton obrisi = new JButton("Obrisi");
		obrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indeks = lista.getSelectedIndex();
				if(indeks == -1){
					JOptionPane.showMessageDialog(MainFrame.getInstance(),
			   				"Izaberite studenta kojeg zelite da uklonite sa predmeta", 
			   				"Dodavanje nije uspelo", JOptionPane.ERROR_MESSAGE);
				}else{
					predmet.getSpisakStudenata().remove(indeks);
					listaIndeksa.remove(indeks);
					for(Student student : predmet.getSpisakStudenata()){
						System.out.println(student.getBrojIndeksa());
					}
				}
			}
		});
		JButton nazad = new JButton("Nazad");
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		panelBottom.add(obrisi);
		panelBottom.add(nazad);
		this.add(panelBottom, BorderLayout.SOUTH);
	}
	

}
