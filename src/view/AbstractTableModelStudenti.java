package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel{
	
	private static final long serialVersionUID = -7349770694737017202L;

	public AbstractTableModelStudenti() {
		BazaStudenata.getInstance();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 11;
	}

	@Override
	public int getColumnCount(){
		return BazaStudenata.getInstance().getColumnCount() + 1;
	}
	
	@Override
	public int getRowCount(){
		return BazaStudenata.getInstance().getStudenti().size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex < 11){
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		}else{
			JButton std = new JButton("Studenti");
			return std;
		}
	}
	
	@Override 
	public String getColumnName(int column) {
		if(column == 11){
			return "Studenti";
		}
		return BazaStudenata.getInstance().getColumnName(column);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
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
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}
	
}
