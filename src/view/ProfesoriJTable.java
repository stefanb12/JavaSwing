package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfesoriJTable extends JTable {

	private static final long serialVersionUID = 3177553142889336656L;
	
	public static JTable tabelaProfesora;
	public static AbstractTableModel modelProfesora;
	public static int rowSelectedIndex = -1;
	
	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new AbstractTableModelProfesori());
		modelProfesora = (AbstractTableModel)this.getModel();
		new ButtonColumnPPredmeti(this, 10);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaProfesora = (JTable)e.getComponent();
				if(tabelaProfesora.getSelectedRow() != -1) {
					rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());		
				} 
			}	
		});
		
		//setAutoCreateRowSorter(true); 
		TableRowSorter<TableModel> sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		
		sortiraj.setSortable(8, false);	
		sortiraj.setSortable(9, false);	
		sortiraj.setSortable(10, false);
		sortiraj.sort();
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public static void azurirajPrikaz() {
		modelProfesora.fireTableDataChanged();
		rowSelectedIndex = -1;	
	}

}
