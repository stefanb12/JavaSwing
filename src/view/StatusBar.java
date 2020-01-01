package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	private static final long serialVersionUID = -7960319300551657388L;
	JPanel  statusBar = new JPanel();
	
	
	public StatusBar() {
		setLayout(new BorderLayout());
		
		JLabel studentstaSluzba = new JLabel(" " + "Studentska sluzba", JLabel.LEFT);
		studentstaSluzba.setForeground(Color.black);
		
		statusBar.setLayout(new BorderLayout());
		statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusBar.add(studentstaSluzba, BorderLayout.WEST);
		
		Date time = new Date();
		SimpleDateFormat date = new SimpleDateFormat("HH:mm dd.MM.yyyy");
		JLabel dateAndTime = new JLabel();
		dateAndTime.setText(date.format(time));
		
		statusBar.add(dateAndTime, BorderLayout.EAST);
		add(BorderLayout.SOUTH, statusBar);
				
	}
}
