package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//MenuBar menu = new MenuBar();
		//this.setJMenuBar(menu);
		
		Toolbar toolbar = new Toolbar(this);
		this.add(toolbar, BorderLayout.NORTH);
		
		TabbedPane tabbedPane = new TabbedPane();
		this.add(tabbedPane);
		
		//StatusBar statusBar = new StatusBar();
		//this.add(statusBar, BorderLayout.SOUTH);
		
				
		setVisible(true);		
	}
}
