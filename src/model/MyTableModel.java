package model;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel  {
	public boolean isCellEditable(int row, int column)
    			{
					return column == 3;
    			}
	          private static final long serialVersionUID = 1L;
	          private Vector<Vector<Object>> data;
	          private Vector<String> colNames;
	          private boolean[] _columnsVisible = {true, true, true, true};

	          public MyTableModel() {
	              this.colNames = new Vector<String>();
	              this.data = new Vector<Vector<Object>>();
	          }

	          public MyTableModel(Vector<String> colnames) {
	              this.colNames = colnames;
	              this.data = new Vector<Vector<Object>>();
	          }

	          public void resetTable() {
	              this.colNames.removeAllElements();
	              this.data.removeAllElements();
	          }

	          public void setColumnNames(Vector<String> colNames) {
	              this.colNames = colNames;
	              this.fireTableStructureChanged();
	          }

	          public void addRow(Vector<Object> data) {
	              this.data.add(data);
	              this.fireTableRowsInserted(data.size() - 1, data.size() - 1);
	          }

	          public void removeRowAt(int row) {
	              this.data.removeElementAt(row);
	              this.fireTableRowsDeleted(row - 1, data.size() - 1);
	          }

	          @Override
	          public int getColumnCount() {
	              return this.colNames.size();
	          }

	          @Override
	          public Class<?> getColumnClass(int colNum) {
	              switch (colNum) {
	                  case 0:
	                      return Date.class;
	                  case 2:
	                      return Double.class;
	                  default:
	                      return String.class;
	              }
	          }


	          @Override
	          public String getColumnName(int colNum) {
	              return this.colNames.get(colNum);
	          }

	          @Override
	          public int getRowCount() {
	              return this.data.size();
	          }

	          @Override
	          public Object getValueAt(int row, int col) {
	              Vector<Object> value = this.data.get(row);
	              return value.get(col);
	          }

	          @Override
	          public void setValueAt(Object newVal, int row, int col) {
	              Vector<Object> aRow = data.elementAt(row);
	              aRow.remove(col);
	              aRow.insertElementAt(newVal, col);
	              fireTableCellUpdated(row, col);
	          }

	          public void setColumnVisible(int index, boolean visible) {
	              this._columnsVisible[index] = visible;
	              this.fireTableStructureChanged();
	          }
}
