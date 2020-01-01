package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PredmetiTablePanel extends JPanel {
	// Panel za prikazivanje dugmeta za kolonu studenti u tabu predmeti
	private static final long serialVersionUID = -3777718742688152316L;

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	
	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	public PredmetiTablePanel(Component c, int leftGap, int rightGap) {
		this();
		leftPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		rightPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		add(c, BorderLayout.CENTER);	
	}

	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		if (leftPanel == null || rightPanel == null) 
			return;
		leftPanel.setBackground(bg);
		rightPanel.setBackground(bg);
	}

}
