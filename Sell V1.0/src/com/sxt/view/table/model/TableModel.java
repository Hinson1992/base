package com.sxt.view.table.model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private String[] headNames = {"","",""};

	private Vector<Vector> dataRows = new Vector<Vector>();

	public void setDataRows(Vector<Vector> dataRows) {
		this.dataRows = dataRows;
	}

	public  TableModel() {

	}

	public TableModel(String[] headNames) {
		this(headNames, new Vector<Vector>());
	}

	public TableModel(String[] headNames, Vector<Vector> dataRows) {
		this.headNames = headNames;
		this.dataRows = dataRows;
	}

	@Override
	public String getColumnName(int column) {
		return headNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataRows.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return dataRows.get(rowIndex).get(columnIndex);
	}

	/*@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}*/
	
	/*@Override
	protected boolean rowSelectionAllowed()
	{
		
	}*/
	/*@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		dataRows.get(rowIndex).set(columnIndex, aValue);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return dataRows.get(1).get(columnIndex).getClass();
	}*/
	
	

}
