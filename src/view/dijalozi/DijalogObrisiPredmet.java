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

public class DijalogObrisiPredmet extends JDialog {

	private static final long serialVersionUID = 6621065629603477569L;

	public DijalogObrisiPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		setSize(400,120);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		
		JLabel labela = new JLabel("Da li ste sigurni da zelite da obrisete predmet?");
		panel.add(labela);
		this.add(panel);
		
		JPanel panelBtn = new JPanel();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		panelBtn.add(potvrda);
		panelBtn.add(odustanak);
			
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				dispose();
				JOptionPane.showMessageDialog(null, "Predmet obrisan.");
				
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
