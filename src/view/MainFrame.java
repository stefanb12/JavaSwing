package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import view.MenuBar;

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
		setTitle("Studentska slu�ba");
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Toolbar toolbar = new Toolbar();
		this.add(toolbar, BorderLayout.NORTH);
		
		TabbedPane tabbedPane = new TabbedPane();
		this.add(tabbedPane);
		
		StatusBar statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane
						.showConfirmDialog(MainFrame.this,
								"Da li ste sigurni da �elite da zatvorite aplikaciju?",
								"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/exit.png"));
				if(answer != JOptionPane.YES_OPTION) 
					setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				else 
					setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
			}
		}); 	
				
		setVisible(true);		
	}
}
