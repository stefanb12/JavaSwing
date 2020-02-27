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

public class StudentiJTable extends JTable{

	private static final long serialVersionUID = 3870532450326465610L;
	
	public static JTable tabelaStudenata;
	public static AbstractTableModel modelStudenta;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<TableModel> sortiraj;
	
	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		//this.setModel(new AbstractTableModelStudenti());
		this.setModel(new AbstractTableModelStudenti());
		modelStudenta = (AbstractTableModel)this.getModel();
		new ButtonColumnSPredmeti(this, 11);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaStudenata = (JTable)e.getComponent();
				if(tabelaStudenata.getSelectedRow() != -1) {
					rowSelectedIndex = tabelaStudenata.convertRowIndexToModel(tabelaStudenata.getSelectedRow());		
				} 
			}	
		});
		
		sortiraj = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sortiraj);
		
		sortiraj.sort();
		sortiraj.setSortable(11, false);
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
		modelStudenta.fireTableDataChanged();
		rowSelectedIndex = -1;	
	}
	
	public static void prikaziPronadjeneStudente(String tekstZaPretragu) {
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
			if(deo[0].equalsIgnoreCase("brojIndeksa")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 0);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    } 
			} if(deo[0].equalsIgnoreCase("ime")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 1); 
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("prezime")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 2);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    } 	
			} if(deo[0].equalsIgnoreCase("datumRodjenja")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 3);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("adresaStanovanja")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 4);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("kontaktTelefon")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 5);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("E-mailAdresa")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 6);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("datumUpisa")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 7);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("godinaStudija")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 8);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			} if(deo[0].equalsIgnoreCase("prosecnaOcena")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 9);   
			        listOfFilters.add(rf);
			    } catch (java.util.regex.PatternSyntaxException e) {
			        return;
			    }
			}if(deo[0].equalsIgnoreCase("status")) {
				try {
			        rf = RowFilter.regexFilter(deo[1], 10);   
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
