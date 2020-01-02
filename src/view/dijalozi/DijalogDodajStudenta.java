package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import model.Stanje;
import model.Student;

import contoller.StudentiController;


public class DijalogDodajStudenta extends JDialog{

	private static final long serialVersionUID = -2576111887636022962L;
	
	public DijalogDodajStudenta(Frame parent, String title, boolean modal){
		
		super(parent, title, modal);
			
		setSize(500,630);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		JLabel ime = new JLabel("Ime*  ");
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 0, 0, 0);
		panel.add(ime, gbcIme);
		
		GridBagConstraints gbcImeTekst = new GridBagConstraints();
		final TextField imeTekst = new TextField();
		gbcImeTekst.gridx = 1;
		gbcImeTekst.gridy = 0;
		gbcImeTekst.weightx = 100;
		gbcImeTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcImeTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(imeTekst, gbcImeTekst);
		System.out.println(imeTekst.getText());
		
		GridBagConstraints gbcPrezime = new GridBagConstraints();
		JLabel prezime = new JLabel("Prezime*  ");
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 0, 0, 20);
		panel.add(prezime,gbcPrezime);
		
		GridBagConstraints gbcPrezimeTekst = new GridBagConstraints();
		final TextField prezimeTekst = new TextField();
		gbcPrezimeTekst.gridx = 1;
		gbcPrezimeTekst.gridy = 1;
		gbcPrezimeTekst.weightx = 100;
		gbcPrezimeTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcPrezimeTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(prezimeTekst, gbcPrezimeTekst);
	
		GridBagConstraints gbcDatum = new GridBagConstraints();
		JLabel datum = new JLabel("Datum rodjenja*  ");
		gbcDatum.gridx = 0;
		gbcDatum.gridy = 2;
		gbcDatum.insets = new Insets(20, 0, 0, 20);
		panel.add(datum, gbcDatum);
		
		GridBagConstraints gbcDatumTekst = new GridBagConstraints();
		final TextField datumTekst = new TextField();
		gbcDatumTekst.gridx = 1;
		gbcDatumTekst.gridy = 2;
		gbcDatumTekst.weightx = 100;
		gbcDatumTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcDatumTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(datumTekst, gbcDatumTekst);
		
		GridBagConstraints gbcAdresaS = new GridBagConstraints();
		JLabel adresaS = new JLabel("Adresa stanovanja*  ");
		gbcAdresaS.gridx = 0;
		gbcAdresaS.gridy = 3;
		gbcAdresaS.insets = new Insets(20, 0, 0, 20);
		panel.add(adresaS, gbcAdresaS);
		
		GridBagConstraints gbcAdresaSTekst = new GridBagConstraints();
		final TextField adresaSTekst = new TextField();
		gbcAdresaSTekst.gridx = 1;
		gbcAdresaSTekst.gridy = 3;
		gbcAdresaSTekst.weightx = 100;
		gbcAdresaSTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcAdresaSTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(adresaSTekst, gbcAdresaSTekst);
		
		GridBagConstraints gbcTelefon = new GridBagConstraints();
		JLabel telefon = new JLabel("Broj telefona*  ");
		gbcTelefon.gridx = 0;
		gbcTelefon.gridy = 4;
		gbcTelefon.insets = new Insets(20, 0, 0, 20);
		panel.add(telefon, gbcTelefon);	
		
		GridBagConstraints gbcTelefonTekst = new GridBagConstraints();
		final TextField telefonTekst = new TextField();
		gbcTelefonTekst.gridx = 1;
		gbcTelefonTekst.gridy = 4;
		gbcTelefonTekst.weightx = 100;
		gbcTelefonTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcTelefonTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(telefonTekst, gbcTelefonTekst);
		
		GridBagConstraints gbcBrojIndeksa = new GridBagConstraints();
		JLabel indeks = new JLabel("Broj indeksa*  ");
		gbcBrojIndeksa.gridx = 0;
		gbcBrojIndeksa.gridy = 5;
		gbcBrojIndeksa.insets = new Insets(20, 0, 0, 20);
		panel.add(indeks, gbcBrojIndeksa);
		
		GridBagConstraints gbcBrojIndeksaTekst = new GridBagConstraints();
		final TextField indeksTekst = new TextField();
		gbcBrojIndeksaTekst.gridx = 1;
		gbcBrojIndeksaTekst.gridy = 5;
		gbcBrojIndeksaTekst.weightx = 100;
		gbcBrojIndeksaTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcBrojIndeksaTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(indeksTekst, gbcBrojIndeksaTekst);
		
		GridBagConstraints gbcEmailAdresa = new GridBagConstraints();
		JLabel email = new JLabel("Email*  ");
		gbcEmailAdresa.gridx = 0;
		gbcEmailAdresa.gridy = 6;
		gbcEmailAdresa.insets = new Insets(20, 0, 0, 20);
		panel.add(email, gbcEmailAdresa);
		
		GridBagConstraints gbcEmailAdresaTekst = new GridBagConstraints();
		final TextField emailTekst = new TextField();
		gbcEmailAdresaTekst.gridx = 1;
		gbcEmailAdresaTekst.gridy = 6;
		gbcEmailAdresaTekst.weightx = 100;
		gbcEmailAdresaTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailAdresaTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(emailTekst, gbcEmailAdresaTekst);
		
		GridBagConstraints gbcUpisDatum = new GridBagConstraints();
		JLabel upisDatum = new JLabel("Datum upisa*  ");
		gbcUpisDatum.gridx = 0;
		gbcUpisDatum.gridy = 7;
		gbcUpisDatum.insets = new Insets(20, 0, 0, 20);
		panel.add(upisDatum, gbcUpisDatum);
		
		GridBagConstraints gbcUpisDatumTekst = new GridBagConstraints();
		final TextField upisTekst = new TextField();
		gbcUpisDatumTekst.gridx = 1;
		gbcUpisDatumTekst.gridy = 7;
		gbcUpisDatumTekst.weightx = 100;
		gbcUpisDatumTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcUpisDatumTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(upisTekst, gbcUpisDatumTekst);
		
		GridBagConstraints gbcProsek = new GridBagConstraints();
		JLabel prosek = new JLabel("Prosecna ocena*  ");
		gbcProsek.gridx = 0;
		gbcProsek.gridy = 8;
		gbcProsek.insets = new Insets(20, 0, 0, 20);
		panel.add(prosek, gbcProsek);
		
		GridBagConstraints gbcProsekTekst = new GridBagConstraints();
		final TextField prosekTekst = new TextField();
		gbcProsekTekst.gridx = 1;
		gbcProsekTekst.gridy = 8;
		gbcProsekTekst.weightx = 100;
		gbcProsekTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcProsekTekst.insets = new Insets(20, 0, 0, 20);
		panel.add(prosekTekst, gbcProsekTekst);
		
		GridBagConstraints gbcTrenutnaGodStud = new GridBagConstraints();
		JLabel godStud  = new JLabel("Trenutna godina studija*  ");
		gbcTrenutnaGodStud.gridx = 0;
		gbcTrenutnaGodStud.gridy = 9;
		gbcTrenutnaGodStud.insets = new Insets(20, 0, 0, 20);
		panel.add(godStud, gbcTrenutnaGodStud);
		
		GridBagConstraints gbcTrenutnaGodStuds = new GridBagConstraints();
		String[] trenutnaGod = new String[] {"I (prva)", "II (druga)","III (treca)", "IV (cetvrta)"};
		final JComboBox<String> trenutnaGodStud = new JComboBox<>(trenutnaGod);
		gbcTrenutnaGodStuds.gridx = 1;
		gbcTrenutnaGodStuds.gridy = 9;
		gbcTrenutnaGodStuds.weightx = 100;
		gbcTrenutnaGodStuds.fill = GridBagConstraints.HORIZONTAL;
		gbcTrenutnaGodStuds.insets = new Insets(20, 0, 0, 20);
		panel.add(trenutnaGodStud, gbcTrenutnaGodStuds);
		
		GridBagConstraints gbcStanjeB = new GridBagConstraints();
		final JRadioButton stanjeB = new JRadioButton("Budžet");
		gbcStanjeB.gridx = 0;
		gbcStanjeB.gridy = 10;
		gbcStanjeB.fill = GridBagConstraints.HORIZONTAL;
		gbcStanjeB.insets = new Insets(20, 0, 0, 20);
		
		GridBagConstraints gbcStanjeS = new GridBagConstraints();
		final JRadioButton stanjeS = new JRadioButton("Samofinansiranje");
		gbcStanjeS.gridx = 0;
		gbcStanjeS.gridy = 11;
		gbcStanjeS.fill = GridBagConstraints.HORIZONTAL;
		gbcStanjeS.insets = new Insets(1, 0, 0, 20);
		
		final ButtonGroup grupaD = new ButtonGroup();
		grupaD.add(stanjeB);
		grupaD.add(stanjeS);
		
		stanjeB.setActionCommand(String.valueOf(Stanje.B));
		stanjeS.setActionCommand(String.valueOf(Stanje.S));
		
		panel.add(stanjeB, gbcStanjeB);
		panel.add(stanjeS, gbcStanjeS);
		
		JPanel panelBottom = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBottom.add(potvrda);
		panelBottom.add(odustanak);
		this.add(panelBottom, BorderLayout.SOUTH);

		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentiController.getInstance().dodajStudenta(indeksTekst.getText(), imeTekst.getText(), 
						prezimeTekst.getText(), Student.parseDate(datumTekst.getText()), adresaSTekst.getText(), 
						telefonTekst.getText(), emailTekst.getText(), Student.parseDate(upisTekst.getText()), 
						trenutnaGodStud.getSelectedIndex() + 1, Double.parseDouble(prosekTekst.getText()), Stanje.valueOf(grupaD.getSelection().getActionCommand()));
				dispose();
				//JOptionPane.showMessageDialog(null, "Dodali ste studenta.");
				
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
