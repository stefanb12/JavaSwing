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

import view.dijalozi.DijalogPrikaziPredmeteZaStudenta;

public class ButtonColumnSPredmeti extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, MouseListener{

	private static final long serialVersionUID = -4360535212458790977L;
	
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	
	public ButtonColumnSPredmeti(final JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");

		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogPrikaziPredmeteZaStudenta dijalog = new DijalogPrikaziPredmeteZaStudenta(MainFrame.getInstance(),
						"Predmeti", true, table.getSelectedRow());
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
