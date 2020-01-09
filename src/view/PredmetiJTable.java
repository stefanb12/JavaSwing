package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PredmetiJTable extends JTable {
	
	private static final long serialVersionUID = -1404313258591137307L;

	public static JTable tabelaPredmeta;
	public static AbstractTableModel modelPredmeta;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<TableModel> sortiraj;
	
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
		sortiraj = new TableRowSorter<TableModel>(this.getModel());
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
	
	public static void prikaziPronadjenePredmete(String tekstZaPretragu) {
		RowFilter<Object, Object> rf = null;
		List<RowFilter<Object, Object>> listOfFilters = new ArrayList<>();
		
		String[] delovi;
		String[] deo;
		if(tekstZaPretragu.contains(";")) {
			delovi = tekstZaPretragu.split(";");
		} else {
			delovi = new String[1];
			delovi[0] = tekstZaPretragu;
		}

		for(int i = 0; i < delovi.length; i++) {
			deo = delovi[i].split(":");
			if(deo[0].equalsIgnoreCase("šifra")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 0);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    } 
			} if(deo[0].equalsIgnoreCase("naziv")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 1); 
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("semestar")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 2);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    } 	
			} if(deo[0].equalsIgnoreCase("godinaStudijaUKojojSeIzvodi")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 3);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("predmetniProfesor")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 4);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} 
		}
		rf = RowFilter.andFilter(listOfFilters);
		sortiraj.setRowFilter(rf);
	}
}
