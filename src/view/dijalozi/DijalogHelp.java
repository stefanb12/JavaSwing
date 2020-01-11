package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		tekst.setFont(new Font("Italic", Font.BOLD, 12));
		tekst.setText("Ova aplikacija predstavlja studentsku sluzbu. U ovoj aplikaciji nalaze se\n" +
				"tabele studenata, profesora i predmeta. Za dodavanje studenta treba se pozicionirati\n" +
				"na tab 'Studenti', pritisnuti dugme 'Dodaj' i upisati neophodne podatke, za izmenu studenta treba\n" +
				"se pozicionirati na tab 'Studenti' izabrati studenta iz tabele kojeg zelimo da izmenimo, stisnuti\n" +
				"dugme 'Izmeni' i izmeniti podatke po zelji , za brisanje studenta potrebno je izabrati studenta kojeg\n" +
				"zelimo da obrisemo i stisnuti dugme 'Obrisi'. Isto vazi i za postupke dodavanja, izmene i brisanja\n" +
				"profesora i predmeta. Za dodavanje studenta na predmet potrebno je pozicionirati se na tab 'Predmeti',\n" +
				"pritisnuti dugme 'Dodaj studenta' i pomocu broja indeksa dodati studenta na predmet, student mora\n" +
				"trenutno biti na godini studija na kojoj se slusa predmet na koji zelimo da dodamo studenta. Za dodavanje\n" +
				"profesora na predmet potrebno je takodje pozicionirati se na tab 'Predmeti', pritisnuti na dugme\n'Dodaj profesora'" +
				"i pomocu broja licne karte dodati profesora na predmet. Za brisanje profesora sa predmeta\npotrebno je" +
				"pozicionirati se na tab 'Predmeti' oznaciti predmet sa kojeg zelimo da obrisemo profesora i\npritisnuti dugme" +
				"'Obrisi profesora'\n\n" +
				"Pritiskom na dugme 'Prikazi' u tabeli studenata, prikazuju se predmeti koje student slusa, pritiskom\n" +
				"na dugme 'Prikazi' u tabeli profesora, prikazuju se predmeti na kojima profesor predaje\n" +
				"a pritiskom na dugme 'Prikazi' u tabeli predmeta, prikazuju se studenti koji slusaju taj predmet.\n\n"
				+ "Ukoliko zelite da pretrazite podatke u tabeli potrebno je da odaberete tab studenti, profesori ili predmeti\n"
				+ "u zavisnosti koju tabelu zelite da pretrazite. Kada odaberete tab, potrebno je da unesete tekst za pretragu\n"
				+ "u polje za tekst koje se nalazi u gornjem desnom uglu, nakon unosa teksta pritisnuti dugme 'Pretrazi'.\n"
				+ "NAPOMENA - Tekst za pretragu uneti po sledecem obrascu:\n"
				+ "Naziv kolone(bez razmaka) : polje iz tabele koje zelite da pronadjete\n"
				+ "Ukoliko zelite da unesete vise kriterijuma pretrage, u pretragu uneti ; i ponoviti prethodni korak.\n"
				+ "Primer: Ime:Marko;Prezime:Markovic;GodinaStudija:2\n\n" +
				"Precice: \n" +
				"CTRL + N - Dodavanje novog entiteta\n" +
				"CTRL + C - Zatvaranje aplikacije\n" +
				"CTRL + E - Izmena vec postojeceg entiteta\n" +
				"CTRL + D - Brisanje entiteta\n" +
				"CTRL + H - Help\n" +
				"CTRL + A - About\n");
		tekst.setEditable(false);
		JScrollPane skrol = new JScrollPane(tekst);
		skrol.setPreferredSize(new Dimension(650, 300));
		
		panel.add(skrol);
			
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
