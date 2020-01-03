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

public class PredmetiJTable extends JTable {
	
	private static final long serialVersionUID = -1404313258591137307L;

	public static JTable tabelaPredmeta;
	public static AbstractTableModel modelPredmeta;
	public static int rowSelectedIndex = -1;
	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new AbstractTableModelPredmeti());
		modelPredmeta = (AbstractTableModel)this.getModel();
		new ButtonColumnPStudenti(this, 5);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaPredmeta = (JTable)e.getComponent();
				if(tabelaPredmeta.getSelectedRow() != -1) {
					rowSelectedIndex = tabelaPredmeta.convertRowIndexToModel(tabelaPredmeta.getSelectedRow());		
				} 
			}	
		});
		
		//setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		
		sortiraj.setSortable(4, false);	// Ne sortiraj kolonu sa predmetnim profesorima
		sortiraj.setSortable(5, false);	// Ne sortiraj kolonu sa listom studenata
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
		modelPredmeta.fireTableDataChanged();
		rowSelectedIndex = -1;	
	}
	
}
