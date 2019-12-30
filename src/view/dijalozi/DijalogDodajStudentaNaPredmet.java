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

public class DijalogDodajStudentaNaPredmet extends JDialog {

	private static final long serialVersionUID = -1248890123630811112L;

	public DijalogDodajStudentaNaPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(400,140);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		GridBagConstraints gbcLabela = new GridBagConstraints();
		JLabel labela = new JLabel("Indeks studenta*");
		gbcLabela.gridx = 0;
		gbcLabela.gridy = 0;
		gbcLabela.insets = new Insets(0, 10, 0, 10);
		panel.add(labela, gbcLabela);
		
		GridBagConstraints gbcTekst = new GridBagConstraints();
		TextField imeTekst = new TextField();
		gbcTekst.gridx = 1;
		gbcTekst.gridy = 0;
		gbcTekst.weightx = 100;
		gbcTekst.fill = GridBagConstraints.HORIZONTAL;
		gbcTekst.insets = new Insets(0, 0, 0, 10);
		panel.add(imeTekst, gbcTekst);
		
		this.add(panel);
		
		JPanel panelBtn = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBtn.add(potvrda);
		panelBtn.add(odustanak);
			
		this.add(panelBtn, BorderLayout.SOUTH);
		
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				dispose();
				
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
