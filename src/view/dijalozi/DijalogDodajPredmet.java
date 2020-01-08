package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contoller.PredmetiController;
import view.MainFrame;

public class DijalogDodajPredmet extends JDialog {

	private static final long serialVersionUID = 5279286458186733561L;
	
	public DijalogDodajPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(400,300);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		GridBagConstraints gbcSifra = new GridBagConstraints();
		JLabel sifra = new JLabel("Šifra predmeta*");
		gbcSifra.gridx = 0;
		gbcSifra.gridy = 0;
		gbcSifra.insets = new Insets(10, 10, 0, 10);
		panel.add(sifra, gbcSifra);
		
		
		GridBagConstraints gbcSifraTekst = new GridBagConstraints();
		final TextField sifraTekst = new TextField();
		gbcSifraTekst.gridx = 1;
		gbcSifraTekst.gridy = 0;
		gbcSifraTekst.weightx = 100;
		gbcSifraTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcSifraTekst.insets = new Insets(10, 10, 0, 10);
		panel.add(sifraTekst, gbcSifraTekst);
		
		GridBagConstraints gbcNaziv = new GridBagConstraints();
		JLabel naziv = new JLabel("Naziv predmeta*");
		gbcNaziv.gridx = 0;
		gbcNaziv.gridy = 1;
		gbcNaziv.insets = new Insets(10, 13, 0, 10);
		panel.add(naziv, gbcNaziv);
		
		GridBagConstraints gbcNazivTekst = new GridBagConstraints();
		final TextField nazivTekst = new TextField();
		gbcNazivTekst.gridx = 1;
		gbcNazivTekst.gridy = 1;
		gbcNazivTekst.weightx = 100;
		gbcNazivTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcNazivTekst.insets = new Insets(10, 10, 0, 10);
		panel.add(nazivTekst, gbcNazivTekst);
			
		GridBagConstraints gbcSemestar = new GridBagConstraints();
		JLabel semestar = new JLabel("Semestar*");
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(10, -20, 0, 10);
		panel.add(semestar, gbcSemestar);
		
		String[] semestarTekst = {"I (prvi)", "II (drugi)", "III (treci)", "IV (cetvrti)", 
				"V (peti)", "VI (sesti)", "VII (sedmi)", "VIII (osmi)"};
		final JComboBox<String> semestarComboBox = new JComboBox<String>(semestarTekst);		
		
		GridBagConstraints gbcSemestarBox = new GridBagConstraints();
		gbcSemestarBox.gridx = 1;
		gbcSemestarBox.gridy = 2;
		gbcSemestarBox.weightx = 100;
		gbcSemestarBox.insets = new Insets(10, -79, 0, 79);
		panel.add(semestarComboBox, gbcSemestarBox);
		
		GridBagConstraints gbcGodina = new GridBagConstraints();
		JLabel godina = new JLabel("Godina*");
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(10, -32, 0, 10);
		panel.add(godina, gbcGodina);
		
		String[] godinaTekst = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		final JComboBox<String> godinaComboBox = new JComboBox<String>(godinaTekst);
		
		GridBagConstraints gbcGodinaBox = new GridBagConstraints();
		gbcGodinaBox.gridx = 1;
		gbcGodinaBox.gridy = 3;
		gbcGodinaBox.weightx = 100;
		gbcGodinaBox.insets = new Insets(10, -79, 0, 79);
		panel.add(godinaComboBox, gbcGodinaBox);
		
		JPanel panelBottom = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBottom.add(potvrda);
		panelBottom.add(odustanak);
		this.add(panelBottom, BorderLayout.PAGE_END);

		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sifraTekst.getText().isEmpty() || nazivTekst.getText().isEmpty()) 
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				else {
					
					PredmetiController.getInstance().dodajPredmet(sifraTekst.getText(), nazivTekst.getText(),
							semestarComboBox.getSelectedIndex() + 1, godinaComboBox.getSelectedIndex() + 1, null, null);
					dispose();
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nema profesora, dodajte ga ukoliko želite.",
					"Upozorenje - dodaj profesora", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
	}

}
