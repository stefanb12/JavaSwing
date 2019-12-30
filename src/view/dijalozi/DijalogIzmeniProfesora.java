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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DijalogIzmeniProfesora extends JDialog {

	private static final long serialVersionUID = -6556391612051229157L;

	public DijalogIzmeniProfesora(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(400,530);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		JLabel ime = new JLabel("Ime*    ");
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, -60, 0, 20);
		panel.add(ime, gbcIme);
		
		
		GridBagConstraints gbcImeTekst = new GridBagConstraints();
		TextField imeTekst = new TextField();
		gbcImeTekst.gridx = 1;
		gbcImeTekst.gridy = 0;
		gbcImeTekst.weightx = 100;
		gbcImeTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcImeTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(imeTekst, gbcImeTekst);
		
		imeTekst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(e.getActionCommand());
			}
		});	
		
		GridBagConstraints gbcPrezime = new GridBagConstraints();
		JLabel prezime = new JLabel("Prezime*  ");
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, -40, 0, 20);
		panel.add(prezime,gbcPrezime);
		
		GridBagConstraints gbcPrezimeTekst = new GridBagConstraints();
		TextField prezimeTekst = new TextField();
		gbcPrezimeTekst.gridx = 1;
		gbcPrezimeTekst.gridy = 1;
		gbcPrezimeTekst.weightx = 100;
		gbcPrezimeTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcPrezimeTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(prezimeTekst, gbcPrezimeTekst);
		
		
		GridBagConstraints gbcDatum = new GridBagConstraints();
		JLabel datum = new JLabel("Datum rodjenja*  ");
		gbcDatum.gridx = 0;
		gbcDatum.gridy = 2;
		gbcDatum.insets = new Insets(20, 0, 0, 20);
		panel.add(datum, gbcDatum);
		
		GridBagConstraints gbcDatumTekst = new GridBagConstraints();
		TextField datumTekst = new TextField();
		gbcDatumTekst.gridx = 1;
		gbcDatumTekst.gridy = 2;
		gbcDatumTekst.weightx = 100;
		gbcDatumTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcDatumTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(datumTekst, gbcDatumTekst);
		
		
		GridBagConstraints gbcAdresaS = new GridBagConstraints();
		JLabel adresaS = new JLabel("Adresa stanovanja*  ");
		gbcAdresaS.gridx = 0;
		gbcAdresaS.gridy = 3;
		gbcAdresaS.insets = new Insets(20, 20, 0, 20);
		panel.add(adresaS, gbcAdresaS);
		
		GridBagConstraints gbcAdresaSTekst = new GridBagConstraints();
		TextField adresaSTekst = new TextField();
		gbcAdresaSTekst.gridx = 1;
		gbcAdresaSTekst.gridy = 3;
		gbcAdresaSTekst.weightx = 100;
		gbcAdresaSTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcAdresaSTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(adresaSTekst, gbcAdresaSTekst);
		
		
		GridBagConstraints gbcTelefon = new GridBagConstraints();
		JLabel telefon = new JLabel("Broj telefona*  ");
		gbcTelefon.gridx = 0;
		gbcTelefon.gridy = 4;
		gbcTelefon.insets = new Insets(20, -14, 0, 20);
		panel.add(telefon, gbcTelefon);	
		
		GridBagConstraints gbcTelefonTekst = new GridBagConstraints();
		TextField telefonTekst = new TextField();
		gbcTelefonTekst.gridx = 1;
		gbcTelefonTekst.gridy = 4;
		gbcTelefonTekst.weightx = 100;
		gbcTelefonTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcTelefonTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(telefonTekst, gbcTelefonTekst);
		
		
		GridBagConstraints gbcMailAdr = new GridBagConstraints();
		JLabel email = new JLabel("Email adresa*  ");
		gbcMailAdr.gridx = 0;
		gbcMailAdr.gridy = 5;
		gbcMailAdr.insets = new Insets(20, -12, 0, 20);
		panel.add(email, gbcMailAdr);
		
		GridBagConstraints gbcMailAdrTekst = new GridBagConstraints();
		TextField emailTekst = new TextField();
		gbcMailAdrTekst.gridx = 1;
		gbcMailAdrTekst.gridy = 5;
		gbcMailAdrTekst.weightx = 100;
		gbcMailAdrTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcMailAdrTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(emailTekst, gbcMailAdrTekst);
		
		
		GridBagConstraints gbcAdresaK = new GridBagConstraints();
		JLabel adresaK = new JLabel("Adresa kancelarije*  ");
		gbcAdresaK.gridx = 0;
		gbcAdresaK.gridy = 6;
		gbcAdresaK.insets = new Insets(20, 20, 0, 20);
		panel.add(adresaK, gbcAdresaK);
			
		GridBagConstraints gbcAdresaKTekst = new GridBagConstraints();
		TextField adresaKTekst = new TextField();
		gbcAdresaKTekst.gridx = 1;
		gbcAdresaKTekst.gridy = 6;
		gbcAdresaKTekst.weightx = 100;
		gbcAdresaKTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcAdresaKTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(adresaKTekst, gbcAdresaKTekst);
		
		
		GridBagConstraints gbcBrojLK = new GridBagConstraints();
		JLabel brojLK = new JLabel("Broj licne karte*  ");
		gbcBrojLK.gridx = 0;
		gbcBrojLK.gridy = 7;
		gbcBrojLK.insets = new Insets(20, 0, 0, 20);
		panel.add(brojLK, gbcBrojLK);
		
		GridBagConstraints gbcBrojLKTekst = new GridBagConstraints();
		TextField brojLKTekst = new TextField();
		gbcBrojLKTekst.gridx = 1;
		gbcBrojLKTekst.gridy = 7;
		gbcBrojLKTekst.weightx = 100;
		gbcBrojLKTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcBrojLKTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(brojLKTekst, gbcBrojLKTekst);
		
		
		GridBagConstraints gbcTitula = new GridBagConstraints();
		JLabel titula = new JLabel("Titula*  ");
		gbcTitula.gridx = 0;
		gbcTitula.gridy = 8;
		gbcTitula.insets = new Insets(20, -55, 0, 20);
		panel.add(titula, gbcTitula);
		
		GridBagConstraints gbcTitulaTekst = new GridBagConstraints();
		TextField titulaTekst = new TextField();
		gbcTitulaTekst.gridx = 1;
		gbcTitulaTekst.gridy = 8;
		gbcTitulaTekst.weightx = 100;
		gbcTitulaTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcTitulaTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(titulaTekst, gbcTitulaTekst);
		
		
		GridBagConstraints gbcZvanje = new GridBagConstraints();
		JLabel zvanje = new JLabel("Zvanje*  ");
		gbcZvanje.gridx = 0;
		gbcZvanje.gridy = 9;
		gbcZvanje.insets = new Insets(20, -50, 0, 20);
		panel.add(zvanje, gbcZvanje);
		
		GridBagConstraints gbcZvanjeTekst = new GridBagConstraints();
		TextField zvanjeTekst = new TextField();
		gbcZvanjeTekst.gridx = 1;
		gbcZvanjeTekst.gridy = 9;
		gbcZvanjeTekst.weightx = 100;
		gbcZvanjeTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcZvanjeTekst.insets = new Insets(20, 0, 0, 10);
		panel.add(zvanjeTekst, gbcZvanjeTekst);	
		
		
		JPanel panelBottom = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBottom.add(potvrda);
		panelBottom.add(odustanak);
		this.add(panelBottom, BorderLayout.SOUTH);

		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				//JOptionPane.showMessageDialog(null, "Izmenili ste profesora.");
				
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
