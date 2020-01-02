package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel{
	
	private static final long serialVersionUID = -7349770694737017202L;

	public AbstractTableModelStudenti() {
		BazaStudenata.getInstance();
	}

	@Override
	public int getColumnCount(){
		return BazaStudenata.getInstance().getColumnCount();
	}
	
	@Override
	public int getRowCount(){
		return BazaStudenata.getInstance().getStudenti().size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override 
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
}
