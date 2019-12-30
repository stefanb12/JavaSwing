package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import contoller.DijaloziController;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -6204353317907193077L;

	public Toolbar(final JFrame parent) {
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		JPanel leviPanel = new JPanel();	// levi panel za ikonice
		leviPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(leviPanel);
	
		JButton dodaj = new JButton();
		dodaj.setToolTipText("Dodaj");
		dodaj.setIcon(new ImageIcon("slike/dodaj.png"));
		leviPanel.add(dodaj);
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijaloziController.getInstance().dijaloziDodavanje(parent);	
			}
		});
		
		
		JButton izmeni = new JButton();
		izmeni.setToolTipText("Izmeni");
		izmeni.setIcon(new ImageIcon("slike/izmeni.png"));
		leviPanel.add(izmeni);
		izmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				DijaloziController.getInstance().dijaloziIzmena(parent);		
			}
		});
		
		JButton obrisi = new JButton();
		obrisi.setToolTipText("Obrisi");
		obrisi.setIcon(new ImageIcon("slike/obrisi.png"));
		leviPanel.add(obrisi);
		obrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijaloziController.getInstance().dijaloziBrisanje(parent);	
			}
		});
		
		JButton dodajStudentaNaPredmet = new JButton();
		dodajStudentaNaPredmet.setToolTipText("Dodaj studenta");
		dodajStudentaNaPredmet.setIcon(new ImageIcon("slike/dodajStudenta.png"));
		leviPanel.add(dodajStudentaNaPredmet);
		dodajStudentaNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijaloziController.getInstance().dijalogDodavanjeStudentaNaPredmet(parent);	
			}
		});
			
		JButton dodajProfesoraNaPredmet = new JButton();
		dodajProfesoraNaPredmet.setToolTipText("Dodaj profesora");
		dodajProfesoraNaPredmet.setIcon(new ImageIcon("slike/dodajProfesora.png"));
		leviPanel.add(dodajProfesoraNaPredmet);
		dodajProfesoraNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijaloziController.getInstance().dijalogDodavanjeProfesoraNaPredmet(parent);
			}
		});
		
		// Potrebno izmeniti
		dodajStudentaNaPredmet.setVisible(true);
		dodajProfesoraNaPredmet.setVisible(true);
		
		JPanel desniPanel = new JPanel();	// desni panel za pretragu
		desniPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(desniPanel);
		 
		JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 43));
        desniPanel.add(textField);
		
		JButton pretrazi = new JButton();
		pretrazi.setToolTipText("Pretrazi");
		pretrazi.setIcon(new ImageIcon("slike/pretrazi.png"));
		desniPanel.add(pretrazi);
	}
	
}
