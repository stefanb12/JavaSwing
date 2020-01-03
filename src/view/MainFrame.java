package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaPredmeta;
import model.BazaProfesora;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1956297561304331839L;
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((3 * screenDimension.width) / 4, (3 * screenDimension.height) / 4);
		setLocationRelativeTo(null);
		setTitle("Studentska služba");
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Toolbar toolbar = new Toolbar();
		this.add(toolbar, BorderLayout.NORTH);
		
		TabbedPane tabbedPane = new TabbedPane();
		this.add(tabbedPane);
		
		StatusBar statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				BazaProfesora.getInstance().loadProfesore("serijalizacija/Profesori.raw");
				BazaPredmeta.getInstance().loadPredmete("serijalizacija/Predmeti.raw");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane
						.showConfirmDialog(MainFrame.this,
								"Da li ste sigurni da želite da zatvorite aplikaciju?",
								"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/exit.png"));
				if(answer == JOptionPane.YES_OPTION) {
					BazaProfesora.getInstance().saveProfesore("serijalizacija/Profesori.raw");
					BazaPredmeta.getInstance().savePredmete("serijalizacija/Predmeti.raw");
					setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} else { 
					setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);	
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		}); 	
				
		setVisible(true);		
	}
}
