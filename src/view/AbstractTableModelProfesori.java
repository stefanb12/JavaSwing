package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{

	private static final long serialVersionUID = 5561596262836932918L;

	public AbstractTableModelProfesori() {
		BazaProfesora.getInstance();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 10;
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column < 10) {
			return BazaProfesora.getInstance().getValueAt(row, column);
		} else {
			JButton btn = new JButton("Predmeti");
			return btn;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 10) {
			return  "Predmeti";
		}
		return BazaProfesora.getInstance().getColumnName(column);
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
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return JButton.class;
		default:
			return null;
		}
	}

}
