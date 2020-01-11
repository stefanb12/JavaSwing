package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DijalogAbout extends JDialog{

	private static final long serialVersionUID = -7425396960164704387L;
	
	public DijalogAbout(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		
		setSize(700 ,350);
		setLocationRelativeTo(parent);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		JTextArea tekst = new JTextArea(110, 60);
		tekst.setFont(new Font("Italic", Font.BOLD, 16));
		tekst.setText("Ova aplikacija predstavlja studentsku sluzbu koja u sebi sadrzi tabele i podatke\n"
				+ "o studentima, profesorima i predmetima kao i funcionalnosti koje pomazu pri rukovanju\n"
				+ "samih tabela i podataka u njima.\n\n" +
				"Autori:\n\n" +
				"Stefan Beljic je rodjen 08.12.1998. u Beogradu, zavrsio Gimnaziju Branko Radicevic\n" +
				"u Staroj Pazovi i trenutno studira na Fakultetu Tehnickih Nauka u Novom Sadu.\n\n" +
				"Aleksa Ivanic je rodjen 07.08.1998. u Zrenjaninu, zavrsio Zrenjaninsku Gimnaziju\n" +
				"i trenutno studira na Fakultetu Tehnickih Nauka u Novom Sadu.\n");
		tekst.setEditable(false);
		
		panel.add(tekst);
		
		JPanel panelBottom = new JPanel();
		JButton izadji = new JButton("Izađi");
		panelBottom.add(izadji);
		this.add(panelBottom, BorderLayout.PAGE_END);
		izadji.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
	}

}
