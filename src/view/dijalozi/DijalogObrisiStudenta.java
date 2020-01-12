package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contoller.StudentiController;

public class DijalogObrisiStudenta extends JDialog{

	private static final long serialVersionUID = 3494829882913925398L;
	
	public DijalogObrisiStudenta(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(400,120);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		
		JLabel text = new JLabel("Da li ste sigurni da želite da obrišete studenta?");
		panel.add(text);
		this.add(panel, BorderLayout.CENTER);
		
		JPanel panelBtn = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBtn.add(potvrda);
		panelBtn.add(odustanak);
			
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentiController.getInstance().izbrisiStudenta();
				dispose();
				JOptionPane.showMessageDialog(null, "Student obrisan.");
				
			}
		});
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		
		this.add(panelBtn, BorderLayout.SOUTH);
	}
	

}
