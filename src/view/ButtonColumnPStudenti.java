package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import view.dijalozi.DijalogListaStudenataNaPredmetu;

public class ButtonColumnPStudenti extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = -6607502102629194402L;
	
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;

	public ButtonColumnPStudenti(final JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		this.renderButton = new JButton("Prikaži");
		this.editorButton = new JButton("Prikaži");

		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				DijalogListaStudenataNaPredmetu dijalog = new DijalogListaStudenataNaPredmetu(MainFrame.getInstance(),
						"Studenti", true, table.getSelectedRow());
				dijalog.setVisible(true);
			}
		});

		this.isEditorActive = false;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
				
		return new ButtonTablePanel(this.renderButton, 50, 50);
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		return new ButtonTablePanel(this.editorButton, 50, 50);
	}

	@Override
	public Object getCellEditorValue() { return null; }

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
