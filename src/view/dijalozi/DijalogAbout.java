package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DijalogAbout extends JDialog{

	private static final long serialVersionUID = -7425396960164704387L;
	
	public DijalogAbout(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		
		setSize(800 ,500);
		setLocationRelativeTo(parent);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		JTextArea tekst = new JTextArea(100, 50);
		tekst.setText("Ova aplikacija predstavlja studentsku sluzbu.\n\n" +
				"Autori:\n\n" +
				"Stefan Beljic\n\n\n\n" +
				"Aleksa Ivanic je rodjen 7.8.1998. u Zrenjaninu, zavrsio Zrenjaninsku Gimnaziju i trenutno\n" +
				"studira na Fakultetu Tehnickih Nauka u Novom Sadu.\n");
		tekst.setEditable(false);
		JScrollPane skrol = new JScrollPane(tekst);
		skrol.setPreferredSize(new Dimension(600, 350));
		
		panel.add(skrol);
	}

}
