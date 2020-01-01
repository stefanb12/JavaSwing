package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = 8454002200965331257L;
	
	public AbstractTableModelPredmeti() {
		BazaPredmeta.getInstance();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 5;
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount() + 1; 
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column < 5) {
			return BazaPredmeta.getInstance().getValueAt(row, column);
		} else {
			JButton btn = new JButton("Studenti");
			return btn;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 5) {
			return  "Studenti";
		}
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}

}
