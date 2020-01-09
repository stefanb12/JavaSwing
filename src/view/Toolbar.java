package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import contoller.DijaloziController;
import contoller.PredmetiController;
import model.BazaPredmeta;
import view.dijalozi.DijalogDodajProfesoraNaPredmet;
import view.dijalozi.DijalogDodajStudentaNaPredmet;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -6204353317907193077L;

	public static JButton dodajStudentaNaPredmet;
	public static JButton dodajProfesoraNaPredmet;
	public static JButton obrisiProfesoraSaPredmeta;	
		
	public Toolbar() {
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
				DijaloziController.getInstance().dijaloziDodavanje();	
			}
		});
		
		
		JButton izmeni = new JButton();
		izmeni.setToolTipText("Izmeni");
		izmeni.setIcon(new ImageIcon("slike/izmeni.png"));
		leviPanel.add(izmeni);
		izmeni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				DijaloziController.getInstance().dijaloziIzmena();		
			}
		});
		
		JButton obrisi = new JButton();
		obrisi.setToolTipText("Obrisi");
		obrisi.setIcon(new ImageIcon("slike/obrisi.png"));
		leviPanel.add(obrisi);
		obrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijaloziController.getInstance().dijaloziBrisanje();	
			}
		});
		
		dodajStudentaNaPredmet = new JButton();
		dodajStudentaNaPredmet.setToolTipText("Dodaj studenta");
		dodajStudentaNaPredmet.setIcon(new ImageIcon("slike/dodajStudenta.png"));
		leviPanel.add(dodajStudentaNaPredmet);
		dodajStudentaNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PredmetiJTable.rowSelectedIndex == -1) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet na koji želite da dodate studenta");
				} else {
					DijalogDodajStudentaNaPredmet dijalog = new DijalogDodajStudentaNaPredmet(MainFrame.getInstance(), "Predmet - dodavanje studenta", true);
					dijalog.setVisible(true);	
				}
			}
		});
			
		dodajProfesoraNaPredmet = new JButton();
		dodajProfesoraNaPredmet.setToolTipText("Dodaj profesora");
		dodajProfesoraNaPredmet.setIcon(new ImageIcon("slike/dodajProfesora.png"));
		leviPanel.add(dodajProfesoraNaPredmet);
		dodajProfesoraNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(PredmetiJTable.rowSelectedIndex == -1) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite predmet na koji želite da dodate profesora");
				} else {
					DijalogDodajProfesoraNaPredmet dijalog = new DijalogDodajProfesoraNaPredmet(MainFrame.getInstance(), "Predmet - dodavanje profesora", true);
					dijalog.setVisible(true);
				}
			}
		});
		
		obrisiProfesoraSaPredmeta = new JButton();
		obrisiProfesoraSaPredmeta.setToolTipText("Obrisi profesora");
		obrisiProfesoraSaPredmeta.setIcon(new ImageIcon("slike/obrisiProfesora.png"));
		leviPanel.add(obrisiProfesoraSaPredmeta);
		obrisiProfesoraSaPredmeta.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(PredmetiJTable.rowSelectedIndex == -1) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izbarite predmet sa kog želite da obrisete profesora.");
				} else {
					if(BazaPredmeta.getInstance().getValueAt(PredmetiJTable.rowSelectedIndex, 4).equals("Nema profesora")) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(),
									"Predmet nema profesora!",
									"Greška" , JOptionPane.ERROR_MESSAGE);
					} else {
						int answer = JOptionPane
								.showConfirmDialog(MainFrame.getInstance(),
										"Da li ste sigurni da želite da obrisete profesora?",
										"Predmet - brisanje profesora", JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/obrisi.png"));
						if(answer == JOptionPane.YES_OPTION) {
							// Brisanje profesora sa predmeta
							PredmetiController.getInstance().obrisiProfesoraSaPredmeta();
						}
					}
				}
			}
		});
		
		JPanel desniPanel = new JPanel();	// desni panel za pretragu
		desniPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(desniPanel);
		 
		final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 43));
        desniPanel.add(textField);
		
		JButton pretrazi = new JButton();
		pretrazi.setToolTipText("Pretrazi");
		pretrazi.setIcon(new ImageIcon("slike/pretrazi.png"));
		desniPanel.add(pretrazi);
		pretrazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.indexTaba == 1) {
					ProfesoriJTable.prikaziPronadjeneProfesore(textField.getText());
				} else if(TabbedPane.indexTaba == 2) {
					PredmetiJTable.prikaziPronadjenePredmete(textField.getText());
				}					
			}
		});
		
	}
	
}
