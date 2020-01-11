package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DijalogHelp extends JDialog{

	private static final long serialVersionUID = 5869375319102842099L;
	
	public DijalogHelp(Frame parent, String title, boolean modal){
		super(parent, title, modal);
		
		setSize(700 ,400);
		setLocationRelativeTo(parent);
				
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		JTextArea tekst = new JTextArea(100, 50);
		tekst.setText("Ova aplikacija predstavlja studentsku sluzbu. U ovoj aplikaciji nalaze se\n" +
				"tabele studenata, profesora i predmeta. Za dodavanje studenta treba se pozicionirati\n" +
				"na tab 'Studenti', pritisnuti dugme 'Dodaj' i upisati neophodne podatke, za izmenu studenta treba\n" +
				"se pozicionirati na tab 'Studenti' izabrati studenta iz tabele kojeg zelimo da izmenimo, stisnuti\n" +
				"dugme 'Izmeni' i izmeniti podatke po zelji , za brisanje studenta potrebno je izabrati studenta kojeg\n" +
				"zelimo da obrisemo i stisnuti dugme 'Obrisi'. Isto vazi i za postupke dodavanja, izmene i brisanja\n" +
				"profesora i predmeta. Za dodavanje studenta na predmet potrebno je pozicionirati se na tab 'Predmeti',\n" +
				"pritisnuti dugme 'Dodaj studenta' i pomocu broja indeksa dodati studenta na predmet, student mora\n" +
				"trenutno biti na godini studija na kojoj se slusa predmet na koji zelimo da dodamo studenta. Za dodavanje\n" +
				"profesora potrebno je takodje pozicionirati se na tab 'Predmeti', pritisnuti na dugme 'Dodaj profesora'\n" +
				"i pomocu broja licne karte dodati profesora na predmet. Za brisanje profesora sa predmeta potrebno je\n" +
				"pozicionirati se na tab 'Predmeti' oznaciti predmet sa kojeg zelimo da obrisemo profesora i pritisnuti dugme\n" +
				"'Obrisi profesora'\n" +
				"Pritiskom na dugme 'Prikazi' u tabeli studenata, prikazuju se predmeti koje student slusa, pritiskom\n" +
				"na dugme 'Prikazi' u tabeli profesora, prikazuju se predmeti na kojima profesor predaje\n" +
				"a pritiskom na dugme 'Prikazi' u tabeli predmeta, prikazuju se studenti koji slusaju taj predmet.\n\n" +
				"Precice: \n" +
				"CTRL + N - Dodavanje novog entiteta\n" +
				"CTRL + C - Zatvaranje aplikacije\n" +
				"CTRL + E - Izmena vec postojeceg entiteta\n" +
				"CTRL + D - Brisanje entiteta\n" +
				"CTRL + H - Help\n" +
				"CTRL + A - About\n");
		tekst.setEditable(false);
		JScrollPane skrol = new JScrollPane(tekst);
		skrol.setPreferredSize(new Dimension(610, 300));
		
		panel.add(skrol);
	}
	

}
