package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import view.dijalozi.DijalogAbout;
import view.dijalozi.DijalogHelp;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import contoller.DijaloziController;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = -111659266189879540L;
	
	public MenuBar() {
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
	
		JMenuItem novo = new JMenuItem("New");
		novo.setIcon(new ImageIcon("slike/novo.png"));
		novo.setMnemonic(KeyEvent.VK_N);
		novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		novo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijaloziController.getInstance().dijaloziDodavanje();	
			}
		});
		
		JMenuItem zatvori = new JMenuItem("Close");
		zatvori.setIcon(new ImageIcon("slike/zatvori.png"));
		zatvori.setMnemonic(KeyEvent.VK_C);
		zatvori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		zatvori.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BazaProfesora.getInstance().saveProfesore("serijalizacija/Profesori.raw");
				BazaPredmeta.getInstance().savePredmete("serijalizacija/Predmeti.raw");
				BazaStudenata.getInstance().saveStudente("serijalizacija/Studenti.raw");
				MainFrame.getInstance().dispose();	          
			}
		});
		
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(new ImageIcon("slike/edit.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijaloziController.getInstance().dijaloziIzmena();	
			}
		});
		

		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setIcon(new ImageIcon("slike/midelete.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijaloziController.getInstance().dijaloziBrisanje();	
			}
		});
	
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.setIcon(new ImageIcon("slike/help.png"));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));		
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijalogHelp dijalog = new DijalogHelp(MainFrame.getInstance(), "Help", true);
				dijalog.setVisible(true);
			}
		});
		
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.setIcon(new ImageIcon("slike/about.png"));
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));		
		miAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DijalogAbout dijalog = new DijalogAbout(MainFrame.getInstance(), "About", true);
				dijalog.setVisible(true);
			}
		});
		
		file.add(novo);
		file.addSeparator();
		file.add(zatvori);
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	
	}
	

}
